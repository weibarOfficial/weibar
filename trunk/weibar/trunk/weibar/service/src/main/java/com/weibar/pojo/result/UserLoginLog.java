package com.weibar.pojo.result;

import com.weibar.pojo.db.WeibarMerchantsLoginLog;

/**
 * Created by Administrator on 2017/11/1.
 *
 * 返回给前端的用户访问记录类
 */
public class UserLoginLog {



    private Long logId;
    private String merchantId;
    private String merchantName;
    private Long lastLogInTime;
    private String merchantUrl;


    public static UserLoginLog getUserLoginLog(WeibarMerchantsLoginLog weibarMerchantsLoginLog){
        UserLoginLog userLoginLog = new UserLoginLog();
        userLoginLog.setLastLogInTime(weibarMerchantsLoginLog.getLoginTime().getTime());
        userLoginLog.setMerchantId(weibarMerchantsLoginLog.getMerchantid().toString());
        userLoginLog.setMerchantName(weibarMerchantsLoginLog.getMerchantsName());
        userLoginLog.setMerchantUrl(weibarMerchantsLoginLog.getProducerlogoUrl());
        userLoginLog.setLogId(weibarMerchantsLoginLog.getId());
        return userLoginLog;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Long getLastLogInTime() {
        return lastLogInTime;
    }

    public void setLastLogInTime(Long lastLogInTime) {
        this.lastLogInTime = lastLogInTime;
    }

    public String getMerchantUrl() {
        return merchantUrl;
    }

    public void setMerchantUrl(String merchantUrl) {
        this.merchantUrl = merchantUrl;
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }
}
