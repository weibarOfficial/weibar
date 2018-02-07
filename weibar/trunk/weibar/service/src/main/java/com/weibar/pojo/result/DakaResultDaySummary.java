package com.weibar.pojo.result;

import com.weibar.pojo.db.DakaDaySummary;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2018/2/1.
 */
public class DakaResultDaySummary {

    private Date dakaDate;

    private Integer count;

    private Integer scount;

    private Integer fcount;

    private String earlyOpenId;

    private Date earlyTime;

    private Long earlyUserId;

    private String earlyUserPicture;

    private String luckyOpenId;

    private BigDecimal luckyAmount;

    private Long luckyUserId;

    private String luckyUserPicture;

    private String gutsOpenId;

    private Integer gutsCount;

    private Long gutsUserId;

    private String gutsUserPicture;


    private BigDecimal payAmount;


    private BigDecimal sendAmount;


    public static DakaResultDaySummary getDakaResultDaySummary(DakaDaySummary dakaDaySummary){
        DakaResultDaySummary daySummary = new DakaResultDaySummary();
        daySummary.setScount(dakaDaySummary.getScount());
        daySummary.setCount(dakaDaySummary.getCount());
        daySummary.setDakaDate(dakaDaySummary.getDakaDate());
        daySummary.setEarlyOpenId(dakaDaySummary.getEarlyOpenId());
        daySummary.setEarlyTime(dakaDaySummary.getEarlyTime());
        daySummary.setEarlyUserId(dakaDaySummary.getEarlyUserId());
        daySummary.setEarlyUserPicture(dakaDaySummary.getEarlyUserPicture());
        daySummary.setFcount(dakaDaySummary.getFcount());
        daySummary.setGutsCount(dakaDaySummary.getGutsCount());
        daySummary.setGutsOpenId(dakaDaySummary.getGutsOpenId());
        daySummary.setGutsUserId(dakaDaySummary.getGutsUserId());
        daySummary.setGutsUserPicture(dakaDaySummary.getGutsUserPicture());
        daySummary.setLuckyAmount(dakaDaySummary.getLuckyAmount());
        daySummary.setLuckyOpenId(dakaDaySummary.getLuckyOpenId());
        daySummary.setLuckyUserId(dakaDaySummary.getLuckyUserId());
        daySummary.setLuckyUserPicture(dakaDaySummary.getLuckyUserPicture());
        daySummary.setPayAmount(dakaDaySummary.getPayAmount());
        daySummary.setSendAmount(dakaDaySummary.getSendAmount());
        return daySummary;
    }


    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getSendAmount() {
        return sendAmount;
    }

    public void setSendAmount(BigDecimal sendAmount) {
        this.sendAmount = sendAmount;
    }

    public Date getDakaDate() {
        return dakaDate;
    }

    public void setDakaDate(Date dakaDate) {
        this.dakaDate = dakaDate;
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

    public String getEarlyOpenId() {
        return earlyOpenId;
    }

    public void setEarlyOpenId(String earlyOpenId) {
        this.earlyOpenId = earlyOpenId;
    }

    public Date getEarlyTime() {
        return earlyTime;
    }

    public void setEarlyTime(Date earlyTime) {
        this.earlyTime = earlyTime;
    }

    public Long getEarlyUserId() {
        return earlyUserId;
    }

    public void setEarlyUserId(Long earlyUserId) {
        this.earlyUserId = earlyUserId;
    }

    public String getEarlyUserPicture() {
        return earlyUserPicture;
    }

    public void setEarlyUserPicture(String earlyUserPicture) {
        this.earlyUserPicture = earlyUserPicture;
    }

    public String getLuckyOpenId() {
        return luckyOpenId;
    }

    public void setLuckyOpenId(String luckyOpenId) {
        this.luckyOpenId = luckyOpenId;
    }

    public BigDecimal getLuckyAmount() {
        return luckyAmount;
    }

    public void setLuckyAmount(BigDecimal luckyAmount) {
        this.luckyAmount = luckyAmount;
    }

    public Long getLuckyUserId() {
        return luckyUserId;
    }

    public void setLuckyUserId(Long luckyUserId) {
        this.luckyUserId = luckyUserId;
    }

    public String getLuckyUserPicture() {
        return luckyUserPicture;
    }

    public void setLuckyUserPicture(String luckyUserPicture) {
        this.luckyUserPicture = luckyUserPicture;
    }

    public String getGutsOpenId() {
        return gutsOpenId;
    }

    public void setGutsOpenId(String gutsOpenId) {
        this.gutsOpenId = gutsOpenId;
    }

    public Integer getGutsCount() {
        return gutsCount;
    }

    public void setGutsCount(Integer gutsCount) {
        this.gutsCount = gutsCount;
    }

    public Long getGutsUserId() {
        return gutsUserId;
    }

    public void setGutsUserId(Long gutsUserId) {
        this.gutsUserId = gutsUserId;
    }

    public String getGutsUserPicture() {
        return gutsUserPicture;
    }

    public void setGutsUserPicture(String gutsUserPicture) {
        this.gutsUserPicture = gutsUserPicture;
    }

    @Override
    public String toString() {
        return "DakaIndexSummary{" +
                "dakaDate=" + dakaDate +
                ", count=" + count +
                ", scount=" + scount +
                ", fcount=" + fcount +
                ", earlyOpenId='" + earlyOpenId + '\'' +
                ", earlyTime=" + earlyTime +
                ", earlyUserId=" + earlyUserId +
                ", earlyUserPicture='" + earlyUserPicture + '\'' +
                ", luckyOpenId='" + luckyOpenId + '\'' +
                ", luckyAmount=" + luckyAmount +
                ", luckyUserId=" + luckyUserId +
                ", luckyUserPicture='" + luckyUserPicture + '\'' +
                ", gutsOpenId='" + gutsOpenId + '\'' +
                ", gutsCount=" + gutsCount +
                ", gutsUserId=" + gutsUserId +
                ", gutsUserPicture='" + gutsUserPicture + '\'' +
                '}';
    }
}
