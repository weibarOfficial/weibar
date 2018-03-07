package com.weibar.service.mapper;

import com.weibar.pojo.db.UserConsumeOrder;
import com.weibar.pojo.db.UserConsumeOrderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserConsumeOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_consume_order
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    int countByExample(UserConsumeOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_consume_order
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    int deleteByExample(UserConsumeOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_consume_order
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_consume_order
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    int insert(UserConsumeOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_consume_order
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    int insertSelective(UserConsumeOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_consume_order
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    List<UserConsumeOrder> selectByExample(UserConsumeOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_consume_order
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    UserConsumeOrder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_consume_order
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    int updateByExampleSelective(@Param("record") UserConsumeOrder record, @Param("example") UserConsumeOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_consume_order
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    int updateByExample(@Param("record") UserConsumeOrder record, @Param("example") UserConsumeOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_consume_order
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    int updateByPrimaryKeySelective(UserConsumeOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_consume_order
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    int updateByPrimaryKey(UserConsumeOrder record);
}