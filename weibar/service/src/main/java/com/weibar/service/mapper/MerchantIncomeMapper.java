package com.weibar.service.mapper;

import com.weibar.pojo.db.MerchantIncome;
import com.weibar.pojo.db.MerchantIncomeCriteria;
import com.weibar.pojo.db.MerchantIncomeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantIncomeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_income
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int countByExample(MerchantIncomeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_income
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int deleteByExample(MerchantIncomeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_income
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int deleteByPrimaryKey(MerchantIncomeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_income
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int insert(MerchantIncome record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_income
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int insertSelective(MerchantIncome record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_income
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    List<MerchantIncome> selectByExample(MerchantIncomeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_income
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    MerchantIncome selectByPrimaryKey(MerchantIncomeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_income
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByExampleSelective(@Param("record") MerchantIncome record, @Param("example") MerchantIncomeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_income
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByExample(@Param("record") MerchantIncome record, @Param("example") MerchantIncomeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_income
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByPrimaryKeySelective(MerchantIncome record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_income
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByPrimaryKey(MerchantIncome record);
}