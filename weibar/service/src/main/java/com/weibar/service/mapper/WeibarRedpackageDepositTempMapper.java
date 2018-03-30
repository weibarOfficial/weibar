package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarRedpackageDepositTemp;
import com.weibar.pojo.db.WeibarRedpackageDepositTempCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarRedpackageDepositTempMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit_temp
     *
     * @mbggenerated Thu Mar 29 15:05:40 CST 2018
     */
    int countByExample(WeibarRedpackageDepositTempCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit_temp
     *
     * @mbggenerated Thu Mar 29 15:05:40 CST 2018
     */
    int deleteByExample(WeibarRedpackageDepositTempCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit_temp
     *
     * @mbggenerated Thu Mar 29 15:05:40 CST 2018
     */
    int deleteByPrimaryKey(Long redpackageid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit_temp
     *
     * @mbggenerated Thu Mar 29 15:05:40 CST 2018
     */
    int insert(WeibarRedpackageDepositTemp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit_temp
     *
     * @mbggenerated Thu Mar 29 15:05:40 CST 2018
     */
    int insertSelective(WeibarRedpackageDepositTemp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit_temp
     *
     * @mbggenerated Thu Mar 29 15:05:40 CST 2018
     */
    List<WeibarRedpackageDepositTemp> selectByExample(WeibarRedpackageDepositTempCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit_temp
     *
     * @mbggenerated Thu Mar 29 15:05:40 CST 2018
     */
    WeibarRedpackageDepositTemp selectByPrimaryKey(Long redpackageid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit_temp
     *
     * @mbggenerated Thu Mar 29 15:05:40 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarRedpackageDepositTemp record, @Param("example") WeibarRedpackageDepositTempCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit_temp
     *
     * @mbggenerated Thu Mar 29 15:05:40 CST 2018
     */
    int updateByExample(@Param("record") WeibarRedpackageDepositTemp record, @Param("example") WeibarRedpackageDepositTempCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit_temp
     *
     * @mbggenerated Thu Mar 29 15:05:40 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarRedpackageDepositTemp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit_temp
     *
     * @mbggenerated Thu Mar 29 15:05:40 CST 2018
     */
    int updateByPrimaryKey(WeibarRedpackageDepositTemp record);
}