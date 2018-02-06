package com.weibar.pojo.result;

import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2017/12/13.
 */
public class WechatPrePay {

    public WechatPrePay(WechatPayOrderResult wxPayMpOrderResult, String orderId) {
        this.wxPayMpOrderResult = wxPayMpOrderResult;
        this.orderId = orderId;
    }



    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public WechatPayOrderResult getWxPayMpOrderResult() {
        return wxPayMpOrderResult;
    }

    public void setWxPayMpOrderResult(WechatPayOrderResult wxPayMpOrderResult) {
        this.wxPayMpOrderResult = wxPayMpOrderResult;
    }

    private WechatPayOrderResult wxPayMpOrderResult;
    private String orderId;


}
