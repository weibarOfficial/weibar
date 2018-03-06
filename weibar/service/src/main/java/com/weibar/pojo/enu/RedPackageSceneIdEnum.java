package com.weibar.pojo.enu;

/**
 * 给用户发放微信红包的类别
 * Created by Administrator on 2017/11/20.
 */
public enum  RedPackageSceneIdEnum {

    WEIBAR_USER_WITHDRAW(1,"用户提现"),DAKA(2,"早起打卡奖励金");
    RedPackageSceneIdEnum(int state, String desc){
        this.state = state;
        this.desc = desc;
    }


    public static RedPackageSceneIdEnum getRedPackageSceneIdEnum(int state){
        for(RedPackageSceneIdEnum redPackageSceneIdEnum : RedPackageSceneIdEnum.values()){
            if(redPackageSceneIdEnum.getState().equals(state)){
                return redPackageSceneIdEnum;
            }
        }
        return null;
    }

    public Integer getState() {
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
