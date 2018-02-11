package com.weibar.pojo.db;

import java.math.BigDecimal;
import java.util.Date;

public class WeibarMerchantsSeatSettingInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_merchants_seat_setting_info.merchantid
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private Long merchantid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_merchants_seat_setting_info.seat_name
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private String seatName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_merchants_seat_setting_info.seat_no
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private String seatNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_merchants_seat_setting_info.min_num
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private Long minNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_merchants_seat_setting_info.max_num
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private Long maxNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_merchants_seat_setting_info.price
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private BigDecimal price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_merchants_seat_setting_info.create_time
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_merchants_seat_setting_info.update_time
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_merchants_seat_setting_info.merchantid
     *
     * @return the value of weibar_merchants_seat_setting_info.merchantid
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public Long getMerchantid() {
        return merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_merchants_seat_setting_info.merchantid
     *
     * @param merchantid the value for weibar_merchants_seat_setting_info.merchantid
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setMerchantid(Long merchantid) {
        this.merchantid = merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_merchants_seat_setting_info.seat_name
     *
     * @return the value of weibar_merchants_seat_setting_info.seat_name
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public String getSeatName() {
        return seatName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_merchants_seat_setting_info.seat_name
     *
     * @param seatName the value for weibar_merchants_seat_setting_info.seat_name
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setSeatName(String seatName) {
        this.seatName = seatName == null ? null : seatName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_merchants_seat_setting_info.seat_no
     *
     * @return the value of weibar_merchants_seat_setting_info.seat_no
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public String getSeatNo() {
        return seatNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_merchants_seat_setting_info.seat_no
     *
     * @param seatNo the value for weibar_merchants_seat_setting_info.seat_no
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo == null ? null : seatNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_merchants_seat_setting_info.min_num
     *
     * @return the value of weibar_merchants_seat_setting_info.min_num
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public Long getMinNum() {
        return minNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_merchants_seat_setting_info.min_num
     *
     * @param minNum the value for weibar_merchants_seat_setting_info.min_num
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setMinNum(Long minNum) {
        this.minNum = minNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_merchants_seat_setting_info.max_num
     *
     * @return the value of weibar_merchants_seat_setting_info.max_num
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public Long getMaxNum() {
        return maxNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_merchants_seat_setting_info.max_num
     *
     * @param maxNum the value for weibar_merchants_seat_setting_info.max_num
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setMaxNum(Long maxNum) {
        this.maxNum = maxNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_merchants_seat_setting_info.price
     *
     * @return the value of weibar_merchants_seat_setting_info.price
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_merchants_seat_setting_info.price
     *
     * @param price the value for weibar_merchants_seat_setting_info.price
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_merchants_seat_setting_info.create_time
     *
     * @return the value of weibar_merchants_seat_setting_info.create_time
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_merchants_seat_setting_info.create_time
     *
     * @param createTime the value for weibar_merchants_seat_setting_info.create_time
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_merchants_seat_setting_info.update_time
     *
     * @return the value of weibar_merchants_seat_setting_info.update_time
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_merchants_seat_setting_info.update_time
     *
     * @param updateTime the value for weibar_merchants_seat_setting_info.update_time
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}