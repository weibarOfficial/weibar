package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarMerchantsSeatSettingInfo;
import com.weibar.pojo.db.WeibarMerchantsSeatSettingInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarMerchantsSeatSettingInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    int countByExample(WeibarMerchantsSeatSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    int deleteByExample(WeibarMerchantsSeatSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    int deleteByPrimaryKey(Long merchantid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    int insert(WeibarMerchantsSeatSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    int insertSelective(WeibarMerchantsSeatSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    List<WeibarMerchantsSeatSettingInfo> selectByExample(WeibarMerchantsSeatSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    WeibarMerchantsSeatSettingInfo selectByPrimaryKey(Long merchantid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarMerchantsSeatSettingInfo record, @Param("example") WeibarMerchantsSeatSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    int updateByExample(@Param("record") WeibarMerchantsSeatSettingInfo record, @Param("example") WeibarMerchantsSeatSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarMerchantsSeatSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    int updateByPrimaryKey(WeibarMerchantsSeatSettingInfo record);
}