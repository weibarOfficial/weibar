package com.weibar.service.function;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    /**
     * 支付成功才能调用
     * @param amount
     * @return
     */
    public BigDecimal shareAndGetRedPackageDiscount(BigDecimal amount){
        return amount.multiply(REDPACKAGE_DISCOUNT).setScale(2, RoundingMode.DOWN);
    }

    /**
     *  支付成功才能调用
     * @param amount
     * @return
     */
    public BigDecimal shareAndGetGiveDiscount(BigDecimal amount){
        return amount.multiply(GIVE_DISCOUNT).setScale(2, RoundingMode.DOWN);
    }


    public void shareBarpin(BigDecimal amount){

    }




    public BigDecimal getDakaDiscount(BigDecimal amount,int succUserCount){
        return amount.multiply(DAKA_DISCOUNT).setScale(2, RoundingMode.DOWN);
    }
}
