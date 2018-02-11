package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarMerchantsSettingInfo;
import com.weibar.pojo.db.WeibarMerchantsSettingInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarMerchantsSettingInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_setting_info
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    int countByExample(WeibarMerchantsSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_setting_info
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    int deleteByExample(WeibarMerchantsSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_setting_info
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    int deleteByPrimaryKey(Long merchantid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_setting_info
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    int insert(WeibarMerchantsSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_setting_info
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    int insertSelective(WeibarMerchantsSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_setting_info
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    List<WeibarMerchantsSettingInfo> selectByExample(WeibarMerchantsSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_setting_info
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    WeibarMerchantsSettingInfo selectByPrimaryKey(Long merchantid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_setting_info
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarMerchantsSettingInfo record, @Param("example") WeibarMerchantsSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_setting_info
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    int updateByExample(@Param("record") WeibarMerchantsSettingInfo record, @Param("example") WeibarMerchantsSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_setting_info
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarMerchantsSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_setting_info
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    int updateByPrimaryKey(WeibarMerchantsSettingInfo record);
}