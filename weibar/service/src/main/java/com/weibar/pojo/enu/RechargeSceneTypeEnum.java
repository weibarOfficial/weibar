package com.weibar.pojo.enu;

public enum RechargeSceneTypeEnum {



    PURE_RECHARGE(1,"纯充值"),BARPING(2,"霸屏"),GIVE(3,"打赏"),RED_PACKAGE(4,"发红包"),DAKA_ORDER(5,"打卡订单");

    public static RechargeSceneTypeEnum getByType(int type){
        for(RechargeSceneTypeEnum rechargeSceneTypeEnum : RechargeSceneTypeEnum.values()){
            if(rechargeSceneTypeEnum.getType() == type){
                return rechargeSceneTypeEnum;
            }
        }
        return null;
    }


    RechargeSceneTypeEnum(int type, String desc) {
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
