package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarMerchantsPriceTimeSettingInfo;
import com.weibar.pojo.db.WeibarMerchantsPriceTimeSettingInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarMerchantsPriceTimeSettingInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_price_time_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int countByExample(WeibarMerchantsPriceTimeSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_price_time_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int deleteByExample(WeibarMerchantsPriceTimeSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_price_time_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_price_time_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int insert(WeibarMerchantsPriceTimeSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_price_time_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int insertSelective(WeibarMerchantsPriceTimeSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_price_time_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    List<WeibarMerchantsPriceTimeSettingInfo> selectByExample(WeibarMerchantsPriceTimeSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_price_time_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    WeibarMerchantsPriceTimeSettingInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_price_time_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarMerchantsPriceTimeSettingInfo record, @Param("example") WeibarMerchantsPriceTimeSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_price_time_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int updateByExample(@Param("record") WeibarMerchantsPriceTimeSettingInfo record, @Param("example") WeibarMerchantsPriceTimeSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_price_time_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarMerchantsPriceTimeSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_price_time_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int updateByPrimaryKey(WeibarMerchantsPriceTimeSettingInfo record);
}