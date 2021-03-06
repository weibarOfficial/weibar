package com.weibar.pojo.result;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/11/27.
 */
public class GiveResult {

    private boolean isBanlanceEnough;
    private BigDecimal minRechargeAmount;
    private BarrageInfo barrageInfo;
    private PrivateChat privateChat;
    private WechatPrePay wechatMpPrePay;

    public WechatPrePay getWechatMpPrePay() {
        return wechatMpPrePay;
    }

    public void setWechatMpPrePay(WechatPrePay wechatMpPrePay) {
        this.wechatMpPrePay = wechatMpPrePay;
    }

    public PrivateChat getPrivateChat() {
        return privateChat;
    }

    public void setPrivateChat(PrivateChat privateChat) {
        this.privateChat = privateChat;
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
