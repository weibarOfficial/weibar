package com.weibar.pojo.result;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/11/20.
 */
public class UserRedPackageDetail {

    // 红包相关总信息
    private BigDecimal amount;
    private String openId;
    private String nickname;
    private String userPicture;
    private String redpackettitle;
    private Integer sendNumber;
    private Integer getNumber;




    private Date createTime;

    //领取了的红包信息
    private List<UserRedPackage> userRedPackageList;


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public String getRedpackettitle() {
        return redpackettitle;
    }

    public void setRedpackettitle(String redpackettitle) {
        this.redpackettitle = redpackettitle;
    }

    public List<UserRedPackage> getUserRedPackageList() {
        return userRedPackageList;
    }

    public void setUserRedPackageList(List<UserRedPackage> userRedPackageList) {
        this.userRedPackageList = userRedPackageList;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSendNumber() {
        return sendNumber;
    }

    public void setSendNumber(Integer sendNumber) {
        this.sendNumber = sendNumber;
    }

    public Integer getGetNumber() {
        return getNumber;
    }

    public void setGetNumber(Integer getNumber) {
        this.getNumber = getNumber;
    }
}
