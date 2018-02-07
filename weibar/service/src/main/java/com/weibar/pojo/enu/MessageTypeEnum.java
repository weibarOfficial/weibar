package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2017/10/30.
 */
public enum MessageTypeEnum {
    WORDS(0,"文字消息"),PHOTO(1,"图片信息"),GIVE(2,"打赏信息"),
    RED_BAG(3,"红包信息"),SONG(4,"点歌信息"),VOTE(5,"投票信息"),
    WORDS_AND_PHOTO(6,"图文消息"),RED_BAG_GET(7,"红包领取消息"),
    OTHER(999,"其他信息");


    MessageTypeEnum(int type, String desc) {
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
