package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarMerchantsMtvSettingInfo;
import com.weibar.pojo.db.WeibarMerchantsMtvSettingInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarMerchantsMtvSettingInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int countByExample(WeibarMerchantsMtvSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int deleteByExample(WeibarMerchantsMtvSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int deleteByPrimaryKey(Long merchantid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int insert(WeibarMerchantsMtvSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int insertSelective(WeibarMerchantsMtvSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    List<WeibarMerchantsMtvSettingInfo> selectByExample(WeibarMerchantsMtvSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    WeibarMerchantsMtvSettingInfo selectByPrimaryKey(Long merchantid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarMerchantsMtvSettingInfo record, @Param("example") WeibarMerchantsMtvSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByExample(@Param("record") WeibarMerchantsMtvSettingInfo record, @Param("example") WeibarMerchantsMtvSettingInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarMerchantsMtvSettingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByPrimaryKey(WeibarMerchantsMtvSettingInfo record);
}