package com.weibar.pojo.result;

import com.weibar.pojo.db.DakaUser;
import com.weibar.pojo.enu.DakaButtonEnum;
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

    private boolean hasPayTodayDakaOrder;

    private boolean hasPayYesterdayDakaOrder;

    private boolean hasPayTomorrowDakaOrder;

    private boolean inDakaTime;

    private Long userId;
    private String openId;


    private String dakaBindTap;
    private boolean dakaDisabled;
    private String dakaText;






    public static DakaResultUser getDakaResultUserDetail(DakaUser dakaUser,
                                                         boolean hasPayTodayDakaOrder,
                                                         boolean hasPayYesterdayDakaOrder,
                                                         boolean inDakaTime,
                                                         boolean hasPayTomorrowDakaOrder,DakaButtonEnum dakaButton){
        DakaResultUser dakaResultUser = getDakaResultUser(dakaUser);
        dakaResultUser.setHasPayTodayDakaOrder(hasPayTodayDakaOrder);
        dakaResultUser.setHasPayYesterdayDakaOrder(hasPayYesterdayDakaOrder);
        dakaResultUser.setInDakaTime(inDakaTime);
        dakaResultUser.setHasPayTomorrowDakaOrder(hasPayTomorrowDakaOrder);
        dakaResultUser.setDakaBindTap(dakaButton.getBindTap());
        dakaResultUser.setDakaDisabled(dakaButton.isDisabled());
        dakaResultUser.setDakaText(dakaButton.getText());
        return dakaResultUser;
    }


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
        dakaResultUser.setUserId(dakaUser.getUserId());
        dakaResultUser.setOpenId(dakaUser.getOpenid());
        return dakaResultUser;
    }


    public String getDakaBindTap() {
        return dakaBindTap;
    }

    public void setDakaBindTap(String dakaBindTap) {
        this.dakaBindTap = dakaBindTap;
    }

    public boolean isDakaDisabled() {
        return dakaDisabled;
    }

    public void setDakaDisabled(boolean dakaDisabled) {
        this.dakaDisabled = dakaDisabled;
    }

    public String getDakaText() {
        return dakaText;
    }

    public void setDakaText(String dakaText) {
        this.dakaText = dakaText;
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

    public boolean isHasPayTomorrowDakaOrder() {
        return hasPayTomorrowDakaOrder;
    }

    public void setHasPayTomorrowDakaOrder(boolean hasPayTomorrowDakaOrder) {
        this.hasPayTomorrowDakaOrder = hasPayTomorrowDakaOrder;
    }

    public boolean isHasPayTodayDakaOrder() {
        return hasPayTodayDakaOrder;
    }

    public void setHasPayTodayDakaOrder(boolean hasPayTodayDakaOrder) {
        this.hasPayTodayDakaOrder = hasPayTodayDakaOrder;
    }

    public boolean isHasPayYesterdayDakaOrder() {
        return hasPayYesterdayDakaOrder;
    }

    public void setHasPayYesterdayDakaOrder(boolean hasPayYesterdayDakaOrder) {
        this.hasPayYesterdayDakaOrder = hasPayYesterdayDakaOrder;
    }

    public boolean isInDakaTime() {
        return inDakaTime;
    }

    public void setInDakaTime(boolean inDakaTime) {
        this.inDakaTime = inDakaTime;
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
