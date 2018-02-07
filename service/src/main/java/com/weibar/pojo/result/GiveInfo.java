package com.weibar.pojo.result;

/**
 * Created by Administrator on 2017/12/11.
 */
public class GiveInfo {

    private String givenUserImgUrl;
    private String content;
    private String giftName;
    private String giftImgUrl;
    private String givenUserName;
    private Long goodsId;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGivenUserName() {
        return givenUserName;
    }

    public void setGivenUserName(String givenUserName) {
        this.givenUserName = givenUserName;
    }

    public String getGivenUserImgUrl() {
        return givenUserImgUrl;
    }

    public void setGivenUserImgUrl(String givenUserImgUrl) {
        this.givenUserImgUrl = givenUserImgUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public String getGiftImgUrl() {
        return giftImgUrl;
    }

    public void setGiftImgUrl(String giftImgUrl) {
        this.giftImgUrl = giftImgUrl;
    }
}
