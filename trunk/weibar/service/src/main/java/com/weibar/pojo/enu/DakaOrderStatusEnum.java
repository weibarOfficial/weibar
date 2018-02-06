package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2018/1/31.
 */
public enum  DakaOrderStatusEnum {

    NOT_PAY(1,"未支付"),PAYED(2,"已支付"),SEND(3,"已发放奖励金");

    DakaOrderStatusEnum(int state, String desc){
        this.state = state;
        this.desc = desc;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private int state;
    private String desc;
}
