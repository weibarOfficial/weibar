package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2017/10/19.
 */
public enum BarrageStatusEnum {

    BA(2,"已霸屏"), NOT_BA(1,"未霸屏"),NOT_SHOW(3,"不能显示状态"),DELETED(4,"已经被删除");

    private BarrageStatusEnum(int state, String desc){
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
