package com.weibar.service.mapper;

import com.weibar.pojo.db.DakaUser;
import com.weibar.pojo.db.DakaUserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DakaUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_user
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int countByExample(DakaUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_user
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int deleteByExample(DakaUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_user
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_user
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int insert(DakaUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_user
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int insertSelective(DakaUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_user
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    List<DakaUser> selectByExample(DakaUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_user
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    DakaUser selectByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_user
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByExampleSelective(@Param("record") DakaUser record, @Param("example") DakaUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_user
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByExample(@Param("record") DakaUser record, @Param("example") DakaUserCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_user
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByPrimaryKeySelective(DakaUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daka_user
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByPrimaryKey(DakaUser record);
}