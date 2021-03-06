package com.weibar.service.function;

import com.weibar.pojo.db.*;
import com.weibar.pojo.enu.DakaButtonEnum;
import com.weibar.pojo.enu.DakaOrderStatusEnum;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.enu.RedPackageSceneIdEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.*;
import com.weibar.service.mapper.DakaDaySummaryMapper;
import com.weibar.service.mapper.DakaOrderMapper;
import com.weibar.service.mapper.DakaUserMapper;
import com.weibar.utils.DatesUtils;
import com.weibar.utils.IdGenerator;
import com.weibar.utils.SignUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/1/31.
 */
@Service
public class DakaService {

    @Autowired
    private DakaDaySummaryMapper dakaDaySummaryMapper;

    @Autowired
    private WechatMiniProgramService wechatMiniProgramService;

    @Autowired
    private DakaOrderMapper dakaOrderMapper;

    @Autowired
    private DakaUserMapper dakaUserMapper;

    @Autowired
    private WechatPayService wechatPayService;

    @Autowired
    private PayAttachService payAttachService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserBalanceService userBalanceService;


    public static final String GAME_RULE_URL = "/pages/article/articleFree";
    public static final String MARQUEE_TEXT = "【客服微信号：反馈与建议，请您加weibar_admin微信号】";


    private static final Logger LOG = LoggerFactory.getLogger(DakaService.class);


    public static final String DAKA_INDEX_PAGE = "pages/index/index";

    public static final String DAKA_QR_SECNE = "1";






    /**
     * 下打卡订单，返回支付相关信息
     * @param sessionKey
     * @param amount
     * @param clientIp
     * @return
     * @throws BaseException
     */
    public DakaOrderPrePay createDakaOrder(String sessionKey, BigDecimal amount, String clientIp) throws BaseException {

        UserBaseInfo userBaseInfo = getUserInfoBySessionKey(sessionKey);

        LOG.info("createDakaOrder userId " + userBaseInfo.getUserId() +
                " openId " + userBaseInfo.getOpenid() +
                " nickName " + userBaseInfo.getNickname() +
                " amount " + amount + " clientIp " + clientIp);

        DakaOrder dakaOrder = checkAndInsertDakaOrder(amount,userBaseInfo,DakaOrderStatusEnum.NOT_PAY.getState());

        WechatPrePay wechatPrePay = wechatPayService.createOrder(amount.multiply(new BigDecimal(100)).intValue(),clientIp,userBaseInfo.getMiniDakaOpenid(),
                payAttachService.generateDakaOrderAttach(dakaOrder.getOrderid()));

        DakaOrderPrePay dakaOrderPrePay = new DakaOrderPrePay();
        dakaOrderPrePay.setDakaResultOrder(DakaResultOrder.getDakaResultOrder(dakaOrder));
        dakaOrderPrePay.setWechatPrePay(wechatPrePay);

        //更新打卡用户表数据
        updateDakaUserData(userBaseInfo.getUserId());

        return dakaOrderPrePay;
    }

    public DakaOrder checkAndInsertDakaOrder(BigDecimal amount,UserBaseInfo userBaseInfo,int payState) throws BaseException {
        Calendar calendar = Calendar.getInstance();
        if(calendar.get(Calendar.HOUR_OF_DAY) == 23 && calendar.get(Calendar.MINUTE) > 55){
            LOG.error("userBaseInfo userId " + userBaseInfo.getUserId() +
                    " hour of day " + calendar.get(Calendar.HOUR_OF_DAY)
                    + " MINUTE " + calendar.get(Calendar.MINUTE) + " not in daka time");
            throw BaseException.getException(ErrorCodeEnum.DAKA_NOT_PAY_TIME.getCode());
        }
        Date now = calendar.getTime();

        Date tomorrow = DatesUtils.removeTime(DateUtils.addDays(now,1));

        DakaOrderCriteria dakaOrderCriteria = new DakaOrderCriteria();
        DakaOrderCriteria.Criteria criteria = dakaOrderCriteria.createCriteria();
        criteria.andUserIdEqualTo(userBaseInfo.getUserId());
        criteria.andStatusEqualTo(DakaOrderStatusEnum.PAYED.getState());
        criteria.andOrderDateEqualTo(tomorrow);
        List<DakaOrder> orderList = dakaOrderMapper.selectByExample(dakaOrderCriteria);
        if(orderList != null && orderList.size() > 0){
            throw BaseException.getException(ErrorCodeEnum.DAKA_HAS_PAY.getCode());
        }


        DakaOrder dakaOrder = new DakaOrder();


        Long orderId = IdGenerator.generateIdByTime();
        dakaOrder.setOrderid(orderId);
        dakaOrder.setCreateTime(now);
        dakaOrder.setUpdateTime(now);
        dakaOrder.setStatus(payState);


        dakaOrder.setPayAmount(amount);
        dakaOrder.setUserId(userBaseInfo.getUserId());
        dakaOrder.setOpenid(userBaseInfo.getOpenid());
        dakaOrder.setOrderDate(DateUtils.addDays(now,1));
        dakaOrderMapper.insert(dakaOrder);
        return dakaOrder;
    }





    /**
     * 打卡接口
     * @param sessionKey
     * @throws BaseException
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public void daka(String sessionKey,String clientIp) throws BaseException {


        UserBaseInfo user = getUserInfoBySessionKey(sessionKey);
        LOG.info("daka userId " + user.getUserId() +
                " openId " + user.getOpenid() +
                " nickName " + user.getNickname() +
                 " clientIp " + clientIp);
        if(!inDakaTime()){
            throw BaseException.getException(ErrorCodeEnum.DAKA_NOT_IN_TIME.getCode());
        }


        //更新打卡订单
        Date now = new Date();

        //这里存在重复支付订单的情况
        List<DakaOrder> dakaOrders = getPayedDakaOrderByDate(user.getUserId(),now);

        for(DakaOrder dakaOrder : dakaOrders){

            if(dakaOrder.getStatus() == DakaOrderStatusEnum.DAKA_SUC.getState() ||
                    dakaOrder.getStatus() == DakaOrderStatusEnum.SEND.getState()){
                throw BaseException.getException(ErrorCodeEnum.DAKA_ORDER_HAS_SUCCESS.getCode());
            }

            dakaOrder.setUpdateTime(now);
            dakaOrder.setDakaTime(now);
            dakaOrder.setStatus(DakaOrderStatusEnum.DAKA_SUC.getState());
            dakaOrder.setClientIp(clientIp);
            dakaOrderMapper.updateByPrimaryKey(dakaOrder);

            //更新用户收入表
            DakaUser dakaUser = getDakaUser(dakaOrder.getUserId());

            //更新统计表(当天的统计表）
            DakaDaySummary dakaDaySummary = getDakaDaySummary(now);
            dakaDaySummary.setScount(dakaDaySummary.getScount() + 1);

            //早起之星
            if(dakaDaySummary.getScount() == 1){
                dakaDaySummary.setEarlyOpenId(dakaUser.getOpenid());
                dakaDaySummary.setEarlyTime(now);
                dakaDaySummary.setEarlyUserId(dakaUser.getUserId());
                dakaDaySummary.setEarlyOpenId(dakaUser.getOpenid());
                dakaDaySummary.setEarlyUserPicture(dakaUser.getUserPicture());
                dakaDaySummary.setEarlyUserName(dakaUser.getNickname());
            }

            dakaDaySummary.setUpdateTime(now);
            dakaDaySummaryMapper.updateByPrimaryKey(dakaDaySummary);
        }


        //更新打卡用户表数据
        updateDakaUserData(user.getUserId());
    }


    /**
     * 打卡我的战绩页面信息
     * @param sessionKey
     * @return
     */
    public DakaMyInfo getDakaMyInfo(String sessionKey) throws BaseException {
        DakaResultUser dakaResultUser = getDakaUserBySessionKey(sessionKey);
        List<DakaOrder> dakaOrderList = getDakaOrderByUser(dakaResultUser.getUserId());
        DakaMyInfo dakaMyInfo = new DakaMyInfo();
        dakaMyInfo.setAllPay(dakaResultUser.getPaySumAmount().setScale(2).toPlainString());
        dakaMyInfo.setAllGet(dakaResultUser.getGetSumAmount().setScale(2).toPlainString());
        dakaMyInfo.setAllSucDaka(dakaResultUser.getScount().toString());
        List<DakaSimpleOrder> simpleOrderList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        for(DakaOrder dakaOrder : dakaOrderList){

            //当天的话 设定8点2分之后之后显示结果
            if(DateUtils.isSameDay(dakaOrder.getOrderDate(),now)){
                if((calendar.get(Calendar.HOUR_OF_DAY) > 8) ||
                        (calendar.get(Calendar.HOUR_OF_DAY) == 8 && calendar.get(Calendar.MINUTE) > 2)){
                    simpleOrderList.add(new DakaSimpleOrder(dakaOrder));
                }
            }else if(dakaOrder.getOrderDate().before(now)){
                simpleOrderList.add(new DakaSimpleOrder(dakaOrder));
            }

        }
        dakaMyInfo.setDakaDetails(simpleOrderList);
        return dakaMyInfo;
    }






    /**
     * 支付成功之后回调打卡
     * @param orderId
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public void payForDaka(Long orderId) throws BaseException {

        //更新打卡订单
        DakaOrder dakaOrder = getDakaOrder(orderId);

        LOG.info("payForDaka userId " + dakaOrder.getUserId() +
                " openId " + dakaOrder.getOpenid() +
                " orderId " + orderId);



        if(dakaOrder.getStatus() != DakaOrderStatusEnum.NOT_PAY.getState()){
            throw BaseException.getException(ErrorCodeEnum.DAKA_ORDER_HAS_PAYED.getCode());
        }

        Date now = new Date();
        dakaOrder.setPayTime(now);
        dakaOrder.setStatus(DakaOrderStatusEnum.PAYED.getState());
        dakaOrder.setUpdateTime(now);
        dakaOrderMapper.updateByPrimaryKey(dakaOrder);

        //更新用户收入表
        DakaUser dakaUser = getDakaUser(dakaOrder.getUserId());
//        dakaUser.setUpdateTime(now);
//        dakaUser.setCount(dakaUser.getCount() + 1);
//        dakaUser.setPaySumAmount(dakaUser.getPaySumAmount().add(dakaOrder.getPayAmount()));
//        dakaUserMapper.updateByPrimaryKey(dakaUser);

        String consumeRemark = "每日早起打卡消费:" + dakaOrder.getPayAmount();
        userBalanceService.subtractUserBalance(dakaUser.getUserId(),dakaOrder.getPayAmount(),consumeRemark);

        //更新统计表
        DakaDaySummary dakaDaySummary = getTomorrowDakaDaySummary(now);
        dakaDaySummary.setUpdateTime(now);
        dakaDaySummary.setPayAmount(dakaDaySummary.getPayAmount().add(dakaOrder.getPayAmount()));
        dakaDaySummary.setCount(dakaDaySummary.getCount() + 1);
        dakaDaySummaryMapper.updateByPrimaryKey(dakaDaySummary);

        //更新打卡用户表数据
        updateDakaUserData(dakaUser.getUserId());
    }


    public DakaOrder getDakaOrder(Long orderId) throws BaseException {
        DakaOrderCriteria dakaOrderCriteria = new DakaOrderCriteria();
        DakaOrderCriteria.Criteria criteria = dakaOrderCriteria.createCriteria();
        criteria.andOrderidEqualTo(orderId);
        List<DakaOrder> list = dakaOrderMapper.selectByExample(dakaOrderCriteria);
        if(list != null && list.size() != 0){
            return list.get(0);
        }else{
            throw BaseException.getException(ErrorCodeEnum.DAKA_ORDER_NOT_EXIST.getCode());
        }
    }

    public List<DakaOrder> getPayedDakaOrderByDate(long userId, Date date) throws BaseException {

        date = DatesUtils.removeTime(date);

        DakaOrderCriteria dakaOrderCriteria = new DakaOrderCriteria();
        DakaOrderCriteria.Criteria criteria = dakaOrderCriteria.createCriteria();
        criteria.andOrderDateEqualTo(date);
        criteria.andUserIdEqualTo(userId);
        criteria.andStatusEqualTo(DakaOrderStatusEnum.PAYED.getState());
        List<DakaOrder> list = dakaOrderMapper.selectByExample(dakaOrderCriteria);
        if(list != null && list.size() != 0){
            return list;
        }else{
            throw BaseException.getException(ErrorCodeEnum.DAKA_ORDER_NOT_EXIST.getCode());
        }
    }


    private List<DakaOrder> getDakaOrderByUser(long userId){
        DakaOrderCriteria dakaOrderCriteria = new DakaOrderCriteria();
        DakaOrderCriteria.Criteria criteria = dakaOrderCriteria.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<Integer> invalidStatus = new ArrayList<>();
        invalidStatus.add(DakaOrderStatusEnum.NOT_PAY.getState());
        criteria.andStatusNotIn(invalidStatus);
        dakaOrderCriteria.setOrderByClause(" create_time desc ");
        List<DakaOrder> list =  dakaOrderMapper.selectByExample(dakaOrderCriteria);
        if(list == null){
            return new ArrayList<DakaOrder>();
        }else{
            return list;
        }
    }





    public DakaUser getDakaUser(Long userId) throws BaseException {
        DakaUser dakaUser =  dakaUserMapper.selectByPrimaryKey(userId);
        if(dakaUser == null){
            throw BaseException.getException(ErrorCodeEnum.DAKA_USER_NOT_EXIST.getCode());
        }
        return dakaUser;
    }


    public DakaResultUser dakaLogin(String code,String nickName, String avatarUrl,String gender,String province,String ctiy,String country) throws BaseException {
        UserBaseInfo userBaseInfo = wechatMiniProgramService.login(code,nickName,avatarUrl,gender,province,ctiy,country);
        return getDakaUser(userBaseInfo);
    }


    /**
     *
     * @param userBaseInfo
     * @return
     */
    public DakaResultUser getDakaUser(UserBaseInfo userBaseInfo){
        DakaUser dakaUser = createOrUpdateDakaUser(userBaseInfo);
        boolean hasPayTodayDakaOrder = hasPayTodayDakaOrder(dakaUser);
        boolean hasPayYesterdayDakaOrder = hasPayYesterdayDakaOrder(dakaUser);
        boolean inDakaTime = inDakaTime();
        boolean hasPayTomorrowDakaOrder = hasPayTomorrowDakaOrder(dakaUser);
        DakaButtonEnum dakaButton = getDakaButton(hasPayTodayDakaOrder,hasPayTomorrowDakaOrder,inDakaTime);

        DakaResultUser dakaResultUser = DakaResultUser.getDakaResultUserDetail(
                dakaUser,
                hasPayTodayDakaOrder,
                hasPayYesterdayDakaOrder,
                inDakaTime,
                hasPayTomorrowDakaOrder,
                dakaButton,
                GAME_RULE_URL,
                MARQUEE_TEXT
                );
        return dakaResultUser;
    }

    public DakaResultUser getDakaUserBySessionKey(String sessionKey) throws BaseException {
        return getDakaUser(getUserInfoBySessionKey(sessionKey));
    }


    public DakaButtonEnum getDakaButton(boolean hasPayTodayDakaOrder,boolean hasPayTomorrowDakaOrder,boolean inDakaTime){
        if(hasPayTodayDakaOrder && inDakaTime){
            return DakaButtonEnum.DAKA;
        }
        if(hasPayTomorrowDakaOrder){
            return DakaButtonEnum.REM_DAKA;
        }
        //这里控制是否需要付费打卡
        return DakaButtonEnum.FREE_FOR_DAKA;
    }



    private boolean hasPayTodayDakaOrder(DakaUser dakaUser){
        return hasPayOrder(dakaUser.getUserId(),Calendar.getInstance().getTime());
    }


    private boolean hasPayTomorrowDakaOrder(DakaUser dakaUser){
        return hasPayOrder(dakaUser.getUserId(),DateUtils.addDays(new Date(),1));
    }

    private boolean hasPayYesterdayDakaOrder(DakaUser dakaUser){
        return hasPayOrder(dakaUser.getUserId(),DateUtils.addDays(new Date(),-1));
    }


    private boolean hasPayOrder(Long userId,Date date){
        DakaOrderCriteria dakaOrderCriteria = new DakaOrderCriteria();
        DakaOrderCriteria.Criteria criteria = dakaOrderCriteria.createCriteria();

        date = DatesUtils.removeTime(date);

        criteria.andUserIdEqualTo(userId);
        criteria.andOrderDateEqualTo(date);
        criteria.andStatusEqualTo(DakaOrderStatusEnum.PAYED.getState());
        List<DakaOrder> dakaOrderList = dakaOrderMapper.selectByExample(dakaOrderCriteria);
        if(dakaOrderList == null || dakaOrderList.size() == 0){
            return false;
        }else{
            return true;
        }
    }


    private boolean inDakaTime(){
        Calendar calendar = Calendar.getInstance();
        if(calendar.get(Calendar.HOUR_OF_DAY) > 7 || calendar.get(Calendar.HOUR_OF_DAY) < 5){
            return false;
        }else{
            return true;
        }
    }

    public  DakaUser createOrUpdateDakaUser(UserBaseInfo userBaseInfo){
        DakaUser dakaUser = null;
        try {
            dakaUser = getDakaUser(userBaseInfo.getUserId());
        }catch (Exception e){

        }
        Date now = new Date();
        if(dakaUser == null){
            dakaUser = new DakaUser();
            dakaUser.setUserId(userBaseInfo.getUserId());
            dakaUser.setUpdateTime(now);
            dakaUser.setCity(userBaseInfo.getCity());
            dakaUser.setCount(0);
            dakaUser.setCountry(userBaseInfo.getCountry());
            dakaUser.setCreateTime(now);
            dakaUser.setFcount(0);
            dakaUser.setGetSumAmount(new BigDecimal(0));
            dakaUser.setNickname(userBaseInfo.getNickname());
            dakaUser.setOpenid(userBaseInfo.getOpenid());
            dakaUser.setProvince(userBaseInfo.getProvince());
            dakaUser.setPaySumAmount(new BigDecimal(0));
            dakaUser.setScount(0);
            dakaUser.setSex(userBaseInfo.getSex());
            dakaUser.setUserPicture(userBaseInfo.getUserPicture());
            dakaUser.setUnionId(userBaseInfo.getUnionId());
            dakaUserMapper.insert(dakaUser);
        }else{
            dakaUser.setUpdateTime(now);
            dakaUser.setCity(userBaseInfo.getCity());
            dakaUser.setCountry(userBaseInfo.getCountry());
            dakaUser.setNickname(userBaseInfo.getNickname());
            dakaUser.setProvince(userBaseInfo.getProvince());
            dakaUser.setSex(userBaseInfo.getSex());
            dakaUser.setUserPicture(userBaseInfo.getUserPicture());
            dakaUser.setUnionId(userBaseInfo.getUnionId());
            dakaUser.setOpenid(userBaseInfo.getOpenid());
            dakaUserMapper.updateByPrimaryKey(dakaUser);
        }
        return dakaUser;
    }



    public DakaDaySummary getDakaDaySummary(Date date){

        date = DatesUtils.removeTime(date);

        DakaDaySummaryCriteria daySummaryCriteria = new DakaDaySummaryCriteria();
        DakaDaySummaryCriteria.Criteria criteria = daySummaryCriteria.createCriteria();
        criteria.andDakaDateEqualTo(date);
        List<DakaDaySummary> daySummaryList =  dakaDaySummaryMapper.selectByExample(daySummaryCriteria);
        if(daySummaryList == null || daySummaryList.size() == 0){
            DakaDaySummary dakaDaySummary = new DakaDaySummary();
            Date now = new Date();
            dakaDaySummary.setDakaDate(date);
            dakaDaySummary.setCreateTime(now);
            dakaDaySummary.setUpdateTime(now);
            dakaDaySummary.setPayAmount(new BigDecimal(0));
            dakaDaySummary.setSendAmount(new BigDecimal(0));
            dakaDaySummary.setScount(0);
            dakaDaySummary.setFcount(0);
            dakaDaySummary.setCount(0);
            dakaDaySummaryMapper.insert(dakaDaySummary);
            return dakaDaySummary;
        }else{
            return daySummaryList.get(0);
        }
    }

    public DakaDaySummary getTomorrowDakaDaySummary(Date date){
        return getDakaDaySummary(DateUtils.addDays(date,1));
    }


    public DakaIndexSummary getDakaIndexSummary(){
        DakaIndexSummary dakaIndexSummary = new DakaIndexSummary();
        Date now = new Date();
        dakaIndexSummary.setTodaySummary(DakaResultDaySummary.getDakaResultDaySummary(getDakaDaySummary(now)));
        dakaIndexSummary.setTomorrowSummary(DakaResultDaySummary.getDakaResultDaySummary(getDakaDaySummary(DateUtils.addDays(now,1))));
        return dakaIndexSummary;
    }


    public static String genSessionKey(Long userId){
        return SignUtils.encryptAES(userId.toString());
    }

    public UserBaseInfo getUserInfoBySessionKey(String sessionKey) throws BaseException {
        String userIdStr = SignUtils.decryptAES(sessionKey);
        Long userId = Long.parseLong(userIdStr);
        return userService.getUserById(userId);
    }


    public List<DakaOrder> getDakaOrders(Date date,List<Integer> status){
        DakaOrderCriteria dakaOrderCriteria = new DakaOrderCriteria();
        DakaOrderCriteria.Criteria criteria = dakaOrderCriteria.createCriteria();
        criteria.andOrderDateEqualTo(date);
        criteria.andStatusIn(status);
        List<DakaOrder> list = dakaOrderMapper.selectByExample(dakaOrderCriteria);
        return list;
    }


    private List<DakaOrder> getDakaOrders(Long userId){
        DakaOrderCriteria dakaOrderCriteria = new DakaOrderCriteria();
        DakaOrderCriteria.Criteria criteria = dakaOrderCriteria.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<DakaOrder> list = dakaOrderMapper.selectByExample(dakaOrderCriteria);
        return list;
    }







    public DakaUser updateDakaUserData(Long userId) throws BaseException {
        List<DakaOrder> list = getDakaOrders(userId);
        BigDecimal paySum = new BigDecimal(0);
        BigDecimal getSum = new BigDecimal(0);
        int scount = 0;
        int fcount = 0;
        int count = 0;
        for(DakaOrder dakaOrder : list){
            if(dakaOrder.getStatus() != DakaOrderStatusEnum.NOT_PAY.getState()){
                paySum = paySum.add(dakaOrder.getPayAmount());
            }
            if(dakaOrder.getStatus() == DakaOrderStatusEnum.SEND.getState()){
                getSum = getSum.add(dakaOrder.getGetAmount());
            }
            if(dakaOrder.getStatus() == DakaOrderStatusEnum.DAKA_SUC.getState() || dakaOrder.getStatus() == DakaOrderStatusEnum.SEND.getState()){
                scount++;
            }
            if(dakaOrder.getStatus() == DakaOrderStatusEnum.DAKA_FAIL.getState()){
                fcount++;
            }
            count++;
        }
        DakaUser dakaUser = getDakaUser(userId);
        Date now = new Date();
        dakaUser.setGetSumAmount(getSum);
        dakaUser.setPaySumAmount(paySum);
        dakaUser.setUpdateTime(now);
        dakaUser.setScount(scount);
        dakaUser.setFcount(fcount);
        dakaUser.setCount(count);
        dakaUserMapper.updateByPrimaryKey(dakaUser);
        return dakaUser;

    }



    public String getQRCodeURL() throws BaseException {
        return wechatMiniProgramService.createMaQrcode(DAKA_QR_SECNE,DAKA_INDEX_PAGE);
    }



}
