package com.weibar.service.mapper;

import com.weibar.pojo.db.UserRechargeOrder;
import com.weibar.pojo.db.UserRechargeOrderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRechargeOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_recharge_order
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int countByExample(UserRechargeOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_recharge_order
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int deleteByExample(UserRechargeOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_recharge_order
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_recharge_order
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int insert(UserRechargeOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_recharge_order
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int insertSelective(UserRechargeOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_recharge_order
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    List<UserRechargeOrder> selectByExample(UserRechargeOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_recharge_order
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    UserRechargeOrder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_recharge_order
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByExampleSelective(@Param("record") UserRechargeOrder record, @Param("example") UserRechargeOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_recharge_order
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByExample(@Param("record") UserRechargeOrder record, @Param("example") UserRechargeOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_recharge_order
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByPrimaryKeySelective(UserRechargeOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_recharge_order
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByPrimaryKey(UserRechargeOrder record);
}