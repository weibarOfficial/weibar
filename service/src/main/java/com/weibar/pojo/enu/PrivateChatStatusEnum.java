package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2017/11/30.
 */
public enum  PrivateChatStatusEnum {

    NOT_READ(1,"未读"),READ(2,"已读");

     PrivateChatStatusEnum(int state, String desc){
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
