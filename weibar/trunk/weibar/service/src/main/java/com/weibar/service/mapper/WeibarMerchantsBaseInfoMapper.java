package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarMerchantsBaseInfo;
import com.weibar.pojo.db.WeibarMerchantsBaseInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarMerchantsBaseInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_base_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int countByExample(WeibarMerchantsBaseInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_base_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int deleteByExample(WeibarMerchantsBaseInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_base_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int deleteByPrimaryKey(Long merchantid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_base_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int insert(WeibarMerchantsBaseInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_base_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int insertSelective(WeibarMerchantsBaseInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_base_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    List<WeibarMerchantsBaseInfo> selectByExample(WeibarMerchantsBaseInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_base_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    WeibarMerchantsBaseInfo selectByPrimaryKey(Long merchantid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_base_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarMerchantsBaseInfo record, @Param("example") WeibarMerchantsBaseInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_base_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByExample(@Param("record") WeibarMerchantsBaseInfo record, @Param("example") WeibarMerchantsBaseInfoCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_base_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarMerchantsBaseInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_base_info
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByPrimaryKey(WeibarMerchantsBaseInfo record);
}