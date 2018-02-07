package com.weibar.pojo.db;

import java.util.Date;

public class MerchantWithdrawLog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_withdraw_log.id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_withdraw_log.merchantid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Long merchantid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_withdraw_log.bank_name
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String bankName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_withdraw_log.bank_card_no
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String bankCardNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_withdraw_log.bank_card_name
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String bankCardName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_withdraw_log.bank_branch
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String bankBranch;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_withdraw_log.subject
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String subject;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_withdraw_log.create_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_withdraw_log.update_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_withdraw_log.status
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Byte status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_withdraw_log.id
     *
     * @return the value of merchant_withdraw_log.id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_withdraw_log.id
     *
     * @param id the value for merchant_withdraw_log.id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_withdraw_log.merchantid
     *
     * @return the value of merchant_withdraw_log.merchantid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Long getMerchantid() {
        return merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_withdraw_log.merchantid
     *
     * @param merchantid the value for merchant_withdraw_log.merchantid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setMerchantid(Long merchantid) {
        this.merchantid = merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_withdraw_log.bank_name
     *
     * @return the value of merchant_withdraw_log.bank_name
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_withdraw_log.bank_name
     *
     * @param bankName the value for merchant_withdraw_log.bank_name
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_withdraw_log.bank_card_no
     *
     * @return the value of merchant_withdraw_log.bank_card_no
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getBankCardNo() {
        return bankCardNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_withdraw_log.bank_card_no
     *
     * @param bankCardNo the value for merchant_withdraw_log.bank_card_no
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo == null ? null : bankCardNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_withdraw_log.bank_card_name
     *
     * @return the value of merchant_withdraw_log.bank_card_name
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getBankCardName() {
        return bankCardName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_withdraw_log.bank_card_name
     *
     * @param bankCardName the value for merchant_withdraw_log.bank_card_name
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setBankCardName(String bankCardName) {
        this.bankCardName = bankCardName == null ? null : bankCardName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_withdraw_log.bank_branch
     *
     * @return the value of merchant_withdraw_log.bank_branch
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getBankBranch() {
        return bankBranch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_withdraw_log.bank_branch
     *
     * @param bankBranch the value for merchant_withdraw_log.bank_branch
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch == null ? null : bankBranch.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_withdraw_log.subject
     *
     * @return the value of merchant_withdraw_log.subject
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getSubject() {
        return subject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_withdraw_log.subject
     *
     * @param subject the value for merchant_withdraw_log.subject
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_withdraw_log.create_time
     *
     * @return the value of merchant_withdraw_log.create_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_withdraw_log.create_time
     *
     * @param createTime the value for merchant_withdraw_log.create_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_withdraw_log.update_time
     *
     * @return the value of merchant_withdraw_log.update_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_withdraw_log.update_time
     *
     * @param updateTime the value for merchant_withdraw_log.update_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_withdraw_log.status
     *
     * @return the value of merchant_withdraw_log.status
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_withdraw_log.status
     *
     * @param status the value for merchant_withdraw_log.status
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}