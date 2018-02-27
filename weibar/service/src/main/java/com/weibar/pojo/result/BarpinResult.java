package com.weibar.pojo.result;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/11/21.
 */
public class BarpinResult {


    private boolean isBanlanceEnough;
    private BigDecimal minRechargeAmount;
    private BarrageInfo barrageInfo;
    private WechatPrePay wechatMpPrePay;


    public WechatPrePay getWechatMpPrePay() {
        return wechatMpPrePay;
    }

    public void setWechatMpPrePay(WechatPrePay wechatMpPrePay) {
        this.wechatMpPrePay = wechatMpPrePay;
    }



    public BarrageInfo getBarrageInfo() {
        return barrageInfo;
    }

    public void setBarrageInfo(BarrageInfo barrageInfo) {
        this.barrageInfo = barrageInfo;
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
