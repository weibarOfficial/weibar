package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2017/11/30.
 */
public enum PrivateChatTypeEnum {

    WORDS(1,"文字"),PIC(2,"图片"),WORDS_AND_PIC(3,"文字和图片"),GIVE(4,"打赏");
    PrivateChatTypeEnum(int type, String desc) {
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
