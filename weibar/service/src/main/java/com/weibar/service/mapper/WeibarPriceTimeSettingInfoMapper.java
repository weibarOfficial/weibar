package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarPriceTimeSettingInfo;
import com.weibar.pojo.db.WeibarPriceTimeSettingInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarPriceTimeSettingInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_price_time_setting_info
     *
     * @mbggenerated Tue Mar 06 17:16:49 CST 2018
     */
    int countByExample(WeibarPriceTimeSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_price_time_setting_info
     *
     * @mbggenerated Tue Mar 06 17:16:49 CST 2018
     */
    int deleteByExample(WeibarPriceTimeSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_price_time_setting_info
     *
     * @mbggenerated Tue Mar 06 17:16:49 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_price_time_setting_info
     *
     * @mbggenerated Tue Mar 06 17:16:49 CST 2018
     */
    int insert(WeibarPriceTimeSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_price_time_setting_info
     *
     * @mbggenerated Tue Mar 06 17:16:49 CST 2018
     */
    int insertSelective(WeibarPriceTimeSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_price_time_setting_info
     *
     * @mbggenerated Tue Mar 06 17:16:49 CST 2018
     */
    List<WeibarPriceTimeSettingInfo> selectByExample(WeibarPriceTimeSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_price_time_setting_info
     *
     * @mbggenerated Tue Mar 06 17:16:49 CST 2018
     */
    WeibarPriceTimeSettingInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_price_time_setting_info
     *
     * @mbggenerated Tue Mar 06 17:16:49 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarPriceTimeSettingInfo record, @Param("example") WeibarPriceTimeSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_price_time_setting_info
     *
     * @mbggenerated Tue Mar 06 17:16:49 CST 2018
     */
    int updateByExample(@Param("record") WeibarPriceTimeSettingInfo record, @Param("example") WeibarPriceTimeSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_price_time_setting_info
     *
     * @mbggenerated Tue Mar 06 17:16:49 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarPriceTimeSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_price_time_setting_info
     *
     * @mbggenerated Tue Mar 06 17:16:49 CST 2018
     */
    int updateByPrimaryKey(WeibarPriceTimeSettingInfo record);
}