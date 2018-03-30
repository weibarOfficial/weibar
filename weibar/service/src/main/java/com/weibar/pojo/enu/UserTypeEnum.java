package com.weibar.pojo.enu;

public enum  UserTypeEnum {

    USER(1,"普通用户"),MERCHANT(2,"商户用户");

    UserTypeEnum(int type, String desc) {
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
