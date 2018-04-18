package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarMerchantsGoodsSettingInfo;
import com.weibar.pojo.db.WeibarMerchantsGoodsSettingInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarMerchantsGoodsSettingInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_goods_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int countByExample(WeibarMerchantsGoodsSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_goods_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int deleteByExample(WeibarMerchantsGoodsSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_goods_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_goods_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int insert(WeibarMerchantsGoodsSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_goods_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int insertSelective(WeibarMerchantsGoodsSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_goods_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    List<WeibarMerchantsGoodsSettingInfo> selectByExample(WeibarMerchantsGoodsSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_goods_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    WeibarMerchantsGoodsSettingInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_goods_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarMerchantsGoodsSettingInfo record, @Param("example") WeibarMerchantsGoodsSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_goods_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByExample(@Param("record") WeibarMerchantsGoodsSettingInfo record, @Param("example") WeibarMerchantsGoodsSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_goods_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarMerchantsGoodsSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_goods_setting_info
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByPrimaryKey(WeibarMerchantsGoodsSettingInfo record);
}