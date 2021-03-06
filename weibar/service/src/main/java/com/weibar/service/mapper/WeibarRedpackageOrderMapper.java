package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarRedpackageOrder;
import com.weibar.pojo.db.WeibarRedpackageOrderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarRedpackageOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_red_packet_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int countByExample(WeibarRedpackageOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_red_packet_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int deleteByExample(WeibarRedpackageOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_red_packet_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int deleteByPrimaryKey(Long orderid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_red_packet_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int insert(WeibarRedpackageOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_red_packet_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int insertSelective(WeibarRedpackageOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_red_packet_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    List<WeibarRedpackageOrder> selectByExampleWithBLOBs(WeibarRedpackageOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_red_packet_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    List<WeibarRedpackageOrder> selectByExample(WeibarRedpackageOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_red_packet_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    WeibarRedpackageOrder selectByPrimaryKey(Long orderid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_red_packet_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarRedpackageOrder record, @Param("example") WeibarRedpackageOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_red_packet_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") WeibarRedpackageOrder record, @Param("example") WeibarRedpackageOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_red_packet_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByExample(@Param("record") WeibarRedpackageOrder record, @Param("example") WeibarRedpackageOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_red_packet_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarRedpackageOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_red_packet_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(WeibarRedpackageOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_red_packet_order
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByPrimaryKey(WeibarRedpackageOrder record);
}