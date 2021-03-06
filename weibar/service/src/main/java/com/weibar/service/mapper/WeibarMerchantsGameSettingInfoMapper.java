package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarMerchantsGameSettingInfo;
import com.weibar.pojo.db.WeibarMerchantsGameSettingInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarMerchantsGameSettingInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int countByExample(WeibarMerchantsGameSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int deleteByExample(WeibarMerchantsGameSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int insert(WeibarMerchantsGameSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int insertSelective(WeibarMerchantsGameSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    List<WeibarMerchantsGameSettingInfo> selectByExample(WeibarMerchantsGameSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    WeibarMerchantsGameSettingInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarMerchantsGameSettingInfo record, @Param("example") WeibarMerchantsGameSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByExample(@Param("record") WeibarMerchantsGameSettingInfo record, @Param("example") WeibarMerchantsGameSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarMerchantsGameSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByPrimaryKey(WeibarMerchantsGameSettingInfo record);
}