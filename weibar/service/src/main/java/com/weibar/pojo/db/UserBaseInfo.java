package com.weibar.pojo.db;

import java.math.BigDecimal;
import java.util.Date;

public class UserBaseInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base_info.user_id
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base_info.point
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private BigDecimal point;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base_info.user_picture
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private String userPicture;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base_info.nickname
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base_info.sex
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base_info.user_level
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private String userLevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base_info.city
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private String city;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base_info.country
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private String country;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base_info.province
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private String province;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base_info.user_mobile
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private String userMobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base_info.remark
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base_info.create_time
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base_info.update_time
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base_info.openid
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private String openid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base_info.status
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base_info.mini_daka_openid
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private String miniDakaOpenid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base_info.union_id
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private String unionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base_info.role
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    private Integer role;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base_info.user_id
     *
     * @return the value of user_base_info.user_id
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base_info.user_id
     *
     * @param userId the value for user_base_info.user_id
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base_info.point
     *
     * @return the value of user_base_info.point
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public BigDecimal getPoint() {
        return point;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base_info.point
     *
     * @param point the value for user_base_info.point
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base_info.user_picture
     *
     * @return the value of user_base_info.user_picture
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public String getUserPicture() {
        return userPicture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base_info.user_picture
     *
     * @param userPicture the value for user_base_info.user_picture
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture == null ? null : userPicture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base_info.nickname
     *
     * @return the value of user_base_info.nickname
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base_info.nickname
     *
     * @param nickname the value for user_base_info.nickname
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base_info.sex
     *
     * @return the value of user_base_info.sex
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base_info.sex
     *
     * @param sex the value for user_base_info.sex
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base_info.user_level
     *
     * @return the value of user_base_info.user_level
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public String getUserLevel() {
        return userLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base_info.user_level
     *
     * @param userLevel the value for user_base_info.user_level
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel == null ? null : userLevel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base_info.city
     *
     * @return the value of user_base_info.city
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base_info.city
     *
     * @param city the value for user_base_info.city
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base_info.country
     *
     * @return the value of user_base_info.country
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public String getCountry() {
        return country;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base_info.country
     *
     * @param country the value for user_base_info.country
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base_info.province
     *
     * @return the value of user_base_info.province
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base_info.province
     *
     * @param province the value for user_base_info.province
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base_info.user_mobile
     *
     * @return the value of user_base_info.user_mobile
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base_info.user_mobile
     *
     * @param userMobile the value for user_base_info.user_mobile
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base_info.remark
     *
     * @return the value of user_base_info.remark
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base_info.remark
     *
     * @param remark the value for user_base_info.remark
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base_info.create_time
     *
     * @return the value of user_base_info.create_time
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base_info.create_time
     *
     * @param createTime the value for user_base_info.create_time
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base_info.update_time
     *
     * @return the value of user_base_info.update_time
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base_info.update_time
     *
     * @param updateTime the value for user_base_info.update_time
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base_info.openid
     *
     * @return the value of user_base_info.openid
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base_info.openid
     *
     * @param openid the value for user_base_info.openid
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base_info.status
     *
     * @return the value of user_base_info.status
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base_info.status
     *
     * @param status the value for user_base_info.status
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base_info.mini_daka_openid
     *
     * @return the value of user_base_info.mini_daka_openid
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public String getMiniDakaOpenid() {
        return miniDakaOpenid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base_info.mini_daka_openid
     *
     * @param miniDakaOpenid the value for user_base_info.mini_daka_openid
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setMiniDakaOpenid(String miniDakaOpenid) {
        this.miniDakaOpenid = miniDakaOpenid == null ? null : miniDakaOpenid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base_info.union_id
     *
     * @return the value of user_base_info.union_id
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base_info.union_id
     *
     * @param unionId the value for user_base_info.union_id
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base_info.role
     *
     * @return the value of user_base_info.role
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public Integer getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base_info.role
     *
     * @param role the value for user_base_info.role
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setRole(Integer role) {
        this.role = role;
    }
}