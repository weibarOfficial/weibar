package com.weibar.service.function;

import com.weibar.pojo.db.*;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.enu.GiveTypeEnum;
import com.weibar.pojo.enu.UserConsumeTypeEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.*;
import com.weibar.service.mapper.WeibarMerchantsGoodsSettingInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/22.
 */
@Service
public class GiveService {

    @Autowired
    private WeibarMerchantsGoodsSettingInfoMapper weibarMerchantsGoodsSettingInfoMapper;

    @Autowired
    private BarrageService barrageService;

    @Autowired
    private UserBalanceService userBalanceService;
    @Autowired
    private UserService userService;
    @Autowired
    private PrivateChatService privateChatService;
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private UserConsumeOrderService userConsumeOrderService;
    @Autowired
    private SharingRatioService sharingRatioService;
    @Autowired
    private WechatPayService wechatPayService;
    @Autowired
    private PayAttachService payAttachService;
    @Autowired
    private GoodsService goodsService;

    public GiveResult give(Long merchantId, UserBaseInfo userGive, UserBaseInfo userGiven,
                           String userIp, Long goodsId, String content, Integer giveType) throws BaseException {

        if (userGive.getUserId().equals(userGiven.getUserId())) {
            throw BaseException.getException(ErrorCodeEnum.GIVE_ERROR_GIVE_SELF.getCode());
        }

        GiveResult giveResult = new GiveResult();

        UserBaseInfo userBaseInfoGive = userService.getUserById(userGive.getUserId());

        GoodsSettingInfo goodsSettingInfo = goodsService.getGoodsSettingInfoById(goodsId, merchantId);
        BigDecimal needPayAmount = goodsSettingInfo.getGoodsAmount();

        UserAccountBalance userAccountBalance = userBalanceService.getBalanceAccountByUserId(userGive.getUserId());

        //判断余额是否充足
        if (userAccountBalance.getBalance().compareTo(needPayAmount) < 0) {
            giveResult.setBanlanceEnough(false);
            BigDecimal minRechargeAmount =  needPayAmount.subtract(userAccountBalance.getBalance());
            giveResult.setMinRechargeAmount(minRechargeAmount);
            //余额不足生成微信订单返回
            WechatPrePay wechatPrePay = wechatPayService.createOrder(minRechargeAmount.multiply(new BigDecimal(100)).intValue(),userIp,userGive.getOpenid(),
                    payAttachService.generateGivePayAttach(merchantId, userGive.getUserId(), userGiven.getUserId(),
                            userIp,goodsId,content,giveType));
            giveResult.setWechatMpPrePay(wechatPrePay);
            return giveResult;
        }

        // 扣除余额
        WeibarMerchantsBaseInfo merchantsBaseInfo = merchantService.getMerchantInfoFromDb(merchantId);
        String remarkGive = " 在酒吧 " + merchantsBaseInfo.getMerchantsName()
                + "  打赏 " + goodsSettingInfo.getGoodsName().toString() + " 消费";
        String remarkGiven = " 在酒吧 " + merchantsBaseInfo.getMerchantsName()
                + "  收到来自 " + userBaseInfoGive.getNickname() + "打赏的" + goodsSettingInfo.getGoodsName().toString();
        userBalanceService.subtractUserBalance(userGive.getUserId(), needPayAmount, remarkGive);

        //记录消费表
        UserConsumeTypeEnum userConsumeType = UserConsumeTypeEnum.GIVE_INDIV;
        UserConsumeOrder userConsumeOrder = userConsumeOrderService.createUserConsumeOrder(merchantId, userGive.getUserId(), userGiven.getUserId(),
                needPayAmount, new Date(), goodsSettingInfo.getGoodsId(), goodsSettingInfo.getGoodsName(), 1, userConsumeType, userIp);

        userBalanceService.addUserBalance(userGiven.getUserId(),
                sharingRatioService.shareAndGetGiveDiscount(needPayAmount,merchantId,new Long(userConsumeOrder.getId())), remarkGiven);

        GiveTypeEnum giveTypeEnum = GiveTypeEnum.getGiveType(giveType);

        switch (giveTypeEnum) {
            case BARRAGE:
                BarrageInfo barrageInfo = barrageService.addNewGiveBarrageInfo(merchantId, userBaseInfoGive.getOpenid(), content
                        , userGiven.getUserId(), userGiven.getUserPicture(), content, goodsSettingInfo.getGoodsName(),
                        goodsSettingInfo.getGoodsImgUrl(), userGiven.getNickname(),goodsId);
                giveResult.setBarrageInfo(barrageInfo);
                break;
            case PRIVATE_CHAT:
                Long chatId = privateChatService.getChatId(userGive.getUserId(),userGiven.getUserId());
                PrivateChat privateChat = privateChatService.addPrivateChatGiveMessage(userBaseInfoGive,userGiven, content, goodsSettingInfo.getGoodsName(),
                        goodsSettingInfo.getGoodsImgUrl(),chatId);
                giveResult.setPrivateChat(privateChat);
                break;
            default:
                break;
        }


        giveResult.setBanlanceEnough(true);
        giveResult.setMinRechargeAmount(new BigDecimal(0));

        return giveResult;
    }
}
