package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarPayAttach;
import com.weibar.pojo.db.WeibarPayAttachCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarPayAttachMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_pay_attach
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    int countByExample(WeibarPayAttachCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_pay_attach
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    int deleteByExample(WeibarPayAttachCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_pay_attach
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_pay_attach
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    int insert(WeibarPayAttach record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_pay_attach
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    int insertSelective(WeibarPayAttach record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_pay_attach
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    List<WeibarPayAttach> selectByExample(WeibarPayAttachCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_pay_attach
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    WeibarPayAttach selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_pay_attach
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarPayAttach record, @Param("example") WeibarPayAttachCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_pay_attach
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    int updateByExample(@Param("record") WeibarPayAttach record, @Param("example") WeibarPayAttachCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_pay_attach
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarPayAttach record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_pay_attach
     *
     * @mbggenerated Fri Apr 13 11:37:44 CST 2018
     */
    int updateByPrimaryKey(WeibarPayAttach record);
}