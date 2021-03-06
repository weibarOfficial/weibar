package com.weibar.pojo.db;

import java.util.Date;

public class MerchantsLoginInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchants_login_info.merchantid
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private Long merchantid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchants_login_info.merchant_passport
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private String merchantPassport;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchants_login_info.merchant_password
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private String merchantPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchants_login_info.lastloginip
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private String lastloginip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchants_login_info.lastlogintime
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private Date lastlogintime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchants_login_info.user_type
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private Byte userType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchants_login_info.status
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchants_login_info.version
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private Integer version;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchants_login_info.create_time
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchants_login_info.update_time
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchants_login_info.merchantid
     *
     * @return the value of merchants_login_info.merchantid
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public Long getMerchantid() {
        return merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchants_login_info.merchantid
     *
     * @param merchantid the value for merchants_login_info.merchantid
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setMerchantid(Long merchantid) {
        this.merchantid = merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchants_login_info.merchant_passport
     *
     * @return the value of merchants_login_info.merchant_passport
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public String getMerchantPassport() {
        return merchantPassport;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchants_login_info.merchant_passport
     *
     * @param merchantPassport the value for merchants_login_info.merchant_passport
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setMerchantPassport(String merchantPassport) {
        this.merchantPassport = merchantPassport == null ? null : merchantPassport.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchants_login_info.merchant_password
     *
     * @return the value of merchants_login_info.merchant_password
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public String getMerchantPassword() {
        return merchantPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchants_login_info.merchant_password
     *
     * @param merchantPassword the value for merchants_login_info.merchant_password
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setMerchantPassword(String merchantPassword) {
        this.merchantPassword = merchantPassword == null ? null : merchantPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchants_login_info.lastloginip
     *
     * @return the value of merchants_login_info.lastloginip
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public String getLastloginip() {
        return lastloginip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchants_login_info.lastloginip
     *
     * @param lastloginip the value for merchants_login_info.lastloginip
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip == null ? null : lastloginip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchants_login_info.lastlogintime
     *
     * @return the value of merchants_login_info.lastlogintime
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public Date getLastlogintime() {
        return lastlogintime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchants_login_info.lastlogintime
     *
     * @param lastlogintime the value for merchants_login_info.lastlogintime
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchants_login_info.user_type
     *
     * @return the value of merchants_login_info.user_type
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public Byte getUserType() {
        return userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchants_login_info.user_type
     *
     * @param userType the value for merchants_login_info.user_type
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchants_login_info.status
     *
     * @return the value of merchants_login_info.status
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchants_login_info.status
     *
     * @param status the value for merchants_login_info.status
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchants_login_info.version
     *
     * @return the value of merchants_login_info.version
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchants_login_info.version
     *
     * @param version the value for merchants_login_info.version
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchants_login_info.create_time
     *
     * @return the value of merchants_login_info.create_time
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchants_login_info.create_time
     *
     * @param createTime the value for merchants_login_info.create_time
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchants_login_info.update_time
     *
     * @return the value of merchants_login_info.update_time
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchants_login_info.update_time
     *
     * @param updateTime the value for merchants_login_info.update_time
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}