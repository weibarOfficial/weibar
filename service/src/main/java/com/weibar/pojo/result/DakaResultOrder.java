package com.weibar.pojo.result;

import com.weibar.pojo.db.DakaOrder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2018/2/1.
 */
public class DakaResultOrder {

    private Long orderId;

    private Long userId;

    private String openid;

    private BigDecimal payAmount;

    private BigDecimal getAmount;

    private Integer status;

    private Date orderDate;

    private Date payTime;

    private Date createTime;

    private Date updateTime;


    public static DakaResultOrder getDakaResultOrder(DakaOrder dakaOrder){
        DakaResultOrder dakaResultOrder = new DakaResultOrder();
        dakaResultOrder.setOrderDate(dakaOrder.getOrderDate());
        dakaResultOrder.setUserId(dakaOrder.getUserId());
        dakaResultOrder.setOpenid(dakaOrder.getOpenid());
        dakaResultOrder.setPayAmount(dakaOrder.getPayAmount());
        dakaResultOrder.setCreateTime(dakaOrder.getCreateTime());
        dakaResultOrder.setGetAmount(dakaOrder.getGetAmount());
        dakaResultOrder.setOrderId(dakaOrder.getOrderid());
        dakaResultOrder.setPayTime(dakaOrder.getPayTime());
        dakaResultOrder.setStatus(dakaOrder.getStatus());
        dakaResultOrder.setUpdateTime(dakaOrder.getUpdateTime());
        dakaResultOrder.setUserId(dakaOrder.getUserId());
        return dakaResultOrder;
    }



    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getGetAmount() {
        return getAmount;
    }

    public void setGetAmount(BigDecimal getAmount) {
        this.getAmount = getAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "DakaResultOrder{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", openid='" + openid + '\'' +
                ", payAmount=" + payAmount +
                ", getAmount=" + getAmount +
                ", status=" + status +
                ", orderDate=" + orderDate +
                ", payTime=" + payTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
