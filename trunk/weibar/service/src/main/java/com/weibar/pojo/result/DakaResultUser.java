package com.weibar.pojo.result;

import com.weibar.pojo.db.DakaUser;
import com.weibar.service.function.DakaService;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2018/2/2.
 */
public class DakaResultUser {

    private String userPicture;

    private String nickname;

    private String sex;

    private String city;

    private String country;

    private String province;

    private Integer count;

    private Integer scount;

    private Integer fcount;

    private BigDecimal paySumAmount;

    private BigDecimal getSumAmount;

    /**
     * 对称加密，里面保存着userId
     */
    private String sessionKey;


    public static DakaResultUser getDakaResultUser(DakaUser dakaUser){
        DakaResultUser dakaResultUser = new DakaResultUser();
        dakaResultUser.setCity(dakaUser.getCity());
        dakaResultUser.setCount(dakaUser.getCount());
        dakaResultUser.setCountry(dakaUser.getCountry());
        dakaResultUser.setFcount(dakaUser.getFcount());
        dakaResultUser.setGetSumAmount(dakaUser.getGetSumAmount());
        dakaResultUser.setNickname(dakaUser.getNickname());
        dakaResultUser.setPaySumAmount(dakaUser.getPaySumAmount());
        dakaResultUser.setProvince(dakaUser.getProvince());
        dakaResultUser.setScount(dakaUser.getScount());
        dakaResultUser.setSessionKey(DakaService.genSessionKey(dakaUser.getUserId()));
        dakaResultUser.setSex(dakaUser.getSex());
        dakaResultUser.setUserPicture(dakaUser.getUserPicture());
        return dakaResultUser;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getScount() {
        return scount;
    }

    public void setScount(Integer scount) {
        this.scount = scount;
    }

    public Integer getFcount() {
        return fcount;
    }

    public void setFcount(Integer fcount) {
        this.fcount = fcount;
    }

    public BigDecimal getPaySumAmount() {
        return paySumAmount;
    }

    public void setPaySumAmount(BigDecimal paySumAmount) {
        this.paySumAmount = paySumAmount;
    }

    public BigDecimal getGetSumAmount() {
        return getSumAmount;
    }

    public void setGetSumAmount(BigDecimal getSumAmount) {
        this.getSumAmount = getSumAmount;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
