package com.weibar.pojo.result;

import com.weibar.pojo.db.UserRechargeOrder;

/**
 * Created by Administrator on 2017/12/20.
 */
public class RechargeOrderInfo {

    private String orderId;
    private String openId;
    private Long userId;
    private Integer status;


    public static RechargeOrderInfo getRechargeOrderInfo(UserRechargeOrder userRechargeOrder){
        RechargeOrderInfo orderInfo = new RechargeOrderInfo();
        orderInfo.setStatus(userRechargeOrder.getStatus());
        orderInfo.setUserId(userRechargeOrder.getUserId());
        orderInfo.setOpenId(userRechargeOrder.getOpenid());
        orderInfo.setOrderId(userRechargeOrder.getOrderId());
        return orderInfo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
