package com.weibar.pojo.db;

import java.math.BigDecimal;
import java.util.Date;

public class IncomeFlowOrder {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.request_id
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private Integer requestId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.order_id
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.merchantid
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private Long merchantid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.openid
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private Long openid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.user_id
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.balance_type
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private Short balanceType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.amount
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private BigDecimal amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.goods_type
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private String goodsType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.goods_name
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private String goodsName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.pay_time
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private Date payTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.user_ip
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private String userIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.description
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.create_time
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.update_time
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.ext1
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private String ext1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.ext2
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private String ext2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.ext3
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private BigDecimal ext3;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.ext4
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private Date ext4;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income_flow_order.ext5
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private Integer ext5;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.request_id
     *
     * @return the value of income_flow_order.request_id
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public Integer getRequestId() {
        return requestId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.request_id
     *
     * @param requestId the value for income_flow_order.request_id
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.order_id
     *
     * @return the value of income_flow_order.order_id
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.order_id
     *
     * @param orderId the value for income_flow_order.order_id
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.merchantid
     *
     * @return the value of income_flow_order.merchantid
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public Long getMerchantid() {
        return merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.merchantid
     *
     * @param merchantid the value for income_flow_order.merchantid
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setMerchantid(Long merchantid) {
        this.merchantid = merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.openid
     *
     * @return the value of income_flow_order.openid
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public Long getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.openid
     *
     * @param openid the value for income_flow_order.openid
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setOpenid(Long openid) {
        this.openid = openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.user_id
     *
     * @return the value of income_flow_order.user_id
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.user_id
     *
     * @param userId the value for income_flow_order.user_id
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.balance_type
     *
     * @return the value of income_flow_order.balance_type
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public Short getBalanceType() {
        return balanceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.balance_type
     *
     * @param balanceType the value for income_flow_order.balance_type
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setBalanceType(Short balanceType) {
        this.balanceType = balanceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.amount
     *
     * @return the value of income_flow_order.amount
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.amount
     *
     * @param amount the value for income_flow_order.amount
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.goods_type
     *
     * @return the value of income_flow_order.goods_type
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public String getGoodsType() {
        return goodsType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.goods_type
     *
     * @param goodsType the value for income_flow_order.goods_type
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.goods_name
     *
     * @return the value of income_flow_order.goods_name
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.goods_name
     *
     * @param goodsName the value for income_flow_order.goods_name
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.pay_time
     *
     * @return the value of income_flow_order.pay_time
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.pay_time
     *
     * @param payTime the value for income_flow_order.pay_time
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.user_ip
     *
     * @return the value of income_flow_order.user_ip
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public String getUserIp() {
        return userIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.user_ip
     *
     * @param userIp the value for income_flow_order.user_ip
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.description
     *
     * @return the value of income_flow_order.description
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.description
     *
     * @param description the value for income_flow_order.description
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.create_time
     *
     * @return the value of income_flow_order.create_time
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.create_time
     *
     * @param createTime the value for income_flow_order.create_time
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.update_time
     *
     * @return the value of income_flow_order.update_time
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.update_time
     *
     * @param updateTime the value for income_flow_order.update_time
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.ext1
     *
     * @return the value of income_flow_order.ext1
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.ext1
     *
     * @param ext1 the value for income_flow_order.ext1
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.ext2
     *
     * @return the value of income_flow_order.ext2
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.ext2
     *
     * @param ext2 the value for income_flow_order.ext2
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.ext3
     *
     * @return the value of income_flow_order.ext3
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public BigDecimal getExt3() {
        return ext3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.ext3
     *
     * @param ext3 the value for income_flow_order.ext3
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setExt3(BigDecimal ext3) {
        this.ext3 = ext3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.ext4
     *
     * @return the value of income_flow_order.ext4
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public Date getExt4() {
        return ext4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.ext4
     *
     * @param ext4 the value for income_flow_order.ext4
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setExt4(Date ext4) {
        this.ext4 = ext4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column income_flow_order.ext5
     *
     * @return the value of income_flow_order.ext5
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public Integer getExt5() {
        return ext5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column income_flow_order.ext5
     *
     * @param ext5 the value for income_flow_order.ext5
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setExt5(Integer ext5) {
        this.ext5 = ext5;
    }
}