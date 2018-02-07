package com.weibar.pojo.enu;

/**
 * Created by nixiaoming on 2017/11/19.
 */
public enum TransctionTypeEnum {

    IN(1,"收入"),OUT(2,"支出");
    TransctionTypeEnum(int type, String desc) {
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
