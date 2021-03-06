package com.weibar.service.mapper;

import com.weibar.pojo.db.IncomeFlowOrder;
import com.weibar.pojo.db.IncomeFlowOrderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IncomeFlowOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table income_flow_order
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    int countByExample(IncomeFlowOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table income_flow_order
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    int deleteByExample(IncomeFlowOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table income_flow_order
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    int deleteByPrimaryKey(Integer requestId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table income_flow_order
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    int insert(IncomeFlowOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table income_flow_order
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    int insertSelective(IncomeFlowOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table income_flow_order
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    List<IncomeFlowOrder> selectByExample(IncomeFlowOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table income_flow_order
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    IncomeFlowOrder selectByPrimaryKey(Integer requestId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table income_flow_order
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    int updateByExampleSelective(@Param("record") IncomeFlowOrder record, @Param("example") IncomeFlowOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table income_flow_order
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    int updateByExample(@Param("record") IncomeFlowOrder record, @Param("example") IncomeFlowOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table income_flow_order
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    int updateByPrimaryKeySelective(IncomeFlowOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table income_flow_order
     *
     * @mbggenerated Thu Nov 16 18:00:33 CST 2017
     */
    int updateByPrimaryKey(IncomeFlowOrder record);
}