package com.weibar.pojo.db;

import java.util.Date;

public class WeibarWsCache {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_ws_cache.id
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_ws_cache.sub_url
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private String subUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_ws_cache.res
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private String res;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_ws_cache.create_time
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_ws_cache.id
     *
     * @return the value of weibar_ws_cache.id
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_ws_cache.id
     *
     * @param id the value for weibar_ws_cache.id
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_ws_cache.sub_url
     *
     * @return the value of weibar_ws_cache.sub_url
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public String getSubUrl() {
        return subUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_ws_cache.sub_url
     *
     * @param subUrl the value for weibar_ws_cache.sub_url
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setSubUrl(String subUrl) {
        this.subUrl = subUrl == null ? null : subUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_ws_cache.res
     *
     * @return the value of weibar_ws_cache.res
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public String getRes() {
        return res;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_ws_cache.res
     *
     * @param res the value for weibar_ws_cache.res
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setRes(String res) {
        this.res = res == null ? null : res.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_ws_cache.create_time
     *
     * @return the value of weibar_ws_cache.create_time
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_ws_cache.create_time
     *
     * @param createTime the value for weibar_ws_cache.create_time
     *
     * @mbggenerated Sun Feb 11 14:37:42 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}