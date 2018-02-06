package com.weibar.service.mapper;

import com.weibar.pojo.db.MerchantWithdrawLog;
import com.weibar.pojo.db.MerchantWithdrawLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantWithdrawLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_withdraw_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int countByExample(MerchantWithdrawLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_withdraw_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int deleteByExample(MerchantWithdrawLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_withdraw_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_withdraw_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int insert(MerchantWithdrawLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_withdraw_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int insertSelective(MerchantWithdrawLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_withdraw_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    List<MerchantWithdrawLog> selectByExample(MerchantWithdrawLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_withdraw_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    MerchantWithdrawLog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_withdraw_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByExampleSelective(@Param("record") MerchantWithdrawLog record, @Param("example") MerchantWithdrawLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_withdraw_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByExample(@Param("record") MerchantWithdrawLog record, @Param("example") MerchantWithdrawLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_withdraw_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByPrimaryKeySelective(MerchantWithdrawLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant_withdraw_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByPrimaryKey(MerchantWithdrawLog record);
}