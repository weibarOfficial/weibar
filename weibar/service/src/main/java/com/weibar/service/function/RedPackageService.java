package com.weibar.service.function;

import com.weibar.pojo.consts.UserBalanceTranRemark;
import com.weibar.pojo.db.*;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.enu.RedPackageDepositEnum;
import com.weibar.pojo.enu.RedPackageDetailEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.*;
import com.weibar.service.mapper.WeibarRedpackageDepositDetailMapper;
import com.weibar.service.mapper.WeibarRedpackageDepositMapper;
import com.weibar.service.mapper.WeibarRedpackageDepositTempMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by nixiaoming on 2017/11/12.
 */
@Service
public class RedPackageService {

    @Autowired
    private UserService userService;
    @Autowired
    private BarrageService barrageService;
    @Autowired
    private UserBalanceService userBalanceService;
    @Autowired
    private DiscountService discountService;
    @Autowired
    private PayAttachService payAttachService;
    @Autowired
    private WechatPayService wechatPayService;

    @Autowired
    private WeibarRedpackageDepositTempMapper weibarRedpackageDepositTempMapper;
    @Autowired
    private WeibarRedpackageDepositMapper weibarRedpackageDepositMapper;
    @Autowired
    private WeibarRedpackageDepositDetailMapper weibarRedpackageDepositDetailMapper;
    @Autowired
    private WechatRedPackageService redPackageOrderService;

    /**
     *
     * 红包下单支付前调用
     * @param userId
     * @param amount
     * @param sendNumber
     * @return
     * @throws BaseException
     */
    public RedPackageBeforePay prepareCreateRedPackage(Long merchantId,
                                                       Long userId, String amount, int sendNumber, String redPackageTitle,String userIp) throws BaseException {

        if(StringUtils.isBlank(redPackageTitle)){
            throw BaseException.getException(ErrorCodeEnum.RED_PACKAGE_TITLE_EMPTY.getCode());
        }
        UserBaseInfo userBaseInfo = userService.getUserById(userId);

        //为了简单，先用当前毫秒数作为红包ID，后续可以用统一管理的id生成器
        long redPackageId = System.currentTimeMillis();

        WeibarRedpackageDepositTemp redpackageDepositTemp = new WeibarRedpackageDepositTemp();
        Date now = new Date();
        redpackageDepositTemp.setAmount(userBalanceService.checkAndChangeAmountForPay(amount));
        redpackageDepositTemp.setCreateTime(now);
        redpackageDepositTemp.setOpenid(userBaseInfo.getOpenid());
        redpackageDepositTemp.setRedpackageid(redPackageId);
        redpackageDepositTemp.setSendnumber(checkSendNumber(sendNumber));
        redpackageDepositTemp.setUpdateTime(now);
        redpackageDepositTemp.setRedpackettitle(redPackageTitle);
        redpackageDepositTemp.setMerchantid(merchantId);
        redpackageDepositTemp.setUserId(userId);

        weibarRedpackageDepositTempMapper.insert(redpackageDepositTemp);

        RedPackageBeforePay redPackageBeforePay = new RedPackageBeforePay();
        redPackageBeforePay.setRedPackageId(redPackageId);
        BigDecimal needRechargeAmount = userBalanceService.getLeastNeedRechargeAmount(userId,amount);
        if(needRechargeAmount.compareTo(new BigDecimal(0)) > 0){
            redPackageBeforePay.setBanlanceEnough(false);
            redPackageBeforePay.setMinRechargeAmount(needRechargeAmount);
            //余额不足生成微信订单返回
            WechatPrePay wechatPrePay = wechatPayService.createOrder(needRechargeAmount.multiply(new BigDecimal(100)).intValue(),userIp,userBaseInfo.getOpenid(),
                        payAttachService.generateRedPackagePayAttach(redPackageId));
            redPackageBeforePay.setWechatMpPrePay(wechatPrePay);
        }else{
            redPackageBeforePay.setBanlanceEnough(true);
        }
        return redPackageBeforePay;
    }


    /**
     * 支付成功后调用
     * @param redPackageId
     * @throws BaseException
     */
    public BarrageInfo createRedPackage(Long redPackageId) throws BaseException {

        //判断是否已经生成过该ID的红包（如果生成则直接跳过）
        if(getRedPackageDepositByRedPackageIdFromDb(redPackageId) != null){
            throw BaseException.getException(ErrorCodeEnum.RED_PACKAGE_PACKAGE_ID_EXIST.getCode());
        }

        //从临时表中获取数据
        WeibarRedpackageDepositTempCriteria depositTempCriteria = new WeibarRedpackageDepositTempCriteria();
        WeibarRedpackageDepositTempCriteria.Criteria criteria1 = depositTempCriteria.createCriteria();
        criteria1.andRedpackageidEqualTo(redPackageId);
        List<WeibarRedpackageDepositTemp> tempList =  weibarRedpackageDepositTempMapper.selectByExample(depositTempCriteria);
        if(tempList == null || tempList.size() == 0){
            throw new BaseException(ErrorCodeEnum.RED_PACKAGE_PACKAGE_ID_NOT_EXIST.getCode(),ErrorCodeEnum.RED_PACKAGE_PACKAGE_ID_NOT_EXIST.getMsg());
        }
        WeibarRedpackageDepositTemp depositTemp = tempList.get(0);

        //扣除余额
        userBalanceService.subtractUserBalance(userService.getUserIdByOpenId(depositTemp.getOpenid()),depositTemp.getAmount(), UserBalanceTranRemark.OUT_REDPACKAGE);


        //插入正式的红包表
        WeibarRedpackageDeposit redpackageDeposit = new WeibarRedpackageDeposit();
        Date now = new Date();
        redpackageDeposit.setUpdateTime(now);
        redpackageDeposit.setSendnumber(depositTemp.getSendnumber());
        redpackageDeposit.setOpenid(depositTemp.getOpenid());
        redpackageDeposit.setAmount(discountService.getRedPackageDiscount(depositTemp.getAmount()));
        redpackageDeposit.setCreateTime(now);
        redpackageDeposit.setGetnumber(0);
        redpackageDeposit.setRedpackageid(depositTemp.getRedpackageid());
        redpackageDeposit.setStatus(RedPackageDepositEnum.NEW.getCode());
        redpackageDeposit.setRedpackettitle(depositTemp.getRedpackettitle());
        redpackageDeposit.setMerchantid(depositTemp.getMerchantid());
        redpackageDeposit.setUserId(depositTemp.getUserId());

        weibarRedpackageDepositMapper.insert(redpackageDeposit);

        //生成红包详情
        List<WeibarRedpackageDepositDetail> redpackageDepositDetails = getRedPackageDetail(redpackageDeposit.getRedpackageid(),
                redpackageDeposit.getAmount(),redpackageDeposit.getSendnumber(),redpackageDeposit.getRedpackettitle());
        for(WeibarRedpackageDepositDetail depositDetail : redpackageDepositDetails){
            weibarRedpackageDepositDetailMapper.insert(depositDetail);
        }

        //生成完成之后 更新主表状态为可领取红包状态
        WeibarRedpackageDeposit weibarRedpackageDeposit = getRedPackageDepositByRedPackageIdFromDb(redPackageId);
        weibarRedpackageDeposit.setStatus(RedPackageDepositEnum.BEGIN_GET.getCode());
        weibarRedpackageDepositMapper.updateByPrimaryKey(weibarRedpackageDeposit);

        //更新消息表
        return barrageService.addRedPackageBarrageInfo(weibarRedpackageDeposit.getMerchantid(),
                weibarRedpackageDeposit.getOpenid(),weibarRedpackageDeposit.getRedpackageid(),weibarRedpackageDeposit.getRedpackettitle(),weibarRedpackageDeposit.getAmount());
    }




    public WeibarRedpackageDeposit getRedPackageDepositByRedPackageIdFromDb(Long redPackageId){
        WeibarRedpackageDepositCriteria weibarRedpackageDepositCriteria = new WeibarRedpackageDepositCriteria();
        WeibarRedpackageDepositCriteria.Criteria criteria = weibarRedpackageDepositCriteria.createCriteria();
        criteria.andRedpackageidEqualTo(redPackageId);
        List<WeibarRedpackageDeposit> redpackageDepositList = weibarRedpackageDepositMapper.selectByExample(weibarRedpackageDepositCriteria);
        if(redpackageDepositList == null || redpackageDepositList.size() == 0){
            return null;
        }else{
            return redpackageDepositList.get(0);
        }
    }





    public WeibarRedpackageDepositDetail userOpenRedPackage(Long merchantId,Long redPackageId,Long userId,String clientIp,String sceneId) throws BaseException {

        //查看该用户是否领取过该红包
        WeibarRedpackageDepositDetail weibarRedpackageDepositDetail = getUserRedPackageDetail(redPackageId,userId);
        if(weibarRedpackageDepositDetail != null){
            return weibarRedpackageDepositDetail;
        }

        //获取未获取的红包
        List<WeibarRedpackageDepositDetail> details = getNotGetFromDb(redPackageId);

        //遍历未获取红包，发现可用的红包就返回
        for(WeibarRedpackageDepositDetail detail : details){

            //尝试更新红包详情 更新成功则表示领取成功
            WeibarRedpackageDepositDetailCriteria depositDetailCriteria = new WeibarRedpackageDepositDetailCriteria();
            WeibarRedpackageDepositDetailCriteria.Criteria c = depositDetailCriteria.createCriteria();
            c.andRedpackageidEqualTo(redPackageId);
            c.andStatusEqualTo(RedPackageDetailEnum.NOT_GET.getCode());
            c.andIdEqualTo(detail.getId());
            Date now = new Date();
            detail.setUpdateTime(now);
            UserBaseInfo userBaseInfo = userService.getUserById(userId);
            detail.setNickname(userBaseInfo.getNickname());
            detail.setStatus(RedPackageDetailEnum.GET.getCode());
            detail.setGetTime(now);
            detail.setOpenid(userBaseInfo.getOpenid());
            detail.setUserId(userBaseInfo.getUserId() );
            detail.setUserPicture(userBaseInfo.getUserPicture());

            int count = weibarRedpackageDepositDetailMapper.updateByExample(detail,depositDetailCriteria);
            if(count == 1){
                //领取成功
                //查看是否已经领取完，领取完则更新主表
                updateRedpackageDepositStatus(redPackageId);

                weibarRedpackageDepositDetail = getUserRedPackageDetail(redPackageId,userBaseInfo.getUserId());

                //增加用户余额
                userBalanceService.addUserBalance(userBaseInfo.getUserId(),detail.getAmount(),UserBalanceTranRemark.IN_USER_OPEN_REDPACKAGE);


                //记录
                barrageService.addNewUserOpenRedpackageInfo(merchantId,userBaseInfo.getOpenid(),
                        weibarRedpackageDepositDetail.getOpenid(),weibarRedpackageDepositDetail.getUserId(),weibarRedpackageDepositDetail.getAmount());

                return  detail;
            }
        }
        //所有红包都不可用
        throw BaseException.getException(ErrorCodeEnum.RED_PACKAGE_ALL_GET.getCode());
    }


    private WeibarRedpackageDeposit getRedpackageDepositFromDb(Long redpackageId) throws BaseException {
        WeibarRedpackageDepositCriteria depositCriteria = new WeibarRedpackageDepositCriteria();
        WeibarRedpackageDepositCriteria.Criteria criteria = depositCriteria.createCriteria();
        criteria.andRedpackageidEqualTo(redpackageId);
        List<WeibarRedpackageDeposit> list = weibarRedpackageDepositMapper.selectByExample(depositCriteria);
        if(list == null || list.size() == 0){
            throw new BaseException(ErrorCodeEnum.RED_PACKAGE_PACKAGE_ID_NOT_EXIST.getCode(),ErrorCodeEnum.RED_PACKAGE_PACKAGE_ID_NOT_EXIST.getMsg());
        }
        return list.get(0);
    }


    /**
     * 更新红包表 已获取的数量和状态
     * @param redpackageId
     */
    private void updateRedpackageDepositStatus(Long redpackageId) throws BaseException {

        //TODO getNum可能存在并发问题，后续改进
        WeibarRedpackageDeposit deposit = getRedpackageDepositFromDb(redpackageId);
        deposit.setUpdateTime(new Date());
        deposit.setGetnumber(deposit.getGetnumber() + 1);
        if(deposit.getGetnumber().equals(deposit.getSendnumber())){
            deposit.setStatus(RedPackageDepositEnum.END_GET.getCode());
        }

        WeibarRedpackageDepositCriteria depositCriteria = new WeibarRedpackageDepositCriteria();
        WeibarRedpackageDepositCriteria.Criteria criteria = depositCriteria.createCriteria();
        criteria.andRedpackageidEqualTo(redpackageId);
        criteria.andStatusEqualTo(RedPackageDepositEnum.BEGIN_GET.getCode());

        int count = weibarRedpackageDepositMapper.updateByExample(deposit,depositCriteria);
        if(count != 1){
            throw new BaseException(ErrorCodeEnum.RED_PACKAGE_PACKAGE_UPDATE_ERROR.getCode(),ErrorCodeEnum.RED_PACKAGE_PACKAGE_UPDATE_ERROR.getMsg());
        }
    }


    private List<WeibarRedpackageDepositDetail> getNotGetFromDb(Long redPackageId){
        WeibarRedpackageDepositDetailCriteria detailCriteria = new WeibarRedpackageDepositDetailCriteria();
        WeibarRedpackageDepositDetailCriteria.Criteria criteria = detailCriteria.createCriteria();
        criteria.andRedpackageidEqualTo(redPackageId);
        criteria.andStatusEqualTo(RedPackageDetailEnum.NOT_GET.getCode());
        List<WeibarRedpackageDepositDetail> details = weibarRedpackageDepositDetailMapper.selectByExample(detailCriteria);
        return details;
    }

    public WeibarRedpackageDepositDetail getUserRedPackageDetail(Long redPackageId,Long userId){
        if(userId == null){
            return null;
        }
        WeibarRedpackageDepositDetailCriteria detailCriteria = new WeibarRedpackageDepositDetailCriteria();
        WeibarRedpackageDepositDetailCriteria.Criteria criteria = detailCriteria.createCriteria();
        criteria.andRedpackageidEqualTo(redPackageId);
        criteria.andStatusEqualTo(RedPackageDetailEnum.GET.getCode());
        criteria.andUserIdEqualTo(userId);
        List<WeibarRedpackageDepositDetail> details = weibarRedpackageDepositDetailMapper.selectByExample(detailCriteria);
        if(details == null || details.size() == 0){
            return null;
        }else{
            return details.get(0);
        }
    }


    /**
     * 获取红包详情（只能返回已领取的红包） 红包不存在要抛异常
     * @param redPackageId
     * @return
     */
    public UserRedPackageDetail getUserRedPackageList(Long redPackageId)throws BaseException{
        WeibarRedpackageDeposit weibarRedpackageDeposit = getRedPackageDepositByRedPackageIdFromDb(redPackageId);
        if(weibarRedpackageDeposit == null){
            throw BaseException.getException(ErrorCodeEnum.RED_PACKAGE_PACKAGE_ID_NOT_EXIST.getCode());
        }

        UserBaseInfo userBaseInfo = userService.getUserById(weibarRedpackageDeposit.getUserId());

        UserRedPackageDetail userRedPackageDetail = new UserRedPackageDetail();
        userRedPackageDetail.setAmount(weibarRedpackageDeposit.getAmount());
        userRedPackageDetail.setCreateTime(weibarRedpackageDeposit.getCreateTime());
        userRedPackageDetail.setNickname(userBaseInfo.getNickname());
        userRedPackageDetail.setOpenId(userBaseInfo.getOpenid());
        userRedPackageDetail.setRedpackettitle(weibarRedpackageDeposit.getRedpackettitle());
        userRedPackageDetail.setUserPicture(userBaseInfo.getUserPicture());

        userRedPackageDetail.setSendNumber(weibarRedpackageDeposit.getSendnumber());
        userRedPackageDetail.setGetNumber(weibarRedpackageDeposit.getGetnumber());

        WeibarRedpackageDepositDetailCriteria detailCriteria = new WeibarRedpackageDepositDetailCriteria();
        WeibarRedpackageDepositDetailCriteria.Criteria criteria = detailCriteria.createCriteria();
        criteria.andRedpackageidEqualTo(redPackageId);
        criteria.andStatusEqualTo(RedPackageDetailEnum.GET.getCode());
        List<WeibarRedpackageDepositDetail> details = weibarRedpackageDepositDetailMapper.selectByExample(detailCriteria);
        List<UserRedPackage> userRedPackageList = new ArrayList<>();
        for(WeibarRedpackageDepositDetail weibarRedpackageDepositDetail : details ){
            userRedPackageList.add(UserRedPackage.getUserRedPackage(weibarRedpackageDepositDetail));
        }
        userRedPackageDetail.setUserRedPackageList(userRedPackageList);
        return userRedPackageDetail;

    }





    private int checkSendNumber(int sendNumber) throws BaseException {
        if(sendNumber < 1 || sendNumber > 200){
            throw BaseException.getException(ErrorCodeEnum.RED_PACKAGE_SEND_NUMBER_ERROR.getCode());
        }
        return sendNumber;
    }


    /**
     * 获取红包详情列表
     * @param redPackageId
     * @param amount
     * @param sendNum
     * @return
     */
    public List<WeibarRedpackageDepositDetail> getRedPackageDetail(Long redPackageId,BigDecimal amount,int sendNum,String title){

        //找出红包最佳
        List<BigDecimal> redPackageAmounts = getRedPackageAmountList(amount,sendNum,false);
        BigDecimal bestAmount = new BigDecimal(0);
        for(BigDecimal redPackageAmount : redPackageAmounts){
            if(redPackageAmount.compareTo(bestAmount) > 0){
                bestAmount = redPackageAmount;
            }
        }
        //生成结果
        List<WeibarRedpackageDepositDetail> result = new ArrayList<>();
        Date now = new Date();
        for(BigDecimal redPackageAmount : redPackageAmounts){
            WeibarRedpackageDepositDetail depositDetail = new WeibarRedpackageDepositDetail();
            depositDetail.setRedpackageid(redPackageId);
            depositDetail.setCreateTime(now);
            depositDetail.setAmount(redPackageAmount);
            if(redPackageAmount.compareTo(bestAmount) == 0){
                depositDetail.setIsBest(1);
            }else{
                depositDetail.setIsBest(0);
            }
            depositDetail.setUpdateTime(now);
            depositDetail.setStatus(RedPackageDetailEnum.NOT_GET.getCode());
            depositDetail.setRedpackettitle(title);
            result.add(depositDetail);
        }
        return result;
    }


    /**
     * 切分红包算法
     * @param amount
     * @param sendNum
     * @return
     */
    public List<BigDecimal> getRedPackageAmountList(BigDecimal amount,int sendNum,boolean hasZero){

        //按照分，分成固定份数
        long num = amount.multiply(new BigDecimal(100)).longValue();

        //最低必须剩余份数
        int least = sendNum;
        if(!hasZero){
            least = 0;
        }

        List<BigDecimal> result = new ArrayList<>();


        while (result.size() < sendNum){

            //倒数第一份要特殊处理
            if(result.size() == (sendNum - 1)){
                long get = num;
                result.add(new BigDecimal(get).divide(new BigDecimal(100)));
                break;
            }

            long maxCanGet = Math.min(num - least,num);

            long get = 0;
            //针对可以为0的处理
            if(maxCanGet > 0) {
                get = ThreadLocalRandom.current().nextLong(0, maxCanGet );
            }

           //针对不能为0的处理
            if(!hasZero && get == 0){
                get = 1;
            }

            //扣除相应份数
            num = num - get;
            //少了一个红包，最低剩余份数可以减1
            least--;

            result.add(new BigDecimal(get).divide(new BigDecimal(100)));

        }
        Collections.shuffle(result);
        return result;
    }


    //for test
//    public static void main(String[] args){
//        int k = 100;
//        while(k > 0) {
//            k--;
//            RedPackageService redPackageService = new RedPackageService();
//            List<BigDecimal> result = redPackageService.getRedPackageAmountList(new BigDecimal(10.21), 10);
//            System.out.println(result);
//            BigDecimal sum = new BigDecimal(0);
//            for (int i = 0; i < result.size(); i++) {
//                sum = sum.add(result.get(i));
//            }
//            System.out.println(sum);
//        }
//    }
}
