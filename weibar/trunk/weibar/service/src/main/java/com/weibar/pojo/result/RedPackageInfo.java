package com.weibar.pojo.result;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/12/18.
 */
public class RedPackageInfo {

    private Long redPackageId;
    private String title;
    private Integer status;
    private String giveOpenId;
    private boolean hasGetThisRedPackage;


    public BigDecimal getHasGetAmount() {
        return hasGetAmount;
    }

    public void setHasGetAmount(BigDecimal hasGetAmount) {
        this.hasGetAmount = hasGetAmount;
    }

    private BigDecimal hasGetAmount;


    public Long getRedPackageId() {
        return redPackageId;
    }

    public void setRedPackageId(Long redPackageId) {
        this.redPackageId = redPackageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getGiveOpenId() {
        return giveOpenId;
    }

    public void setGiveOpenId(String giveOpenId) {
        this.giveOpenId = giveOpenId;
    }

    public boolean isHasGetThisRedPackage() {
        return hasGetThisRedPackage;
    }

    public void setHasGetThisRedPackage(boolean hasGetThisRedPackage) {
        this.hasGetThisRedPackage = hasGetThisRedPackage;
    }
}
