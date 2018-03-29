package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2018/3/28.
 */
public enum BalanceUserTypeEnum {

    USER(1,"普通个人用户"),MERCHANT(2,"商户用户");

    BalanceUserTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
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

    private int type;
    private String desc;
}
