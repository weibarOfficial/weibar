package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2018/3/12.
 */
public enum  DakaModeEnum {

    PAY_MODE(1,"需要支付一元参与打卡"),FREE_MODE(2,"免费参与打卡");

    DakaModeEnum(int mode, String desc) {
        this.mode = mode;
        this.desc = desc;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private int mode;
    private String desc;
}
