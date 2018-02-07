package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2017/11/13.
 */
public enum RedPackageDepositEnum {
    NEW(1,"新建"),GEN_DETAIL(2,"已创建红包详情"),BEGIN_GET(3,"可领取状态"),END_GET(4,"已领取完");


    RedPackageDepositEnum(int code, String desc) {
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
