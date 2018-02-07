package com.weibar.pojo.enu;


/**
 * 公司内的项目ID枚举类（目前有微吧公众号，打卡小程序）
 */
public enum AppEnum {

    WEIBA_MP(1,"微吧公众号"),DAKA_MINI(2,"打卡小程序");

    AppEnum(int appId, String desc) {
        this.appId = appId;
        this.desc = desc;
    }



    private int appId;
    private String desc;

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
