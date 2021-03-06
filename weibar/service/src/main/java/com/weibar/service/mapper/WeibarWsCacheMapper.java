package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarWsCache;
import com.weibar.pojo.db.WeibarWsCacheCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarWsCacheMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int countByExample(WeibarWsCacheCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int deleteByExample(WeibarWsCacheCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int insert(WeibarWsCache record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int insertSelective(WeibarWsCache record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    List<WeibarWsCache> selectByExample(WeibarWsCacheCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    WeibarWsCache selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarWsCache record, @Param("example") WeibarWsCacheCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByExample(@Param("record") WeibarWsCache record, @Param("example") WeibarWsCacheCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarWsCache record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByPrimaryKey(WeibarWsCache record);
}