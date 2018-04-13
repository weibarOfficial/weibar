package com.weibar.service.mapper;

import com.weibar.pojo.db.MerchantAccountBalance;
import com.weibar.pojo.db.MerchantAccountBalanceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantAccountBalanceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_account_balance
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    int countByExample(MerchantAccountBalanceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_account_balance
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    int deleteByExample(MerchantAccountBalanceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_account_balance
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    int deleteByPrimaryKey(String merchantid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_account_balance
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    int insert(MerchantAccountBalance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_account_balance
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    int insertSelective(MerchantAccountBalance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_account_balance
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    List<MerchantAccountBalance> selectByExample(MerchantAccountBalanceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_account_balance
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    MerchantAccountBalance selectByPrimaryKey(String merchantid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_account_balance
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    int updateByExampleSelective(@Param("record") MerchantAccountBalance record, @Param("example") MerchantAccountBalanceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_account_balance
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    int updateByExample(@Param("record") MerchantAccountBalance record, @Param("example") MerchantAccountBalanceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_account_balance
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    int updateByPrimaryKeySelective(MerchantAccountBalance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_account_balance
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    int updateByPrimaryKey(MerchantAccountBalance record);
}