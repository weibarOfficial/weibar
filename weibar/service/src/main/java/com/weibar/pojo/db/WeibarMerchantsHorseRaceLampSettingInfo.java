package com.weibar.pojo.db;

import java.util.Date;

public class WeibarMerchantsHorseRaceLampSettingInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_merchants_horse_race_lamp_setting_info.merchantid
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private Long merchantid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_merchants_horse_race_lamp_setting_info.context
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private String context;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_merchants_horse_race_lamp_setting_info.create_time
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_merchants_horse_race_lamp_setting_info.update_time
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_merchants_horse_race_lamp_setting_info.merchantid
     *
     * @return the value of weibar_merchants_horse_race_lamp_setting_info.merchantid
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public Long getMerchantid() {
        return merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_merchants_horse_race_lamp_setting_info.merchantid
     *
     * @param merchantid the value for weibar_merchants_horse_race_lamp_setting_info.merchantid
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setMerchantid(Long merchantid) {
        this.merchantid = merchantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_merchants_horse_race_lamp_setting_info.context
     *
     * @return the value of weibar_merchants_horse_race_lamp_setting_info.context
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public String getContext() {
        return context;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_merchants_horse_race_lamp_setting_info.context
     *
     * @param context the value for weibar_merchants_horse_race_lamp_setting_info.context
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_merchants_horse_race_lamp_setting_info.create_time
     *
     * @return the value of weibar_merchants_horse_race_lamp_setting_info.create_time
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_merchants_horse_race_lamp_setting_info.create_time
     *
     * @param createTime the value for weibar_merchants_horse_race_lamp_setting_info.create_time
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_merchants_horse_race_lamp_setting_info.update_time
     *
     * @return the value of weibar_merchants_horse_race_lamp_setting_info.update_time
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_merchants_horse_race_lamp_setting_info.update_time
     *
     * @param updateTime the value for weibar_merchants_horse_race_lamp_setting_info.update_time
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}