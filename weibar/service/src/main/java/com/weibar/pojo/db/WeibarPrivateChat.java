package com.weibar.pojo.db;

import java.util.Date;

public class WeibarPrivateChat {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.id
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.chat_id
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private Long chatId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.message
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private String message;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.img_url
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private String imgUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.type
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.status
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.from_user_id
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private Long fromUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.from_user_openid
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private String fromUserOpenid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.from_user_picture
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private String fromUserPicture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.from_nickname
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private String fromNickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.from_sex
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private String fromSex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.to_user_id
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private Long toUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.to_user_openid
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private String toUserOpenid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.to_user_picture
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private String toUserPicture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.to_nickname
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private String toNickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.to_sex
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private String toSex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.create_time
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.update_time
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.give_user_id
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private Long giveUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.give_user_img_url
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private String giveUserImgUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.give_content
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private String giveContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.give_goodsname
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private String giveGoodsname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.give_goodsurl
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private String giveGoodsurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_private_chat.give_user_name
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    private String giveUserName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.id
     *
     * @return the value of weibar_private_chat.id
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.id
     *
     * @param id the value for weibar_private_chat.id
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.chat_id
     *
     * @return the value of weibar_private_chat.chat_id
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public Long getChatId() {
        return chatId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.chat_id
     *
     * @param chatId the value for weibar_private_chat.chat_id
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.message
     *
     * @return the value of weibar_private_chat.message
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.message
     *
     * @param message the value for weibar_private_chat.message
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.img_url
     *
     * @return the value of weibar_private_chat.img_url
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.img_url
     *
     * @param imgUrl the value for weibar_private_chat.img_url
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.type
     *
     * @return the value of weibar_private_chat.type
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.type
     *
     * @param type the value for weibar_private_chat.type
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.status
     *
     * @return the value of weibar_private_chat.status
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.status
     *
     * @param status the value for weibar_private_chat.status
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.from_user_id
     *
     * @return the value of weibar_private_chat.from_user_id
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public Long getFromUserId() {
        return fromUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.from_user_id
     *
     * @param fromUserId the value for weibar_private_chat.from_user_id
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.from_user_openid
     *
     * @return the value of weibar_private_chat.from_user_openid
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public String getFromUserOpenid() {
        return fromUserOpenid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.from_user_openid
     *
     * @param fromUserOpenid the value for weibar_private_chat.from_user_openid
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setFromUserOpenid(String fromUserOpenid) {
        this.fromUserOpenid = fromUserOpenid == null ? null : fromUserOpenid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.from_user_picture
     *
     * @return the value of weibar_private_chat.from_user_picture
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public String getFromUserPicture() {
        return fromUserPicture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.from_user_picture
     *
     * @param fromUserPicture the value for weibar_private_chat.from_user_picture
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setFromUserPicture(String fromUserPicture) {
        this.fromUserPicture = fromUserPicture == null ? null : fromUserPicture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.from_nickname
     *
     * @return the value of weibar_private_chat.from_nickname
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public String getFromNickname() {
        return fromNickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.from_nickname
     *
     * @param fromNickname the value for weibar_private_chat.from_nickname
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setFromNickname(String fromNickname) {
        this.fromNickname = fromNickname == null ? null : fromNickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.from_sex
     *
     * @return the value of weibar_private_chat.from_sex
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public String getFromSex() {
        return fromSex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.from_sex
     *
     * @param fromSex the value for weibar_private_chat.from_sex
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setFromSex(String fromSex) {
        this.fromSex = fromSex == null ? null : fromSex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.to_user_id
     *
     * @return the value of weibar_private_chat.to_user_id
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public Long getToUserId() {
        return toUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.to_user_id
     *
     * @param toUserId the value for weibar_private_chat.to_user_id
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.to_user_openid
     *
     * @return the value of weibar_private_chat.to_user_openid
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public String getToUserOpenid() {
        return toUserOpenid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.to_user_openid
     *
     * @param toUserOpenid the value for weibar_private_chat.to_user_openid
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setToUserOpenid(String toUserOpenid) {
        this.toUserOpenid = toUserOpenid == null ? null : toUserOpenid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.to_user_picture
     *
     * @return the value of weibar_private_chat.to_user_picture
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public String getToUserPicture() {
        return toUserPicture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.to_user_picture
     *
     * @param toUserPicture the value for weibar_private_chat.to_user_picture
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setToUserPicture(String toUserPicture) {
        this.toUserPicture = toUserPicture == null ? null : toUserPicture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.to_nickname
     *
     * @return the value of weibar_private_chat.to_nickname
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public String getToNickname() {
        return toNickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.to_nickname
     *
     * @param toNickname the value for weibar_private_chat.to_nickname
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setToNickname(String toNickname) {
        this.toNickname = toNickname == null ? null : toNickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.to_sex
     *
     * @return the value of weibar_private_chat.to_sex
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public String getToSex() {
        return toSex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.to_sex
     *
     * @param toSex the value for weibar_private_chat.to_sex
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setToSex(String toSex) {
        this.toSex = toSex == null ? null : toSex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.create_time
     *
     * @return the value of weibar_private_chat.create_time
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.create_time
     *
     * @param createTime the value for weibar_private_chat.create_time
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.update_time
     *
     * @return the value of weibar_private_chat.update_time
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.update_time
     *
     * @param updateTime the value for weibar_private_chat.update_time
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.give_user_id
     *
     * @return the value of weibar_private_chat.give_user_id
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public Long getGiveUserId() {
        return giveUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.give_user_id
     *
     * @param giveUserId the value for weibar_private_chat.give_user_id
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setGiveUserId(Long giveUserId) {
        this.giveUserId = giveUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.give_user_img_url
     *
     * @return the value of weibar_private_chat.give_user_img_url
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public String getGiveUserImgUrl() {
        return giveUserImgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.give_user_img_url
     *
     * @param giveUserImgUrl the value for weibar_private_chat.give_user_img_url
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setGiveUserImgUrl(String giveUserImgUrl) {
        this.giveUserImgUrl = giveUserImgUrl == null ? null : giveUserImgUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.give_content
     *
     * @return the value of weibar_private_chat.give_content
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public String getGiveContent() {
        return giveContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.give_content
     *
     * @param giveContent the value for weibar_private_chat.give_content
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setGiveContent(String giveContent) {
        this.giveContent = giveContent == null ? null : giveContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.give_goodsname
     *
     * @return the value of weibar_private_chat.give_goodsname
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public String getGiveGoodsname() {
        return giveGoodsname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.give_goodsname
     *
     * @param giveGoodsname the value for weibar_private_chat.give_goodsname
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setGiveGoodsname(String giveGoodsname) {
        this.giveGoodsname = giveGoodsname == null ? null : giveGoodsname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.give_goodsurl
     *
     * @return the value of weibar_private_chat.give_goodsurl
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public String getGiveGoodsurl() {
        return giveGoodsurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.give_goodsurl
     *
     * @param giveGoodsurl the value for weibar_private_chat.give_goodsurl
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setGiveGoodsurl(String giveGoodsurl) {
        this.giveGoodsurl = giveGoodsurl == null ? null : giveGoodsurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_private_chat.give_user_name
     *
     * @return the value of weibar_private_chat.give_user_name
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public String getGiveUserName() {
        return giveUserName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_private_chat.give_user_name
     *
     * @param giveUserName the value for weibar_private_chat.give_user_name
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setGiveUserName(String giveUserName) {
        this.giveUserName = giveUserName == null ? null : giveUserName.trim();
    }
}