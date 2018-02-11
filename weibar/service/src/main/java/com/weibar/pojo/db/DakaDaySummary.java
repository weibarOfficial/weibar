package com.weibar.pojo.db;

import java.math.BigDecimal;
import java.util.Date;

public class DakaDaySummary {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.daka_date
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Date dakaDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.count
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Integer count;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.scount
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Integer scount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.fcount
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Integer fcount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.pay_amount
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private BigDecimal payAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.send_amount
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private BigDecimal sendAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.early_open_id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private String earlyOpenId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.early_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Date earlyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.early_user_id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Long earlyUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.early_user_picture
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private String earlyUserPicture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.lucky_open_id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private String luckyOpenId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.lucky_amount
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private BigDecimal luckyAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.lucky_user_id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Long luckyUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.lucky_user_picture
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private String luckyUserPicture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.guts_open_id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private String gutsOpenId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.guts_count
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Integer gutsCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.guts_user_id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Long gutsUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.guts_user_picture
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private String gutsUserPicture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.create_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_day_summary.update_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.id
     *
     * @return the value of daka_day_summary.id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.id
     *
     * @param id the value for daka_day_summary.id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.daka_date
     *
     * @return the value of daka_day_summary.daka_date
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Date getDakaDate() {
        return dakaDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.daka_date
     *
     * @param dakaDate the value for daka_day_summary.daka_date
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setDakaDate(Date dakaDate) {
        this.dakaDate = dakaDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.count
     *
     * @return the value of daka_day_summary.count
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Integer getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.count
     *
     * @param count the value for daka_day_summary.count
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.scount
     *
     * @return the value of daka_day_summary.scount
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Integer getScount() {
        return scount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.scount
     *
     * @param scount the value for daka_day_summary.scount
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setScount(Integer scount) {
        this.scount = scount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.fcount
     *
     * @return the value of daka_day_summary.fcount
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Integer getFcount() {
        return fcount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.fcount
     *
     * @param fcount the value for daka_day_summary.fcount
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setFcount(Integer fcount) {
        this.fcount = fcount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.pay_amount
     *
     * @return the value of daka_day_summary.pay_amount
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.pay_amount
     *
     * @param payAmount the value for daka_day_summary.pay_amount
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.send_amount
     *
     * @return the value of daka_day_summary.send_amount
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public BigDecimal getSendAmount() {
        return sendAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.send_amount
     *
     * @param sendAmount the value for daka_day_summary.send_amount
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setSendAmount(BigDecimal sendAmount) {
        this.sendAmount = sendAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.early_open_id
     *
     * @return the value of daka_day_summary.early_open_id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public String getEarlyOpenId() {
        return earlyOpenId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.early_open_id
     *
     * @param earlyOpenId the value for daka_day_summary.early_open_id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setEarlyOpenId(String earlyOpenId) {
        this.earlyOpenId = earlyOpenId == null ? null : earlyOpenId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.early_time
     *
     * @return the value of daka_day_summary.early_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Date getEarlyTime() {
        return earlyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.early_time
     *
     * @param earlyTime the value for daka_day_summary.early_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setEarlyTime(Date earlyTime) {
        this.earlyTime = earlyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.early_user_id
     *
     * @return the value of daka_day_summary.early_user_id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Long getEarlyUserId() {
        return earlyUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.early_user_id
     *
     * @param earlyUserId the value for daka_day_summary.early_user_id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setEarlyUserId(Long earlyUserId) {
        this.earlyUserId = earlyUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.early_user_picture
     *
     * @return the value of daka_day_summary.early_user_picture
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public String getEarlyUserPicture() {
        return earlyUserPicture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.early_user_picture
     *
     * @param earlyUserPicture the value for daka_day_summary.early_user_picture
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setEarlyUserPicture(String earlyUserPicture) {
        this.earlyUserPicture = earlyUserPicture == null ? null : earlyUserPicture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.lucky_open_id
     *
     * @return the value of daka_day_summary.lucky_open_id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public String getLuckyOpenId() {
        return luckyOpenId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.lucky_open_id
     *
     * @param luckyOpenId the value for daka_day_summary.lucky_open_id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setLuckyOpenId(String luckyOpenId) {
        this.luckyOpenId = luckyOpenId == null ? null : luckyOpenId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.lucky_amount
     *
     * @return the value of daka_day_summary.lucky_amount
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public BigDecimal getLuckyAmount() {
        return luckyAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.lucky_amount
     *
     * @param luckyAmount the value for daka_day_summary.lucky_amount
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setLuckyAmount(BigDecimal luckyAmount) {
        this.luckyAmount = luckyAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.lucky_user_id
     *
     * @return the value of daka_day_summary.lucky_user_id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Long getLuckyUserId() {
        return luckyUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.lucky_user_id
     *
     * @param luckyUserId the value for daka_day_summary.lucky_user_id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setLuckyUserId(Long luckyUserId) {
        this.luckyUserId = luckyUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.lucky_user_picture
     *
     * @return the value of daka_day_summary.lucky_user_picture
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public String getLuckyUserPicture() {
        return luckyUserPicture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.lucky_user_picture
     *
     * @param luckyUserPicture the value for daka_day_summary.lucky_user_picture
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setLuckyUserPicture(String luckyUserPicture) {
        this.luckyUserPicture = luckyUserPicture == null ? null : luckyUserPicture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.guts_open_id
     *
     * @return the value of daka_day_summary.guts_open_id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public String getGutsOpenId() {
        return gutsOpenId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.guts_open_id
     *
     * @param gutsOpenId the value for daka_day_summary.guts_open_id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setGutsOpenId(String gutsOpenId) {
        this.gutsOpenId = gutsOpenId == null ? null : gutsOpenId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.guts_count
     *
     * @return the value of daka_day_summary.guts_count
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Integer getGutsCount() {
        return gutsCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.guts_count
     *
     * @param gutsCount the value for daka_day_summary.guts_count
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setGutsCount(Integer gutsCount) {
        this.gutsCount = gutsCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.guts_user_id
     *
     * @return the value of daka_day_summary.guts_user_id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Long getGutsUserId() {
        return gutsUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.guts_user_id
     *
     * @param gutsUserId the value for daka_day_summary.guts_user_id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setGutsUserId(Long gutsUserId) {
        this.gutsUserId = gutsUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.guts_user_picture
     *
     * @return the value of daka_day_summary.guts_user_picture
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public String getGutsUserPicture() {
        return gutsUserPicture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.guts_user_picture
     *
     * @param gutsUserPicture the value for daka_day_summary.guts_user_picture
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setGutsUserPicture(String gutsUserPicture) {
        this.gutsUserPicture = gutsUserPicture == null ? null : gutsUserPicture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.create_time
     *
     * @return the value of daka_day_summary.create_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.create_time
     *
     * @param createTime the value for daka_day_summary.create_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_day_summary.update_time
     *
     * @return the value of daka_day_summary.update_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_day_summary.update_time
     *
     * @param updateTime the value for daka_day_summary.update_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}