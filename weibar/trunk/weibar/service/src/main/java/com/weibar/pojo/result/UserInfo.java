package com.weibar.pojo.result;

import com.weibar.pojo.db.UserBaseInfo;

import java.math.BigDecimal;

/**
 * Created by nixiaoming on 2017/11/12.
 */
public class UserInfo {


    public static UserInfo getUserInfo(UserBaseInfo userBaseInfo){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userBaseInfo.getUserId());
        userInfo.setBalance(userBaseInfo.getPoint());
        userInfo.setCity(userBaseInfo.getCity());
        userInfo.setCountry(userBaseInfo.getCountry());
        userInfo.setNickname(userBaseInfo.getNickname());
        userInfo.setOpenId(userBaseInfo.getOpenid());
        userInfo.setProvince(userBaseInfo.getProvince());
        userInfo.setSex(userBaseInfo.getSex());
        userInfo.setUserLevel(userBaseInfo.getUserLevel());
        userInfo.setUserMobile(userBaseInfo.getUserMobile());
        userInfo.setUserPicture(userBaseInfo.getUserPicture());
        userInfo.setStatus(userBaseInfo.getStatus());
        return userInfo;
    }


    private Long userId;
    private String openId;
    private BigDecimal balance;
    private String userPicture;
    private String nickname;
    private String sex;
    private String userLevel;
    private String city;
    private String country;
    private String province;
    private String userMobile;
    private Integer status;



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }
}
