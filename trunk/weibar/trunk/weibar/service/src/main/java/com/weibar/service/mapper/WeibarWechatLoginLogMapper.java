package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarWechatLoginLog;
import com.weibar.pojo.db.WeibarWechatLoginLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarWechatLoginLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_wechat_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int countByExample(WeibarWechatLoginLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_wechat_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int deleteByExample(WeibarWechatLoginLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_wechat_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_wechat_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int insert(WeibarWechatLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_wechat_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int insertSelective(WeibarWechatLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_wechat_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    List<WeibarWechatLoginLog> selectByExample(WeibarWechatLoginLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_wechat_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    WeibarWechatLoginLog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_wechat_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarWechatLoginLog record, @Param("example") WeibarWechatLoginLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_wechat_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByExample(@Param("record") WeibarWechatLoginLog record, @Param("example") WeibarWechatLoginLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_wechat_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarWechatLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_wechat_login_log
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    int updateByPrimaryKey(WeibarWechatLoginLog record);
}