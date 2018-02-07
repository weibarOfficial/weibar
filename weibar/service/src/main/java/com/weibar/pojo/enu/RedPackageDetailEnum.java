package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2017/11/13.
 */
public enum RedPackageDetailEnum {

    NOT_GET(0,"红包未领取"),GET(1,"红包已领取");
    RedPackageDetailEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private int code;
    private String desc;
}
