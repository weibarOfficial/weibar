package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarMerchantsExtInfo;
import com.weibar.pojo.db.WeibarMerchantsExtInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarMerchantsExtInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_ext_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int countByExample(WeibarMerchantsExtInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_ext_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int deleteByExample(WeibarMerchantsExtInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_ext_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int deleteByPrimaryKey(Integer recId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_ext_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int insert(WeibarMerchantsExtInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_ext_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int insertSelective(WeibarMerchantsExtInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_ext_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    List<WeibarMerchantsExtInfo> selectByExample(WeibarMerchantsExtInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_ext_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    WeibarMerchantsExtInfo selectByPrimaryKey(Integer recId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_ext_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarMerchantsExtInfo record, @Param("example") WeibarMerchantsExtInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_ext_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int updateByExample(@Param("record") WeibarMerchantsExtInfo record, @Param("example") WeibarMerchantsExtInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_ext_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarMerchantsExtInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_ext_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int updateByPrimaryKey(WeibarMerchantsExtInfo record);
}