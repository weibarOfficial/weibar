package com.weibar.pojo.result;

import java.math.BigDecimal;

/**
 * Created by nixiaoming on 2017/11/19.
 */
public class RedPackageBeforePay {



    private Long redPackageId;
    private boolean isBanlanceEnough;
    private BigDecimal minRechargeAmount;
    private WechatPrePay wechatMpPrePay;


    public WechatPrePay getWechatMpPrePay() {
        return wechatMpPrePay;
    }

    public void setWechatMpPrePay(WechatPrePay wechatMpPrePay) {
        this.wechatMpPrePay = wechatMpPrePay;
    }

    public Long getRedPackageId() {
        return redPackageId;
    }

    public void setRedPackageId(Long redPackageId) {
        this.redPackageId = redPackageId;
    }

    public boolean isBanlanceEnough() {
        return isBanlanceEnough;
    }

    public void setBanlanceEnough(boolean banlanceEnough) {
        isBanlanceEnough = banlanceEnough;
    }

    public BigDecimal getMinRechargeAmount() {
        return minRechargeAmount;
    }

    public void setMinRechargeAmount(BigDecimal minRechargeAmount) {
        this.minRechargeAmount = minRechargeAmount;
    }


}
