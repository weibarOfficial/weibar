package com.weibar.pojo.result;

import com.weibar.pojo.db.DakaUserRank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/7.
 */
public class DakaResultUserRank {



    private String userPicture;


    private String openid;


    private String nickname;


    private String sex;


    private Integer rank;


    private BigDecimal getSumAmount;


    public static DakaResultUserRank toDakaResultUserRank(DakaUserRank dakaUserRank){
        DakaResultUserRank dakaResultUserRank = new DakaResultUserRank();
        dakaResultUserRank.setGetSumAmount(dakaUserRank.getGetSumAmount());
        dakaResultUserRank.setNickname(dakaUserRank.getNickname());
        dakaResultUserRank.setOpenid(dakaUserRank.getOpenid());
        dakaResultUserRank.setRank(dakaUserRank.getRank());
        dakaResultUserRank.setSex(dakaUserRank.getSex());
        dakaResultUserRank.setUserPicture(dakaUserRank.getUserPicture());
        return dakaResultUserRank;
    }

    public static List<DakaResultUserRank> toDakaResultUserRanks(List<DakaUserRank> dakaUserRanks){
        List<DakaResultUserRank> res = new ArrayList<>();
        for(DakaUserRank dakaUserRank : dakaUserRanks){
            res.add(toDakaResultUserRank(dakaUserRank));
        }
        return res;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public BigDecimal getGetSumAmount() {
        return getSumAmount;
    }

    public void setGetSumAmount(BigDecimal getSumAmount) {
        this.getSumAmount = getSumAmount;
    }

    @Override
    public String toString() {
        return "DakaResultUserRank{" +
                "userPicture='" + userPicture + '\'' +
                ", openid='" + openid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", rank=" + rank +
                ", getSumAmount=" + getSumAmount +
                '}';
    }
}
