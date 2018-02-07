package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2017/11/22.
 */
public enum  UserConsumeTypeEnum {


    BAR_FOR_SELF(1,"为自己霸屏"),BAR_FOR_OTHER(2,"为他人霸屏"),GIVE_INDIV(3,"打赏个人"),GIVE_STAR(4,"打赏艺人");
    UserConsumeTypeEnum(int type, String desc) {
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
