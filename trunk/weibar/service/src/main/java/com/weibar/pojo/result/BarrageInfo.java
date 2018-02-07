package com.weibar.pojo.result;


import com.weibar.pojo.db.WeibarMerchantsBarrageInfo;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * 返回给前端的跑马灯类
 * Created by Administrator on 2017/10/31.
 */
public class BarrageInfo {


    private Long merchantId;
    private Long messageId;
    private Long userId;
    private String userLevel;
    private String nickName;
    private String userPic;
    private String sex;
    private String content;
    private Integer type;
    private Integer status;
    private Long redPackageId;
    private String redPackageTitle;
    private Integer redPackageStatus;
    private String redPackageGiveOpenId;
    private Long redPackageGiveUserId;
    private BigDecimal redPackageAmount;
    private Integer screenNum;
    private Long createTime;
    private String msgImgUrl;



    private Integer second;


    private String barpinOpenId;
    private Long barpinUserId;
    private String barpinUserName;
    private String barpinContent;
    private Integer barpinTheme;



    private UserRedPackage userRedPackage;
    private GiveInfo giveInfo;








    /**
     * 通过数据库类生成出前端结果类
     * @param weibarMerchantsBarrageInfo
     * @return
     */
    public static BarrageInfo formBarrageInfo(WeibarMerchantsBarrageInfo weibarMerchantsBarrageInfo){

        BarrageInfo barrageInfo = new BarrageInfo();

        barrageInfo.setMerchantId(weibarMerchantsBarrageInfo.getMerchantid());
        barrageInfo.setMessageId(weibarMerchantsBarrageInfo.getId());
        barrageInfo.setUserId(weibarMerchantsBarrageInfo.getUserId());
        barrageInfo.setStatus(weibarMerchantsBarrageInfo.getStatus());
        barrageInfo.setType(weibarMerchantsBarrageInfo.getType());
        barrageInfo.setContent(weibarMerchantsBarrageInfo.getContext());
        barrageInfo.setCreateTime(weibarMerchantsBarrageInfo.getCreateTime().getTime());

        barrageInfo.setNickName(weibarMerchantsBarrageInfo.getNickname());
        barrageInfo.setRedPackageId(weibarMerchantsBarrageInfo.getRedpackageid());
        barrageInfo.setScreenNum(weibarMerchantsBarrageInfo.getScreenNum());
        barrageInfo.setSex(weibarMerchantsBarrageInfo.getSex());
        barrageInfo.setUserLevel(weibarMerchantsBarrageInfo.getUserLevel());
        barrageInfo.setUserPic(weibarMerchantsBarrageInfo.getUserPicture());
        barrageInfo.setRedPackageTitle(weibarMerchantsBarrageInfo.getRedpackageTitle());
        barrageInfo.setRedPackageStatus(weibarMerchantsBarrageInfo.getStatus());
        barrageInfo.setMsgImgUrl(weibarMerchantsBarrageInfo.getImgUrl());
        barrageInfo.setRedPackageGiveOpenId(weibarMerchantsBarrageInfo.getRedpackageGiveOpenid());
        barrageInfo.setRedPackageGiveUserId(weibarMerchantsBarrageInfo.getRedpackageGiveUserId());
        barrageInfo.setRedPackageAmount(weibarMerchantsBarrageInfo.getRedpackageAmount());
        barrageInfo.setSecond(weibarMerchantsBarrageInfo.getTimesid());

        barrageInfo.setBarpinOpenId(weibarMerchantsBarrageInfo.getBarpinOpenid());
        barrageInfo.setBarpinUserId(weibarMerchantsBarrageInfo.getBarpinUserId());
        barrageInfo.setBarpinUserName(weibarMerchantsBarrageInfo.getBarpinUserName());
        barrageInfo.setBarpinContent(weibarMerchantsBarrageInfo.getBarContent());
        barrageInfo.setBarpinTheme(weibarMerchantsBarrageInfo.getBarpinTheme());


        if(StringUtils.isNoneBlank(weibarMerchantsBarrageInfo.getGiveUserName())) {
            GiveInfo giveInfo = new GiveInfo();
            giveInfo.setContent(weibarMerchantsBarrageInfo.getGiveContent());
            giveInfo.setGiftImgUrl(weibarMerchantsBarrageInfo.getGiveGoodsurl());
            giveInfo.setGiftName(weibarMerchantsBarrageInfo.getGiveGoodsname());
            giveInfo.setGivenUserImgUrl(weibarMerchantsBarrageInfo.getGiveUserImgUrl());
            giveInfo.setGivenUserName(weibarMerchantsBarrageInfo.getGiveUserName());
            giveInfo.setGoodsId(weibarMerchantsBarrageInfo.getGiveGoodsId());
            barrageInfo.setGiveInfo(giveInfo);
        }
        return barrageInfo;
    }

    public Integer getBarpinTheme() {
        return barpinTheme;
    }

    public void setBarpinTheme(Integer barpinTheme) {
        this.barpinTheme = barpinTheme;
    }

    public UserRedPackage getUserRedPackage() {
        return userRedPackage;
    }

    public void setUserRedPackage(UserRedPackage userRedPackage) {
        this.userRedPackage = userRedPackage;
    }

    public String getBarpinContent() {
        return barpinContent;
    }

    public void setBarpinContent(String barpinContent) {
        this.barpinContent = barpinContent;
    }

    public String getBarpinOpenId() {
        return barpinOpenId;
    }

    public void setBarpinOpenId(String barpinOpenId) {
        this.barpinOpenId = barpinOpenId;
    }

    public Long getBarpinUserId() {
        return barpinUserId;
    }

    public void setBarpinUserId(Long barpinUserId) {
        this.barpinUserId = barpinUserId;
    }

    public String getBarpinUserName() {
        return barpinUserName;
    }

    public void setBarpinUserName(String barpinUserName) {
        this.barpinUserName = barpinUserName;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public String getRedPackageGiveOpenId() {
        return redPackageGiveOpenId;
    }

    public void setRedPackageGiveOpenId(String redPackageGiveOpenId) {
        this.redPackageGiveOpenId = redPackageGiveOpenId;
    }

    public String getMsgImgUrl() {
        return msgImgUrl;
    }

    public void setMsgImgUrl(String msgImgUrl) {
        this.msgImgUrl = msgImgUrl;
    }

    public Integer getRedPackageStatus() {
        return redPackageStatus;
    }

    public void setRedPackageStatus(Integer redPackageStatus) {
        this.redPackageStatus = redPackageStatus;
    }

    public GiveInfo getGiveInfo() {
        return giveInfo;
    }

    public void setGiveInfo(GiveInfo giveInfo) {
        this.giveInfo = giveInfo;
    }

    public String getRedPackageTitle() {
        return redPackageTitle;
    }

    public void setRedPackageTitle(String redPackageTitle) {
        this.redPackageTitle = redPackageTitle;
    }


    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String  sex) {
        this.sex = sex;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getRedPackageId() {
        return redPackageId;
    }

    public void setRedPackageId(Long redPackageId) {
        this.redPackageId = redPackageId;
    }

    public Integer getScreenNum() {
        return screenNum;
    }

    public void setScreenNum(Integer screenNum) {
        this.screenNum = screenNum;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getRedPackageGiveUserId() {
        return redPackageGiveUserId;
    }

    public void setRedPackageGiveUserId(Long redPackageGiveUserId) {
        this.redPackageGiveUserId = redPackageGiveUserId;
    }

    public BigDecimal getRedPackageAmount() {
        return redPackageAmount;
    }

    public void setRedPackageAmount(BigDecimal redPackageAmount) {
        this.redPackageAmount = redPackageAmount;
    }
}
