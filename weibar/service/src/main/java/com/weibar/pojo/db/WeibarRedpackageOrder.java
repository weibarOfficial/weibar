package com.weibar.pojo.db;

import java.math.BigDecimal;
import java.util.Date;

public class WeibarRedpackageOrder {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_red_packet_order.orderid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Long orderid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_red_packet_order.user_id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_red_packet_order.chorderid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String chorderid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_red_packet_order.amount
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private BigDecimal amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_red_packet_order.openid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String openid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_red_packet_order.userIp
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String userip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_red_packet_order.scene_id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String sceneId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_red_packet_order.redPacketTitle
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String redpackettitle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_red_packet_order.description
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_red_packet_order.statusCode
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String statuscode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_red_packet_order.statusMsg
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String statusmsg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_red_packet_order.status
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_red_packet_order.create_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_red_packet_order.update_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_red_packet_order.ext
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    private String ext;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_red_packet_order.orderid
     *
     * @return the value of weibar_red_packet_order.orderid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Long getOrderid() {
        return orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_red_packet_order.orderid
     *
     * @param orderid the value for weibar_red_packet_order.orderid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_red_packet_order.user_id
     *
     * @return the value of weibar_red_packet_order.user_id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_red_packet_order.user_id
     *
     * @param userId the value for weibar_red_packet_order.user_id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_red_packet_order.chorderid
     *
     * @return the value of weibar_red_packet_order.chorderid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getChorderid() {
        return chorderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_red_packet_order.chorderid
     *
     * @param chorderid the value for weibar_red_packet_order.chorderid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setChorderid(String chorderid) {
        this.chorderid = chorderid == null ? null : chorderid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_red_packet_order.amount
     *
     * @return the value of weibar_red_packet_order.amount
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_red_packet_order.amount
     *
     * @param amount the value for weibar_red_packet_order.amount
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_red_packet_order.openid
     *
     * @return the value of weibar_red_packet_order.openid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_red_packet_order.openid
     *
     * @param openid the value for weibar_red_packet_order.openid
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_red_packet_order.userIp
     *
     * @return the value of weibar_red_packet_order.userIp
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getUserip() {
        return userip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_red_packet_order.userIp
     *
     * @param userip the value for weibar_red_packet_order.userIp
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setUserip(String userip) {
        this.userip = userip == null ? null : userip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_red_packet_order.scene_id
     *
     * @return the value of weibar_red_packet_order.scene_id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getSceneId() {
        return sceneId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_red_packet_order.scene_id
     *
     * @param sceneId the value for weibar_red_packet_order.scene_id
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setSceneId(String sceneId) {
        this.sceneId = sceneId == null ? null : sceneId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_red_packet_order.redPacketTitle
     *
     * @return the value of weibar_red_packet_order.redPacketTitle
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getRedpackettitle() {
        return redpackettitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_red_packet_order.redPacketTitle
     *
     * @param redpackettitle the value for weibar_red_packet_order.redPacketTitle
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setRedpackettitle(String redpackettitle) {
        this.redpackettitle = redpackettitle == null ? null : redpackettitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_red_packet_order.description
     *
     * @return the value of weibar_red_packet_order.description
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_red_packet_order.description
     *
     * @param description the value for weibar_red_packet_order.description
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_red_packet_order.statusCode
     *
     * @return the value of weibar_red_packet_order.statusCode
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getStatuscode() {
        return statuscode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_red_packet_order.statusCode
     *
     * @param statuscode the value for weibar_red_packet_order.statusCode
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode == null ? null : statuscode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_red_packet_order.statusMsg
     *
     * @return the value of weibar_red_packet_order.statusMsg
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getStatusmsg() {
        return statusmsg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_red_packet_order.statusMsg
     *
     * @param statusmsg the value for weibar_red_packet_order.statusMsg
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setStatusmsg(String statusmsg) {
        this.statusmsg = statusmsg == null ? null : statusmsg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_red_packet_order.status
     *
     * @return the value of weibar_red_packet_order.status
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_red_packet_order.status
     *
     * @param status the value for weibar_red_packet_order.status
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_red_packet_order.create_time
     *
     * @return the value of weibar_red_packet_order.create_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_red_packet_order.create_time
     *
     * @param createTime the value for weibar_red_packet_order.create_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_red_packet_order.update_time
     *
     * @return the value of weibar_red_packet_order.update_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_red_packet_order.update_time
     *
     * @param updateTime the value for weibar_red_packet_order.update_time
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_red_packet_order.ext
     *
     * @return the value of weibar_red_packet_order.ext
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public String getExt() {
        return ext;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_red_packet_order.ext
     *
     * @param ext the value for weibar_red_packet_order.ext
     *
     * @mbggenerated Mon Feb 05 16:16:11 CST 2018
     */
    public void setExt(String ext) {
        this.ext = ext == null ? null : ext.trim();
    }
}