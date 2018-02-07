package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2017/12/13.
 */
public enum PayMethodTypeEnum {

    H5("H5","H5支付");

    PayMethodTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String type;
    private String desc;
}
