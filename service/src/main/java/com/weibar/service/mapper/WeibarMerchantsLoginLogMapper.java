package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarMerchantsLoginLog;
import com.weibar.pojo.db.WeibarMerchantsLoginLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarMerchantsLoginLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int countByExample(WeibarMerchantsLoginLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int deleteByExample(WeibarMerchantsLoginLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int insert(WeibarMerchantsLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int insertSelective(WeibarMerchantsLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    List<WeibarMerchantsLoginLog> selectByExample(WeibarMerchantsLoginLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    WeibarMerchantsLoginLog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarMerchantsLoginLog record, @Param("example") WeibarMerchantsLoginLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByExample(@Param("record") WeibarMerchantsLoginLog record, @Param("example") WeibarMerchantsLoginLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarMerchantsLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByPrimaryKey(WeibarMerchantsLoginLog record);
}