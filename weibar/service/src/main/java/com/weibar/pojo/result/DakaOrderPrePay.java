package com.weibar.pojo.result;

/**
 * Created by Administrator on 2018/2/1.
 */
public class DakaOrderPrePay {

    private DakaResultOrder dakaResultOrder;
    private WechatPrePay wechatPrePay;

    public WechatPrePay getWechatPrePay() {
        return wechatPrePay;
    }

    public void setWechatPrePay(WechatPrePay wechatPrePay) {
        this.wechatPrePay = wechatPrePay;
    }

    public DakaResultOrder getDakaResultOrder() {
        return dakaResultOrder;
    }

    public void setDakaResultOrder(DakaResultOrder dakaResultOrder) {
        this.dakaResultOrder = dakaResultOrder;
    }


}
