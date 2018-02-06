package com.weibar.service.mapper;

import com.weibar.pojo.db.UserTransaction;
import com.weibar.pojo.db.UserTransactionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTransactionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_transaction
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int countByExample(UserTransactionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_transaction
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int deleteByExample(UserTransactionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_transaction
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_transaction
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int insert(UserTransaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_transaction
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int insertSelective(UserTransaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_transaction
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    List<UserTransaction> selectByExample(UserTransactionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_transaction
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    UserTransaction selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_transaction
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByExampleSelective(@Param("record") UserTransaction record, @Param("example") UserTransactionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_transaction
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByExample(@Param("record") UserTransaction record, @Param("example") UserTransactionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_transaction
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByPrimaryKeySelective(UserTransaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_transaction
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByPrimaryKey(UserTransaction record);
}