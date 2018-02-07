package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarMerchantsBarrageSettingInfo;
import com.weibar.pojo.db.WeibarMerchantsBarrageSettingInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarMerchantsBarrageSettingInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_barrage_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int countByExample(WeibarMerchantsBarrageSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_barrage_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int deleteByExample(WeibarMerchantsBarrageSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_barrage_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int deleteByPrimaryKey(Long merchantid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_barrage_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int insert(WeibarMerchantsBarrageSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_barrage_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int insertSelective(WeibarMerchantsBarrageSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_barrage_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    List<WeibarMerchantsBarrageSettingInfo> selectByExample(WeibarMerchantsBarrageSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_barrage_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    WeibarMerchantsBarrageSettingInfo selectByPrimaryKey(Long merchantid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_barrage_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarMerchantsBarrageSettingInfo record, @Param("example") WeibarMerchantsBarrageSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_barrage_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByExample(@Param("record") WeibarMerchantsBarrageSettingInfo record, @Param("example") WeibarMerchantsBarrageSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_barrage_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarMerchantsBarrageSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_barrage_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByPrimaryKey(WeibarMerchantsBarrageSettingInfo record);
}