package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2017/11/10.
 */
public enum UserInfoStatusEnum {

    SUB(1,"已关注"), NOT_SUB(2,"取消关注");

    private UserInfoStatusEnum(int state, String desc){
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
