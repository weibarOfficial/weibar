package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2017/12/11.
 */
public enum GiveTypeEnum {

    BARRAGE(1,"群聊打赏"),PRIVATE_CHAT(2,"私聊打赏");
    GiveTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static GiveTypeEnum getGiveType(int type){
        for(GiveTypeEnum giveTypeEnum : GiveTypeEnum.values()){
            if(giveTypeEnum.getType() == type){
                return giveTypeEnum;
            }
        }
        return null;
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
