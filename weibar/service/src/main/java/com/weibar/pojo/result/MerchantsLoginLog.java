package com.weibar.pojo.result;

import com.weibar.pojo.db.WeibarMerchantsLoginLog;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantsLoginLog {

    private String openid;

    private String userId;

    private String loginTime;

    private String userPicture;

    private String nickname;

    private String sex;

    private String location;


    public static MerchantsLoginLog getMerchantsLoginLog(WeibarMerchantsLoginLog weibarMerchantsLoginLog){
        MerchantsLoginLog merchantsLoginLog = new MerchantsLoginLog();



        merchantsLoginLog.setOpenid(weibarMerchantsLoginLog.getOpenid());
        StringBuilder stringBuilder = new StringBuilder();
        if(StringUtils.isNotBlank(weibarMerchantsLoginLog.getCountry())){
            stringBuilder.append(weibarMerchantsLoginLog.getCountry() + ",");
        }
        if(StringUtils.isNotBlank(weibarMerchantsLoginLog.getProvince())){
            stringBuilder.append(weibarMerchantsLoginLog.getProvince() + ",");
        }
        if(StringUtils.isNotBlank(weibarMerchantsLoginLog.getCity())){
            stringBuilder.append(weibarMerchantsLoginLog.getCity() );
        }
        String location = stringBuilder.toString();
        merchantsLoginLog.setLocation(location);

        merchantsLoginLog.setLoginTime(new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(weibarMerchantsLoginLog.getLoginTime()));
        merchantsLoginLog.setNickname(weibarMerchantsLoginLog.getNickname());
        if(weibarMerchantsLoginLog.getSex().contains("1")){
            merchantsLoginLog.setSex("男");
        }else if(weibarMerchantsLoginLog.getSex().contains("0")){
            merchantsLoginLog.setSex("女");
        }else{
            merchantsLoginLog.setSex("未知");
        }
        merchantsLoginLog.setUserId(weibarMerchantsLoginLog.getUserId().toString());
        merchantsLoginLog.setUserPicture(weibarMerchantsLoginLog.getUserPicture());
        return merchantsLoginLog;
    }


    public static List<MerchantsLoginLog> getMerchantsLoginLogs(List<WeibarMerchantsLoginLog> weibarMerchantsLoginLogs){
        List<MerchantsLoginLog> merchantsLoginLogs = new ArrayList<>();
        for(WeibarMerchantsLoginLog weibarMerchantsLoginLog :  weibarMerchantsLoginLogs){
            merchantsLoginLogs.add(getMerchantsLoginLog(weibarMerchantsLoginLog));
        }
        return merchantsLoginLogs;
    }



    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "MerchantsLoginLog{" +
                "openid='" + openid + '\'' +
                ", userId=" + userId +
                ", loginTime=" + loginTime +
                ", userPicture='" + userPicture + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
