package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2017/12/13.
 */
public enum PayChTypeEnum {

    WECHAT(1,"微信支付",PayMethodTypeEnum.H5);

    PayChTypeEnum(int type, String desc, PayMethodTypeEnum payMethodType) {
        this.type = type;
        this.desc = desc;
        this.payMethodType = payMethodType;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public PayMethodTypeEnum getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(PayMethodTypeEnum payMethodType) {
        this.payMethodType = payMethodType;
    }

    private int type;
    private String desc;
    private PayMethodTypeEnum payMethodType;

}
