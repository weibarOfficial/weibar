package com.weibar.service.function;

import com.weibar.pojo.db.*;
import com.weibar.pojo.enu.DakaOrderStatusEnum;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.*;
import com.weibar.service.mapper.DakaDaySummaryMapper;
import com.weibar.service.mapper.DakaOrderMapper;
import com.weibar.service.mapper.DakaUserMapper;
import com.weibar.utils.IdGenerator;
import com.weibar.utils.SignUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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


    /**
     * 下打卡订单，返回支付相关信息
     * @param sessionKey
     * @param amount
     * @param clientIp
     * @return
     * @throws BaseException
     */
    public DakaOrderPrePay createDakaOrder(String sessionKey, BigDecimal amount, String clientIp) throws BaseException {
        DakaOrder dakaOrder = new DakaOrder();
        Date now = new Date();
        UserBaseInfo userBaseInfo = getUserInfoBySessionKey(sessionKey);
        Long orderId = IdGenerator.generateIdByTime();
        dakaOrder.setOrderid(orderId);
        dakaOrder.setCreateTime(now);
        dakaOrder.setUpdateTime(now);
        dakaOrder.setStatus(DakaOrderStatusEnum.NOT_PAY.getState());
        dakaOrder.setPayAmount(amount);
        dakaOrder.setUserId(userBaseInfo.getUserId());
        dakaOrder.setOpenid(userBaseInfo.getOpenid());
        dakaOrder.setOrderDate(DateUtils.addDays(now,1));
        dakaOrderMapper.insert(dakaOrder);

        WechatPrePay wechatPrePay = wechatPayService.createOrder(amount.multiply(new BigDecimal(100)).intValue(),clientIp,userBaseInfo.getMiniDakaOpenid(),
                payAttachService.generateDakaOrderAttach(orderId));

        DakaOrderPrePay dakaOrderPrePay = new DakaOrderPrePay();
        dakaOrderPrePay.setDakaResultOrder(DakaResultOrder.getDakaResultOrder(dakaOrder));
        dakaOrderPrePay.setWechatPrePay(wechatPrePay);
        return dakaOrderPrePay;
    }


    public void daka(String sessionKey) throws BaseException {
        Date now = new Date();
        UserBaseInfo user = getUserInfoBySessionKey(sessionKey);
        DakaOrder dakaOrder = getDakaOrderByDate(user.getUserId(),now);
        dakaOrder.setUpdateTime(now);
        //dakaOrder.setStatus(DakaOrderStatusEnum.PAYED);
    }





    /**
     * 支付成功之后回调打卡
     * @param orderId
     */
    public void payForDaka(Long orderId) throws BaseException {

        //更新打卡订单
        DakaOrder dakaOrder = getDakaOrder(orderId);
        Date now = new Date();
        dakaOrder.setPayTime(now);
        dakaOrder.setStatus(DakaOrderStatusEnum.PAYED.getState());
        dakaOrder.setUpdateTime(now);
        dakaOrderMapper.updateByPrimaryKey(dakaOrder);

        //更新用户收入表
        DakaUser dakaUser = getDakaUser(dakaOrder.getUserId());
        dakaUser.setUpdateTime(now);
        dakaUser.setPaySumAmount(dakaUser.getPaySumAmount().add(dakaOrder.getPayAmount()));
        dakaUserMapper.updateByPrimaryKey(dakaUser);

        //更新统计表
        DakaDaySummary dakaDaySummary = getTomorrowDakaDaySummary(now);
        dakaDaySummary.setUpdateTime(now);
        dakaDaySummary.setPayAmount(dakaDaySummary.getPayAmount().add(dakaOrder.getPayAmount()));
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

    public DakaOrder getDakaOrderByDate(long userId,Date date) throws BaseException {
        DakaOrderCriteria dakaOrderCriteria = new DakaOrderCriteria();
        DakaOrderCriteria.Criteria criteria = dakaOrderCriteria.createCriteria();
        criteria.andOrderDateEqualTo(date);
        criteria.andUserIdEqualTo(userId);
        List<DakaOrder> list = dakaOrderMapper.selectByExample(dakaOrderCriteria);
        if(list != null && list.size() != 0){
            return list.get(0);
        }else{
            throw BaseException.getException(ErrorCodeEnum.DAKA_ORDER_NOT_EXIST.getCode());
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
        DakaUser dakaUser = createOrUpdateDakaUser(userBaseInfo);
        DakaResultUser dakaResultUser = DakaResultUser.getDakaResultUser(dakaUser);
        return dakaResultUser;
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



    private DakaDaySummary getDakaDaySummary(Date date){
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

    private DakaDaySummary getTomorrowDakaDaySummary(Date date){
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



}
