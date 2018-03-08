package com.weibar.pojo.db;

import java.math.BigDecimal;
import java.util.Date;

public class DakaUserRank {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user_rank.id
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user_rank.user_id
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user_rank.user_picture
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    private String userPicture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user_rank.openid
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    private String openid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user_rank.nickname
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user_rank.sex
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user_rank.rank
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    private Integer rank;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user_rank.get_sum_amount
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    private BigDecimal getSumAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user_rank.create_time
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_user_rank.update_time
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user_rank.id
     *
     * @return the value of daka_user_rank.id
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user_rank.id
     *
     * @param id the value for daka_user_rank.id
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user_rank.user_id
     *
     * @return the value of daka_user_rank.user_id
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user_rank.user_id
     *
     * @param userId the value for daka_user_rank.user_id
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user_rank.user_picture
     *
     * @return the value of daka_user_rank.user_picture
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public String getUserPicture() {
        return userPicture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user_rank.user_picture
     *
     * @param userPicture the value for daka_user_rank.user_picture
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture == null ? null : userPicture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user_rank.openid
     *
     * @return the value of daka_user_rank.openid
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user_rank.openid
     *
     * @param openid the value for daka_user_rank.openid
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user_rank.nickname
     *
     * @return the value of daka_user_rank.nickname
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user_rank.nickname
     *
     * @param nickname the value for daka_user_rank.nickname
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user_rank.sex
     *
     * @return the value of daka_user_rank.sex
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user_rank.sex
     *
     * @param sex the value for daka_user_rank.sex
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user_rank.rank
     *
     * @return the value of daka_user_rank.rank
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user_rank.rank
     *
     * @param rank the value for daka_user_rank.rank
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user_rank.get_sum_amount
     *
     * @return the value of daka_user_rank.get_sum_amount
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public BigDecimal getGetSumAmount() {
        return getSumAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user_rank.get_sum_amount
     *
     * @param getSumAmount the value for daka_user_rank.get_sum_amount
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void setGetSumAmount(BigDecimal getSumAmount) {
        this.getSumAmount = getSumAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user_rank.create_time
     *
     * @return the value of daka_user_rank.create_time
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user_rank.create_time
     *
     * @param createTime the value for daka_user_rank.create_time
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_user_rank.update_time
     *
     * @return the value of daka_user_rank.update_time
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_user_rank.update_time
     *
     * @param updateTime the value for daka_user_rank.update_time
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}