package com.weibar.pojo.db;

import java.math.BigDecimal;
import java.util.Date;

public class MerchantAccountBalance {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_account_balance.merchantid
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    private String merchantid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_account_balance.balance
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    private BigDecimal balance;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_account_balance.bank_name
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    private String bankName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_account_balance.bank_card_no
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    private String bankCardNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_account_balance.bank_card_name
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    private String bankCardName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_account_balance.bank_branch
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    private String bankBranch;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_account_balance.subject
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    private String subject;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_account_balance.create_time
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant_account_balance.update_time
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_account_balance.merchantid
     *
     * @return the value of merchant_account_balance.merchantid
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public String getMerchantid() {
        return merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_account_balance.merchantid
     *
     * @param merchantid the value for merchant_account_balance.merchantid
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid == null ? null : merchantid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_account_balance.balance
     *
     * @return the value of merchant_account_balance.balance
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_account_balance.balance
     *
     * @param balance the value for merchant_account_balance.balance
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_account_balance.bank_name
     *
     * @return the value of merchant_account_balance.bank_name
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_account_balance.bank_name
     *
     * @param bankName the value for merchant_account_balance.bank_name
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_account_balance.bank_card_no
     *
     * @return the value of merchant_account_balance.bank_card_no
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public String getBankCardNo() {
        return bankCardNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_account_balance.bank_card_no
     *
     * @param bankCardNo the value for merchant_account_balance.bank_card_no
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo == null ? null : bankCardNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_account_balance.bank_card_name
     *
     * @return the value of merchant_account_balance.bank_card_name
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public String getBankCardName() {
        return bankCardName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_account_balance.bank_card_name
     *
     * @param bankCardName the value for merchant_account_balance.bank_card_name
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public void setBankCardName(String bankCardName) {
        this.bankCardName = bankCardName == null ? null : bankCardName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_account_balance.bank_branch
     *
     * @return the value of merchant_account_balance.bank_branch
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public String getBankBranch() {
        return bankBranch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_account_balance.bank_branch
     *
     * @param bankBranch the value for merchant_account_balance.bank_branch
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch == null ? null : bankBranch.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_account_balance.subject
     *
     * @return the value of merchant_account_balance.subject
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public String getSubject() {
        return subject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_account_balance.subject
     *
     * @param subject the value for merchant_account_balance.subject
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_account_balance.create_time
     *
     * @return the value of merchant_account_balance.create_time
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_account_balance.create_time
     *
     * @param createTime the value for merchant_account_balance.create_time
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant_account_balance.update_time
     *
     * @return the value of merchant_account_balance.update_time
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant_account_balance.update_time
     *
     * @param updateTime the value for merchant_account_balance.update_time
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}