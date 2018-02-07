package com.weibar.pojo.enu;

/**
 * Created by nixiaoming on 2017/11/19.
 */
public enum UserWithdrawStatusEnum {


    NEW(1,"新建"),PREPARE(2,"已经记录到发送红包表，等待处理"),DONE(3,"已处理");


    UserWithdrawStatusEnum(int state, String desc) {
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
