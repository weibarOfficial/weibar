package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2017/11/14.
 */
public enum RedPackageOrderStateEnum {

    NEW(1,"新建红包订单"),HAS_SEND_WEIXIN(2,"已经发送请求到微信发送红包"),USER_HAS_GET(3,"用户已收到该微信红包");
    RedPackageOrderStateEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private int code;
    private String desc;
}
