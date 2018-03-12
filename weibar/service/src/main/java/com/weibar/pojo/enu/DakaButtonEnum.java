package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2018/3/12.
 */
public enum DakaButtonEnum {
    DAKA("daka",false,"立即打卡，瓜分奖金"),
    REM_DAKA("",true,"明早记得5-8点前打卡哦~"),
    PAY_FOR_DAKA("payForDaka",false,"支付一元参与明早打卡"),
    FREE_FOR_DAKA("freeForDaka",false,"免费报名参与明早打卡");


    DakaButtonEnum(String bindTap, boolean disabled, String text) {
        this.bindTap = bindTap;
        this.disabled = disabled;
        this.text = text;
    }

    public String getBindTap() {
        return bindTap;
    }

    public void setBindTap(String bindTap) {
        this.bindTap = bindTap;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String bindTap;
    private boolean disabled;
    private String text;
}
