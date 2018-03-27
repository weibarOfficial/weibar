package com.weibar.service.mapper;

import com.weibar.pojo.db.UserCommissionIssue;
import com.weibar.pojo.db.UserCommissionIssueCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCommissionIssueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_commission_issue
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    int countByExample(UserCommissionIssueCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_commission_issue
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    int deleteByExample(UserCommissionIssueCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_commission_issue
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    int deleteByPrimaryKey(String billId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_commission_issue
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    int insert(UserCommissionIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_commission_issue
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    int insertSelective(UserCommissionIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_commission_issue
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    List<UserCommissionIssue> selectByExample(UserCommissionIssueCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_commission_issue
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    UserCommissionIssue selectByPrimaryKey(String billId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_commission_issue
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    int updateByExampleSelective(@Param("record") UserCommissionIssue record, @Param("example") UserCommissionIssueCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_commission_issue
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    int updateByExample(@Param("record") UserCommissionIssue record, @Param("example") UserCommissionIssueCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_commission_issue
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    int updateByPrimaryKeySelective(UserCommissionIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_commission_issue
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    int updateByPrimaryKey(UserCommissionIssue record);
}