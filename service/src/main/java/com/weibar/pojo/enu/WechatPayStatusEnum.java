package com.weibar.pojo.enu;

import com.weibar.pojo.exception.BaseException;
import org.apache.commons.lang.StringUtils;

/**
 * Created by Administrator on 2017/12/20.
 */
public enum  WechatPayStatusEnum {

//    SUCCESS—支付成功
//
//    REFUND—转入退款
//
//    NOTPAY—未支付
//
//    CLOSED—已关闭
//
//    REVOKED—已撤销（刷卡支付）
//
//    USERPAYING--用户支付中
//
//    PAYERROR--支付失败(其他原因，如银行返回失败)
    SUCCESS("SUCCESS","支付成功"),REFUND("REFUND","转入退款"),NOTPAY("NOTPAY","未支付"),
    CLOSED("CLOSED","已关闭"),REVOKED("REVOKED","已撤销（刷卡支付）"),
    USERPAYING("USERPAYING","用户支付中"),PAYERROR("PAYERROR","支付失败(其他原因，如银行返回失败)");

    WechatPayStatusEnum(String state, String desc) {
        this.state = state;
        this.desc = desc;
    }


    public static WechatPayStatusEnum getByState(String state)throws BaseException{
        for(WechatPayStatusEnum payStatusEnum : WechatPayStatusEnum.values()){
            if(StringUtils.equals(state,payStatusEnum.getState())){
                return payStatusEnum;
            }
        }
        throw BaseException.getException(ErrorCodeEnum.WECHAT_PAY_ERROR_UNKOWN_STATE.getCode());
    }

    public static RechargeOrderStatusEnum getRechargeOrderStatus(WechatPayStatusEnum wechatPayStatusEnum){
        switch (wechatPayStatusEnum){
            case CLOSED:
                return RechargeOrderStatusEnum.UNPAY;
            case NOTPAY:
                return RechargeOrderStatusEnum.UNPAY;
            case PAYERROR:
                return RechargeOrderStatusEnum.PAYERR;
            case REFUND:
                return RechargeOrderStatusEnum.REFUND;
            case REVOKED:
                return RechargeOrderStatusEnum.UNPAY;
            case SUCCESS:
                return RechargeOrderStatusEnum.SUC;
            case USERPAYING:
                return RechargeOrderStatusEnum.PAYING;
        }
        return null;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String state;
    private String desc;
}
