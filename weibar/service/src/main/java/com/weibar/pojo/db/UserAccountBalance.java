package com.weibar.pojo.db;

import java.math.BigDecimal;
import java.util.Date;

public class UserAccountBalance {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account_balance.user_id
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account_balance.openid
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    private String openid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account_balance.balance
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    private BigDecimal balance;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account_balance.subject
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    private String subject;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account_balance.create_time
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account_balance.update_time
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account_balance.user_id
     *
     * @return the value of user_account_balance.user_id
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account_balance.user_id
     *
     * @param userId the value for user_account_balance.user_id
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account_balance.openid
     *
     * @return the value of user_account_balance.openid
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account_balance.openid
     *
     * @param openid the value for user_account_balance.openid
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account_balance.balance
     *
     * @return the value of user_account_balance.balance
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account_balance.balance
     *
     * @param balance the value for user_account_balance.balance
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account_balance.subject
     *
     * @return the value of user_account_balance.subject
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public String getSubject() {
        return subject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account_balance.subject
     *
     * @param subject the value for user_account_balance.subject
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account_balance.create_time
     *
     * @return the value of user_account_balance.create_time
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account_balance.create_time
     *
     * @param createTime the value for user_account_balance.create_time
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account_balance.update_time
     *
     * @return the value of user_account_balance.update_time
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account_balance.update_time
     *
     * @param updateTime the value for user_account_balance.update_time
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}