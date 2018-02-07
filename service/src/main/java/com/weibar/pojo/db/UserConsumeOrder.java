package com.weibar.pojo.db;

import java.math.BigDecimal;
import java.util.Date;

public class UserConsumeOrder {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.merchantid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Long merchantid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.openid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String openid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.user_id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.beneficial_user_id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Long beneficialUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.beneficial_openid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String beneficialOpenid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.balance_type
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Integer balanceType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.amount
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private BigDecimal amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.pay_type
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Integer payType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.goods_id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Long goodsId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.goods_name
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String goodsName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.goods_num
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Integer goodsNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.pay_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Date payTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.user_ip
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String userIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.description
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.create_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.update_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.ext1
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String ext1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.ext2
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String ext2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.ext3
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private BigDecimal ext3;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.ext4
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Date ext4;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_consume_order.ext5
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Integer ext5;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.id
     *
     * @return the value of user_consume_order.id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.id
     *
     * @param id the value for user_consume_order.id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.merchantid
     *
     * @return the value of user_consume_order.merchantid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Long getMerchantid() {
        return merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.merchantid
     *
     * @param merchantid the value for user_consume_order.merchantid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setMerchantid(Long merchantid) {
        this.merchantid = merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.openid
     *
     * @return the value of user_consume_order.openid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.openid
     *
     * @param openid the value for user_consume_order.openid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.user_id
     *
     * @return the value of user_consume_order.user_id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.user_id
     *
     * @param userId the value for user_consume_order.user_id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.beneficial_user_id
     *
     * @return the value of user_consume_order.beneficial_user_id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Long getBeneficialUserId() {
        return beneficialUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.beneficial_user_id
     *
     * @param beneficialUserId the value for user_consume_order.beneficial_user_id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setBeneficialUserId(Long beneficialUserId) {
        this.beneficialUserId = beneficialUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.beneficial_openid
     *
     * @return the value of user_consume_order.beneficial_openid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getBeneficialOpenid() {
        return beneficialOpenid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.beneficial_openid
     *
     * @param beneficialOpenid the value for user_consume_order.beneficial_openid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setBeneficialOpenid(String beneficialOpenid) {
        this.beneficialOpenid = beneficialOpenid == null ? null : beneficialOpenid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.balance_type
     *
     * @return the value of user_consume_order.balance_type
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Integer getBalanceType() {
        return balanceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.balance_type
     *
     * @param balanceType the value for user_consume_order.balance_type
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setBalanceType(Integer balanceType) {
        this.balanceType = balanceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.amount
     *
     * @return the value of user_consume_order.amount
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.amount
     *
     * @param amount the value for user_consume_order.amount
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.pay_type
     *
     * @return the value of user_consume_order.pay_type
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.pay_type
     *
     * @param payType the value for user_consume_order.pay_type
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.goods_id
     *
     * @return the value of user_consume_order.goods_id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.goods_id
     *
     * @param goodsId the value for user_consume_order.goods_id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.goods_name
     *
     * @return the value of user_consume_order.goods_name
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.goods_name
     *
     * @param goodsName the value for user_consume_order.goods_name
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.goods_num
     *
     * @return the value of user_consume_order.goods_num
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.goods_num
     *
     * @param goodsNum the value for user_consume_order.goods_num
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.pay_time
     *
     * @return the value of user_consume_order.pay_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.pay_time
     *
     * @param payTime the value for user_consume_order.pay_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.user_ip
     *
     * @return the value of user_consume_order.user_ip
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getUserIp() {
        return userIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.user_ip
     *
     * @param userIp the value for user_consume_order.user_ip
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.description
     *
     * @return the value of user_consume_order.description
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.description
     *
     * @param description the value for user_consume_order.description
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.create_time
     *
     * @return the value of user_consume_order.create_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.create_time
     *
     * @param createTime the value for user_consume_order.create_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.update_time
     *
     * @return the value of user_consume_order.update_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.update_time
     *
     * @param updateTime the value for user_consume_order.update_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.ext1
     *
     * @return the value of user_consume_order.ext1
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.ext1
     *
     * @param ext1 the value for user_consume_order.ext1
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.ext2
     *
     * @return the value of user_consume_order.ext2
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.ext2
     *
     * @param ext2 the value for user_consume_order.ext2
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.ext3
     *
     * @return the value of user_consume_order.ext3
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public BigDecimal getExt3() {
        return ext3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.ext3
     *
     * @param ext3 the value for user_consume_order.ext3
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setExt3(BigDecimal ext3) {
        this.ext3 = ext3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.ext4
     *
     * @return the value of user_consume_order.ext4
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Date getExt4() {
        return ext4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.ext4
     *
     * @param ext4 the value for user_consume_order.ext4
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setExt4(Date ext4) {
        this.ext4 = ext4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_consume_order.ext5
     *
     * @return the value of user_consume_order.ext5
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Integer getExt5() {
        return ext5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_consume_order.ext5
     *
     * @param ext5 the value for user_consume_order.ext5
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setExt5(Integer ext5) {
        this.ext5 = ext5;
    }
}