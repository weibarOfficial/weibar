package com.weibar.pojo.db;

import java.math.BigDecimal;
import java.util.Date;

public class WeibarGoodsSettingInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_goods_setting_info.id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_goods_setting_info.goodsid
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Long goodsid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_goods_setting_info.goodsname
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private String goodsname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_goods_setting_info.goodsurl
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private String goodsurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_goods_setting_info.amount
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private BigDecimal amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_goods_setting_info.create_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_goods_setting_info.update_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_goods_setting_info.goods_big_url
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private String goodsBigUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_goods_setting_info.goods_msg
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private String goodsMsg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_goods_setting_info.time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Integer time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_goods_setting_info.width
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Integer width;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_goods_setting_info.height
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Integer height;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_goods_setting_info.id
     *
     * @return the value of weibar_goods_setting_info.id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_goods_setting_info.id
     *
     * @param id the value for weibar_goods_setting_info.id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_goods_setting_info.goodsid
     *
     * @return the value of weibar_goods_setting_info.goodsid
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Long getGoodsid() {
        return goodsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_goods_setting_info.goodsid
     *
     * @param goodsid the value for weibar_goods_setting_info.goodsid
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_goods_setting_info.goodsname
     *
     * @return the value of weibar_goods_setting_info.goodsname
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public String getGoodsname() {
        return goodsname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_goods_setting_info.goodsname
     *
     * @param goodsname the value for weibar_goods_setting_info.goodsname
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_goods_setting_info.goodsurl
     *
     * @return the value of weibar_goods_setting_info.goodsurl
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public String getGoodsurl() {
        return goodsurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_goods_setting_info.goodsurl
     *
     * @param goodsurl the value for weibar_goods_setting_info.goodsurl
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setGoodsurl(String goodsurl) {
        this.goodsurl = goodsurl == null ? null : goodsurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_goods_setting_info.amount
     *
     * @return the value of weibar_goods_setting_info.amount
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_goods_setting_info.amount
     *
     * @param amount the value for weibar_goods_setting_info.amount
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_goods_setting_info.create_time
     *
     * @return the value of weibar_goods_setting_info.create_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_goods_setting_info.create_time
     *
     * @param createTime the value for weibar_goods_setting_info.create_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_goods_setting_info.update_time
     *
     * @return the value of weibar_goods_setting_info.update_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_goods_setting_info.update_time
     *
     * @param updateTime the value for weibar_goods_setting_info.update_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_goods_setting_info.goods_big_url
     *
     * @return the value of weibar_goods_setting_info.goods_big_url
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public String getGoodsBigUrl() {
        return goodsBigUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_goods_setting_info.goods_big_url
     *
     * @param goodsBigUrl the value for weibar_goods_setting_info.goods_big_url
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setGoodsBigUrl(String goodsBigUrl) {
        this.goodsBigUrl = goodsBigUrl == null ? null : goodsBigUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_goods_setting_info.goods_msg
     *
     * @return the value of weibar_goods_setting_info.goods_msg
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public String getGoodsMsg() {
        return goodsMsg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_goods_setting_info.goods_msg
     *
     * @param goodsMsg the value for weibar_goods_setting_info.goods_msg
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setGoodsMsg(String goodsMsg) {
        this.goodsMsg = goodsMsg == null ? null : goodsMsg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_goods_setting_info.time
     *
     * @return the value of weibar_goods_setting_info.time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Integer getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_goods_setting_info.time
     *
     * @param time the value for weibar_goods_setting_info.time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setTime(Integer time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_goods_setting_info.width
     *
     * @return the value of weibar_goods_setting_info.width
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_goods_setting_info.width
     *
     * @param width the value for weibar_goods_setting_info.width
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_goods_setting_info.height
     *
     * @return the value of weibar_goods_setting_info.height
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_goods_setting_info.height
     *
     * @param height the value for weibar_goods_setting_info.height
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setHeight(Integer height) {
        this.height = height;
    }
}