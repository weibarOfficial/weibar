package com.weibar.service.function;

import com.weibar.pojo.db.*;
import com.weibar.pojo.enu.BarpinThemeEnum;
import com.weibar.pojo.enu.BarrageStatusEnum;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.enu.UserConsumeTypeEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.*;
import com.weibar.service.mapper.WeibarMerchantsPriceTimeSettingInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 霸屏
 * Created by Administrator on 2017/11/21.
 */
@Service
public class BarpinService {


    @Autowired
    private UserBalanceService userBalanceService;
    @Autowired
    private BarrageService barrageService;
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private UserConsumeOrderService userConsumeOrderService;
    @Autowired
    private UserService userService;

    @Autowired
    private WechatPayService wechatPayService;
    @Autowired
    private PayAttachService payAttachService;

    @Autowired
    private SharingRatioService sharingRatioService;
    @Autowired
    private PriceTimeService priceTimeService;



    public List<BarpinTheme> getTitles(){

        return BarpinThemeEnum.getBarpinThemes(BarpinThemeEnum.values());
    }














    /**
     * 霸屏成功要修改那条消息并插入特效表
     * @param merchantId 商户ID
     * @param messageId 霸屏消息ID
     * @param second 霸屏秒数
     * @param userId 用户ID
     * @param times 霸屏次数
     */
    public BarpinResult barpin(Long merchantId, Long messageId, Integer second, Long userId, Integer times,String userIp,Integer theme,String content) throws BaseException {

        BarpinResult barpinResult = new BarpinResult();

        WeibarMerchantsBarrageInfo barrageInfo = barrageService.getBarrageById(messageId);
        //判断是否已经霸屏
        if(barrageInfo.getStatus().equals(BarrageStatusEnum.BA.getState())){
            throw BaseException.getException(ErrorCodeEnum.BARPING_ERROR_HAS_BA.getCode());
        }

        PriceTimeSettingInfo priceTimeSettingInfo = priceTimeService.getPriceTimeSettingInfoById(merchantId,second);

        BigDecimal needPayAmount = priceTimeSettingInfo.getPrice().multiply(new BigDecimal(times));

        UserBaseInfo userBaseInfo = userService.getUserById(userId);

        UserAccountBalance userAccountBalance = userBalanceService.getBalanceAccountByUserId(userId);

        //判断余额是否充足
        if(userAccountBalance.getBalance().compareTo(needPayAmount) < 0){
            barpinResult.setBanlanceEnough(false);
            BigDecimal minRechargeAmount =  needPayAmount.subtract(userAccountBalance.getBalance());
            barpinResult.setMinRechargeAmount(minRechargeAmount);
            //余额不足生成微信订单返回
            WechatPrePay wechatMpPrePay = wechatPayService.createOrder(minRechargeAmount.multiply(new BigDecimal(100)).intValue(),userIp,userBaseInfo.getOpenid(),
                    payAttachService.generateBapinPayAttach(merchantId,messageId,second,userId,times,userIp,theme,content));
            barpinResult.setWechatMpPrePay(wechatMpPrePay);
            return barpinResult;
        }


        // 扣除余额


        WeibarMerchantsBaseInfo merchantsBaseInfo = merchantService.getMerchantInfoFromDb(merchantId);

        String remark = " 在酒吧 " + merchantsBaseInfo.getMerchantsName()
                +  " 霸屏" + second.toString() + "秒 * " + times.toString();

        userBalanceService.subtractUserBalance(userId,needPayAmount,remark);



        //记录消费表
        UserConsumeTypeEnum userConsumeType = null;
        if(userId.equals(barrageInfo.getUserId())){
            userConsumeType = UserConsumeTypeEnum.BAR_FOR_SELF;
        }else{
            userConsumeType = UserConsumeTypeEnum.BAR_FOR_OTHER;
        }
        UserConsumeOrder userConsumeOrder = userConsumeOrderService.createUserConsumeOrder(merchantId,userId,barrageInfo.getUserId(),
                needPayAmount,new Date(),new Long(priceTimeSettingInfo.getTimeId()),priceTimeSettingInfo.getTimeDesc(),times,userConsumeType,userIp);

        //修改消息
        barrageInfo.setStatus(BarrageStatusEnum.BA.getState());
        barrageInfo.setUpdateTime(new Date());
        barrageInfo.setScreenNum(times);
        barrageInfo.setTimesid(second);
        barrageInfo.setBarContent(content);
        barrageInfo.setBarpinOpenid(userBaseInfo.getOpenid());
        barrageInfo.setBarpinUserId(userBaseInfo.getUserId());
        barrageInfo.setBarpinUserName(userBaseInfo.getNickname());
        barrageInfo.setBarpinTheme(theme);

        barrageService.updateBarrage(barrageInfo);
        barpinResult.setBarrageInfo(BarrageInfo.formBarrageInfo(barrageInfo));
        barpinResult.setBanlanceEnough(true);

        sharingRatioService.shareBarpin(needPayAmount,merchantId,new Long(userConsumeOrder.getId()));
        return barpinResult;
    }

}
