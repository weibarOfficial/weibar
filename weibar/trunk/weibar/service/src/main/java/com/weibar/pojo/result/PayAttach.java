package com.weibar.pojo.result;

/**
 * 支付的时候透传给渠道的参数，以用于在渠道支付成功的时候回传
 */
public class PayAttach {

    //用于标识不同场景（RechargeSceneTypeEnum）
    private Integer rechargeScene;



    private Long userId;
    private Long userIdGiven;
    private Long merchantId;
    private String userIp;
    private Long goodsId;
    private String content;
    private Integer giveType;
    private Long messageId;
    private Integer second;
    private Integer times;
    private Long redPackageId;
    private Integer barpinTheme;
    private Long dakaOrderId;


    public Long getDakaOrderId() {
        return dakaOrderId;
    }

    public void setDakaOrderId(Long dakaOrderId) {
        this.dakaOrderId = dakaOrderId;
    }

    public Integer getBarpinTheme() {
        return barpinTheme;
    }

    public void setBarpinTheme(Integer barpinTheme) {
        this.barpinTheme = barpinTheme;
    }

    public Long getRedPackageId() {
        return redPackageId;
    }

    public void setRedPackageId(Long redPackageId) {
        this.redPackageId = redPackageId;
    }

    public Integer getRechargeScene() {
        return rechargeScene;
    }

    public void setRechargeScene(Integer rechargeScene) {
        this.rechargeScene = rechargeScene;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserIdGiven() {
        return userIdGiven;
    }

    public void setUserIdGiven(Long userIdGiven) {
        this.userIdGiven = userIdGiven;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getGiveType() {
        return giveType;
    }

    public void setGiveType(Integer giveType) {
        this.giveType = giveType;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "PayAttach{" +
                "rechargeScene=" + rechargeScene +
                ", userId=" + userId +
                ", userIdGiven=" + userIdGiven +
                ", merchantId=" + merchantId +
                ", userIp='" + userIp + '\'' +
                ", goodsId=" + goodsId +
                ", content='" + content + '\'' +
                ", giveType=" + giveType +
                ", messageId=" + messageId +
                ", second=" + second +
                ", times=" + times +
                '}';
    }
}
