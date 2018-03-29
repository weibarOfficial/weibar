package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2018/3/28.
 */
public enum MerchantRoleEnum {

    HANGZHOU(1,"杭州公司"),AGENT(2,"代理商"),BAR(3,"酒吧");


    MerchantRoleEnum(int type, String desc) {
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
