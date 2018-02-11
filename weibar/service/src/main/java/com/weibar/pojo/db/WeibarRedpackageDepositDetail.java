package com.weibar.pojo.db;

import java.math.BigDecimal;
import java.util.Date;

public class WeibarRedpackageDepositDetail {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_redpackage_deposit_detail.id
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_redpackage_deposit_detail.redpackageid
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private Long redpackageid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_redpackage_deposit_detail.openid
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private String openid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_redpackage_deposit_detail.user_id
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_redpackage_deposit_detail.nickname
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_redpackage_deposit_detail.user_picture
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private String userPicture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_redpackage_deposit_detail.amount
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private BigDecimal amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_redpackage_deposit_detail.redPacketTitle
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private String redpackettitle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_redpackage_deposit_detail.get_time
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private Date getTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_redpackage_deposit_detail.is_best
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private Integer isBest;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_redpackage_deposit_detail.status
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_redpackage_deposit_detail.create_time
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_redpackage_deposit_detail.update_time
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_redpackage_deposit_detail.id
     *
     * @return the value of weibar_redpackage_deposit_detail.id
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_redpackage_deposit_detail.id
     *
     * @param id the value for weibar_redpackage_deposit_detail.id
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_redpackage_deposit_detail.redpackageid
     *
     * @return the value of weibar_redpackage_deposit_detail.redpackageid
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public Long getRedpackageid() {
        return redpackageid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_redpackage_deposit_detail.redpackageid
     *
     * @param redpackageid the value for weibar_redpackage_deposit_detail.redpackageid
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setRedpackageid(Long redpackageid) {
        this.redpackageid = redpackageid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_redpackage_deposit_detail.openid
     *
     * @return the value of weibar_redpackage_deposit_detail.openid
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_redpackage_deposit_detail.openid
     *
     * @param openid the value for weibar_redpackage_deposit_detail.openid
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_redpackage_deposit_detail.user_id
     *
     * @return the value of weibar_redpackage_deposit_detail.user_id
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_redpackage_deposit_detail.user_id
     *
     * @param userId the value for weibar_redpackage_deposit_detail.user_id
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_redpackage_deposit_detail.nickname
     *
     * @return the value of weibar_redpackage_deposit_detail.nickname
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_redpackage_deposit_detail.nickname
     *
     * @param nickname the value for weibar_redpackage_deposit_detail.nickname
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_redpackage_deposit_detail.user_picture
     *
     * @return the value of weibar_redpackage_deposit_detail.user_picture
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public String getUserPicture() {
        return userPicture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_redpackage_deposit_detail.user_picture
     *
     * @param userPicture the value for weibar_redpackage_deposit_detail.user_picture
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture == null ? null : userPicture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_redpackage_deposit_detail.amount
     *
     * @return the value of weibar_redpackage_deposit_detail.amount
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_redpackage_deposit_detail.amount
     *
     * @param amount the value for weibar_redpackage_deposit_detail.amount
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_redpackage_deposit_detail.redPacketTitle
     *
     * @return the value of weibar_redpackage_deposit_detail.redPacketTitle
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public String getRedpackettitle() {
        return redpackettitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_redpackage_deposit_detail.redPacketTitle
     *
     * @param redpackettitle the value for weibar_redpackage_deposit_detail.redPacketTitle
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setRedpackettitle(String redpackettitle) {
        this.redpackettitle = redpackettitle == null ? null : redpackettitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_redpackage_deposit_detail.get_time
     *
     * @return the value of weibar_redpackage_deposit_detail.get_time
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public Date getGetTime() {
        return getTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_redpackage_deposit_detail.get_time
     *
     * @param getTime the value for weibar_redpackage_deposit_detail.get_time
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_redpackage_deposit_detail.is_best
     *
     * @return the value of weibar_redpackage_deposit_detail.is_best
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public Integer getIsBest() {
        return isBest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_redpackage_deposit_detail.is_best
     *
     * @param isBest the value for weibar_redpackage_deposit_detail.is_best
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setIsBest(Integer isBest) {
        this.isBest = isBest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_redpackage_deposit_detail.status
     *
     * @return the value of weibar_redpackage_deposit_detail.status
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_redpackage_deposit_detail.status
     *
     * @param status the value for weibar_redpackage_deposit_detail.status
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_redpackage_deposit_detail.create_time
     *
     * @return the value of weibar_redpackage_deposit_detail.create_time
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_redpackage_deposit_detail.create_time
     *
     * @param createTime the value for weibar_redpackage_deposit_detail.create_time
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_redpackage_deposit_detail.update_time
     *
     * @return the value of weibar_redpackage_deposit_detail.update_time
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_redpackage_deposit_detail.update_time
     *
     * @param updateTime the value for weibar_redpackage_deposit_detail.update_time
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}