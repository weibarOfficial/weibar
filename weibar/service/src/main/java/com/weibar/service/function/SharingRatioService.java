package com.weibar.service.function;

import com.weibar.pojo.db.WeibarMerchantsBaseInfo;
import com.weibar.pojo.enu.RechargeSceneTypeEnum;
import com.weibar.pojo.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 * 计算各种抽水比例
 */
@Service
public class SharingRatioService {

    // 红包打折比例（暂时全额反给用户）
    private static BigDecimal REDPACKAGE_DISCOUNT = new BigDecimal(1);

    private static BigDecimal GIVE_DISCOUNT = new BigDecimal(1);

    private static BigDecimal DAKA_DISCOUNT = new BigDecimal(1);

    @Autowired
    private MerchantService merchantService;
    @Autowired
    private UserBalanceService userBalanceService;

    /**
     * 支付成功才能调用
     * @param amount
     * @return
     */
    public BigDecimal shareAndGetRedPackageDiscount(BigDecimal amount,Long merchantId, Long consumeOrderId) throws BaseException {
        return share(amount,merchantId,consumeOrderId,RechargeSceneTypeEnum.RED_PACKAGE);
    }

    /**
     *  支付成功才能调用
     * @param amount
     * @return
     */
    public BigDecimal shareAndGetGiveDiscount(BigDecimal amount,Long merchantId, Long consumeOrderId) throws BaseException {
        return share(amount,merchantId,consumeOrderId,RechargeSceneTypeEnum.GIVE);
    }


    public void shareBarpin(BigDecimal amount,Long merchantId, Long consumeOrderId) throws BaseException {
         share(amount,merchantId,consumeOrderId,RechargeSceneTypeEnum.BARPING);
    }


    /**
     * 分成的核心逻辑
     * 分成的时候计算到如果小于1分钱的，则不予分成
     * 数据库保存的分成比例为千分之几
     * @param amount 分成前的总金额
     * @param merchantId 对应在哪个酒吧消费的
     * @return 分成后给到用户的金额
     * @throws BaseException
     */
    private BigDecimal share(BigDecimal amount, Long merchantId, Long consumeOrderId, RechargeSceneTypeEnum rechargeSceneTypeEnum) throws BaseException {
        List<WeibarMerchantsBaseInfo> merchantsBaseInfoList =  merchantService.getMerchantList(merchantId);
        int currentRatio = 0;
        BigDecimal currentAmount = new BigDecimal(0).add(amount);
        for(int i = 0; i < merchantsBaseInfoList.size(); i++){
            WeibarMerchantsBaseInfo merchantsBaseInfo = merchantsBaseInfoList.get(i);
            int shareRatio = 0;

            switch (rechargeSceneTypeEnum){
                case RED_PACKAGE:
                    shareRatio = merchantsBaseInfo.getSharingRatioRedp();
                    break;
                case GIVE:
                    shareRatio = merchantsBaseInfo.getSharingRatioGive();
                    break;
                case BARPING:
                    shareRatio = merchantsBaseInfo.getSharingRatioBarpin();
                    break;
                    default:
                        break;
            }




            int tempRatio = shareRatio;
            //当前分成比例应该减去下层已经分成的比例，才是该层应该分到的分成比例
            shareRatio = shareRatio - currentRatio;
            //标记当前层已经分走的分成比例
            currentRatio = tempRatio;

            BigDecimal shareAmount = amount.multiply(new BigDecimal(shareRatio)).multiply(new BigDecimal(0.001)).setScale(2, RoundingMode.DOWN);

            String shareRemark = "商户分成:酒吧ID " + merchantId + "消费订单号:" + consumeOrderId;
            if(shareAmount.compareTo(new BigDecimal(0)) > 0){
                userBalanceService.addUserBalance(merchantsBaseInfo.getUserId(),shareAmount,shareRemark);
                currentAmount = currentAmount.subtract(shareAmount);
            }
        }
        return currentAmount;
    }




    public BigDecimal getDakaDiscount(BigDecimal amount,int succUserCount){
        return amount.multiply(DAKA_DISCOUNT).setScale(2, RoundingMode.DOWN);
    }
}
