package com.weibar.pojo.result;

import com.weibar.pojo.db.WeibarRedpackageDepositDetail;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/14.
 */
public class UserRedPackage {

    public static UserRedPackage getUserRedPackage(WeibarRedpackageDepositDetail detail){
        UserRedPackage userRedPackage = new UserRedPackage();
        userRedPackage.setRedpackettitle(detail.getRedpackettitle());
        userRedPackage.setAmount(detail.getAmount());
        if(detail.getIsBest() > 0){
            userRedPackage.setBest(true);
        }else{
            userRedPackage.setBest(false);
        }
        userRedPackage.setNickname(detail.getNickname());
        userRedPackage.setOpenId(detail.getOpenid());
        userRedPackage.setUserPicture(detail.getUserPicture());
        userRedPackage.setGetTime(detail.getGetTime());
        userRedPackage.setRedPackageId(detail.getRedpackageid());
        return userRedPackage;
    }

    private Long redPackageId;
    private BigDecimal amount;
    private String openId;
    private String nickname;
    private String userPicture;
    private boolean isBest;
    private String redpackettitle;
    private Date getTime;

    public Long getRedPackageId() {
        return redPackageId;
    }

    public void setRedPackageId(Long redPackageId) {
        this.redPackageId = redPackageId;
    }


    public Date getGetTime() {
        return getTime;
    }

    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }
    public boolean isBest() {
        return isBest;
    }

    public void setBest(boolean best) {
        isBest = best;
    }

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

    @Override
    public String toString() {
        return "UserRedPackage{" +
                "amount=" + amount +
                ", openId='" + openId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", userPicture='" + userPicture + '\'' +
                ", isBest=" + isBest +
                ", redpackettitle='" + redpackettitle + '\'' +
                '}';
    }
}
