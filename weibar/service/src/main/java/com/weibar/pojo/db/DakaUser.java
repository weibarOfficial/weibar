package com.weibar.pojo.db;

import java.math.BigDecimal;
import java.util.Date;

public class DakaUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user.user_id
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user.user_picture
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    private String userPicture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user.openid
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    private String openid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user.nickname
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user.sex
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user.city
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    private String city;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user.country
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    private String country;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user.province
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    private String province;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user.count
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    private Integer count;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user.scount
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    private Integer scount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user.fcount
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    private Integer fcount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user.pay_sum_amount
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    private BigDecimal paySumAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user.get_sum_amount
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    private BigDecimal getSumAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user.create_time
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user.update_time
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user.union_id
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    private String unionId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user.user_id
     *
     * @return the value of daka_user.user_id
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user.user_id
     *
     * @param userId the value for daka_user.user_id
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user.user_picture
     *
     * @return the value of daka_user.user_picture
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public String getUserPicture() {
        return userPicture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user.user_picture
     *
     * @param userPicture the value for daka_user.user_picture
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture == null ? null : userPicture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user.openid
     *
     * @return the value of daka_user.openid
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user.openid
     *
     * @param openid the value for daka_user.openid
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user.nickname
     *
     * @return the value of daka_user.nickname
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user.nickname
     *
     * @param nickname the value for daka_user.nickname
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user.sex
     *
     * @return the value of daka_user.sex
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user.sex
     *
     * @param sex the value for daka_user.sex
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user.city
     *
     * @return the value of daka_user.city
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user.city
     *
     * @param city the value for daka_user.city
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user.country
     *
     * @return the value of daka_user.country
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public String getCountry() {
        return country;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user.country
     *
     * @param country the value for daka_user.country
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user.province
     *
     * @return the value of daka_user.province
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user.province
     *
     * @param province the value for daka_user.province
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user.count
     *
     * @return the value of daka_user.count
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public Integer getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user.count
     *
     * @param count the value for daka_user.count
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user.scount
     *
     * @return the value of daka_user.scount
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public Integer getScount() {
        return scount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user.scount
     *
     * @param scount the value for daka_user.scount
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public void setScount(Integer scount) {
        this.scount = scount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user.fcount
     *
     * @return the value of daka_user.fcount
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public Integer getFcount() {
        return fcount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user.fcount
     *
     * @param fcount the value for daka_user.fcount
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public void setFcount(Integer fcount) {
        this.fcount = fcount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user.pay_sum_amount
     *
     * @return the value of daka_user.pay_sum_amount
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public BigDecimal getPaySumAmount() {
        return paySumAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user.pay_sum_amount
     *
     * @param paySumAmount the value for daka_user.pay_sum_amount
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public void setPaySumAmount(BigDecimal paySumAmount) {
        this.paySumAmount = paySumAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user.get_sum_amount
     *
     * @return the value of daka_user.get_sum_amount
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public BigDecimal getGetSumAmount() {
        return getSumAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user.get_sum_amount
     *
     * @param getSumAmount the value for daka_user.get_sum_amount
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public void setGetSumAmount(BigDecimal getSumAmount) {
        this.getSumAmount = getSumAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user.create_time
     *
     * @return the value of daka_user.create_time
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user.create_time
     *
     * @param createTime the value for daka_user.create_time
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user.update_time
     *
     * @return the value of daka_user.update_time
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user.update_time
     *
     * @param updateTime the value for daka_user.update_time
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user.union_id
     *
     * @return the value of daka_user.union_id
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user.union_id
     *
     * @param unionId the value for daka_user.union_id
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }
}