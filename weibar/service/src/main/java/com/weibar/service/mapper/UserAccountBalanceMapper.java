package com.weibar.service.mapper;

import com.weibar.pojo.db.UserAccountBalance;
import com.weibar.pojo.db.UserAccountBalanceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAccountBalanceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_account_balance
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int countByExample(UserAccountBalanceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_account_balance
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int deleteByExample(UserAccountBalanceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_account_balance
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_account_balance
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int insert(UserAccountBalance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_account_balance
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int insertSelective(UserAccountBalance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_account_balance
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    List<UserAccountBalance> selectByExample(UserAccountBalanceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_account_balance
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    UserAccountBalance selectByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_account_balance
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int updateByExampleSelective(@Param("record") UserAccountBalance record, @Param("example") UserAccountBalanceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_account_balance
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int updateByExample(@Param("record") UserAccountBalance record, @Param("example") UserAccountBalanceCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_account_balance
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int updateByPrimaryKeySelective(UserAccountBalance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_account_balance
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    int updateByPrimaryKey(UserAccountBalance record);
}