package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarGoodsSettingInfo;
import com.weibar.pojo.db.WeibarGoodsSettingInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarGoodsSettingInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_goods_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    int countByExample(WeibarGoodsSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_goods_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    int deleteByExample(WeibarGoodsSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_goods_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_goods_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    int insert(WeibarGoodsSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_goods_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    int insertSelective(WeibarGoodsSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_goods_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    List<WeibarGoodsSettingInfo> selectByExample(WeibarGoodsSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_goods_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    WeibarGoodsSettingInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_goods_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarGoodsSettingInfo record, @Param("example") WeibarGoodsSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_goods_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    int updateByExample(@Param("record") WeibarGoodsSettingInfo record, @Param("example") WeibarGoodsSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_goods_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarGoodsSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_goods_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    int updateByPrimaryKey(WeibarGoodsSettingInfo record);
}