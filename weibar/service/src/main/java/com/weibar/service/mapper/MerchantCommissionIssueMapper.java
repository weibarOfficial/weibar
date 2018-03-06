package com.weibar.service.mapper;

import com.weibar.pojo.db.MerchantCommissionIssue;
import com.weibar.pojo.db.MerchantCommissionIssueCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantCommissionIssueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_commission_issue
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    int countByExample(MerchantCommissionIssueCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_commission_issue
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    int deleteByExample(MerchantCommissionIssueCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_commission_issue
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    int deleteByPrimaryKey(String billId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_commission_issue
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    int insert(MerchantCommissionIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_commission_issue
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    int insertSelective(MerchantCommissionIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_commission_issue
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    List<MerchantCommissionIssue> selectByExample(MerchantCommissionIssueCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_commission_issue
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    MerchantCommissionIssue selectByPrimaryKey(String billId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_commission_issue
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    int updateByExampleSelective(@Param("record") MerchantCommissionIssue record, @Param("example") MerchantCommissionIssueCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_commission_issue
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    int updateByExample(@Param("record") MerchantCommissionIssue record, @Param("example") MerchantCommissionIssueCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_commission_issue
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    int updateByPrimaryKeySelective(MerchantCommissionIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_commission_issue
     *
     * @mbggenerated Tue Mar 06 10:34:11 CST 2018
     */
    int updateByPrimaryKey(MerchantCommissionIssue record);
}