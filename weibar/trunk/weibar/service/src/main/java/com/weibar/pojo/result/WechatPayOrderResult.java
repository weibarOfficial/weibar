package com.weibar.pojo.result;


import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 引用的sdk有bug必须转一下（WxPayMpOrderResult 这里没有把全部需要参数加签名）
 */
public class WechatPayOrderResult {

    @XStreamAlias("appId")
    private String appId;
    @XStreamAlias("timeStamp")
    private String timeStamp;
    @XStreamAlias("nonceStr")
    private String nonceStr;
    /**
     * 由于package为java保留关键字，因此改为packageValue
     */
    @XStreamAlias("package")
    private String packageValue;
    @XStreamAlias("signType")
    private String signType;
    private String paySign;

    public static WechatPayOrderResult get(WxPayMpOrderResult ori){
        WechatPayOrderResult wechatPayOrderResult = new WechatPayOrderResult();
        wechatPayOrderResult.setAppId(ori.getAppId());
        wechatPayOrderResult.setNonceStr(ori.getNonceStr());
        wechatPayOrderResult.setPackageValue(ori.getPackageValue());
        wechatPayOrderResult.setPaySign(ori.getPaySign());
        wechatPayOrderResult.setSignType(ori.getSignType());
        wechatPayOrderResult.setTimeStamp(ori.getTimeStamp());
        return wechatPayOrderResult;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }
}
