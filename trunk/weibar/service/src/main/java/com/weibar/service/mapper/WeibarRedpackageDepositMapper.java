package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarRedpackageDeposit;
import com.weibar.pojo.db.WeibarRedpackageDepositCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarRedpackageDepositMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int countByExample(WeibarRedpackageDepositCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int deleteByExample(WeibarRedpackageDepositCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int insert(WeibarRedpackageDeposit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int insertSelective(WeibarRedpackageDeposit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    List<WeibarRedpackageDeposit> selectByExample(WeibarRedpackageDepositCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    WeibarRedpackageDeposit selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarRedpackageDeposit record, @Param("example") WeibarRedpackageDepositCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByExample(@Param("record") WeibarRedpackageDeposit record, @Param("example") WeibarRedpackageDepositCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarRedpackageDeposit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByPrimaryKey(WeibarRedpackageDeposit record);
}