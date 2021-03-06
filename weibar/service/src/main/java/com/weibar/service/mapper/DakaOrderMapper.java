package com.weibar.service.mapper;

import com.weibar.pojo.db.DakaOrder;
import com.weibar.pojo.db.DakaOrderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DakaOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int countByExample(DakaOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int deleteByExample(DakaOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int deleteByPrimaryKey(Long orderid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int insert(DakaOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int insertSelective(DakaOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    List<DakaOrder> selectByExample(DakaOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    DakaOrder selectByPrimaryKey(Long orderid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByExampleSelective(@Param("record") DakaOrder record, @Param("example") DakaOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByExample(@Param("record") DakaOrder record, @Param("example") DakaOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByPrimaryKeySelective(DakaOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByPrimaryKey(DakaOrder record);
}