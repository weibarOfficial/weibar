package com.weibar.pojo.db;

import java.math.BigDecimal;
import java.util.Date;

public class DakaOrder {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_order.orderid
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private Long orderid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_order.user_id
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_order.openid
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private String openid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_order.pay_amount
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private BigDecimal payAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_order.get_amount
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private BigDecimal getAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_order.status
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_order.order_date
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private Date orderDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_order.pay_time
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private Date payTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_order.create_time
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_order.update_time
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_order.daka_time
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private Date dakaTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_order.client_ip
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private String clientIp;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_order.orderid
     *
     * @return the value of daka_order.orderid
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public Long getOrderid() {
        return orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_order.orderid
     *
     * @param orderid the value for daka_order.orderid
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_order.user_id
     *
     * @return the value of daka_order.user_id
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_order.user_id
     *
     * @param userId the value for daka_order.user_id
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_order.openid
     *
     * @return the value of daka_order.openid
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_order.openid
     *
     * @param openid the value for daka_order.openid
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_order.pay_amount
     *
     * @return the value of daka_order.pay_amount
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_order.pay_amount
     *
     * @param payAmount the value for daka_order.pay_amount
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_order.get_amount
     *
     * @return the value of daka_order.get_amount
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public BigDecimal getGetAmount() {
        return getAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_order.get_amount
     *
     * @param getAmount the value for daka_order.get_amount
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setGetAmount(BigDecimal getAmount) {
        this.getAmount = getAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_order.status
     *
     * @return the value of daka_order.status
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_order.status
     *
     * @param status the value for daka_order.status
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_order.order_date
     *
     * @return the value of daka_order.order_date
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_order.order_date
     *
     * @param orderDate the value for daka_order.order_date
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_order.pay_time
     *
     * @return the value of daka_order.pay_time
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_order.pay_time
     *
     * @param payTime the value for daka_order.pay_time
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_order.create_time
     *
     * @return the value of daka_order.create_time
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_order.create_time
     *
     * @param createTime the value for daka_order.create_time
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_order.update_time
     *
     * @return the value of daka_order.update_time
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_order.update_time
     *
     * @param updateTime the value for daka_order.update_time
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_order.daka_time
     *
     * @return the value of daka_order.daka_time
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public Date getDakaTime() {
        return dakaTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_order.daka_time
     *
     * @param dakaTime the value for daka_order.daka_time
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setDakaTime(Date dakaTime) {
        this.dakaTime = dakaTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_order.client_ip
     *
     * @return the value of daka_order.client_ip
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_order.client_ip
     *
     * @param clientIp the value for daka_order.client_ip
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp == null ? null : clientIp.trim();
    }
}