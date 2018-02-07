package com.weibar.pojo.enu;

/**
 * Created by nixiaoming on 2017/11/19.
 */
public enum WithdrawStatusEnum {


    USER_POST(1,"用户已提交提现申请"),HAS_SEND(2,"已经提交微信处理"),SUCCESS(3,"提现成功");
    private WithdrawStatusEnum(int state, String desc){
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
