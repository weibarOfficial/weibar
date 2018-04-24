package com.weibar.pojo.result;

import com.weibar.pojo.db.WeibarMerchantsGoodsSettingInfo;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/11/22.
 */
public class GoodsSettingInfo {


    public static GoodsSettingInfo getGoodsSettingInfo(WeibarMerchantsGoodsSettingInfo info){
        GoodsSettingInfo goodsSettingInfo = new GoodsSettingInfo();
        goodsSettingInfo.setGoodsId(info.getGoodsid());
        goodsSettingInfo.setGoodsName(info.getGoodsname());
        goodsSettingInfo.setGoodsImgUrl(info.getGoodsurl());
        goodsSettingInfo.setGoodsAmount(info.getAmount());
        goodsSettingInfo.setGoodsBigUrl(info.getGoodsBigUrl());
        goodsSettingInfo.setWidth(info.getWidth());
        goodsSettingInfo.setHeight(info.getHeight());
        goodsSettingInfo.setTime(info.getTime());
        goodsSettingInfo.setGoodsMsg(info.getGoodsMsg());
        goodsSettingInfo.setGoodsIdStr(info.getGoodsid().toString());
        goodsSettingInfo.setGoodsAmountStr(info.getAmount().toPlainString());
        return goodsSettingInfo;
    }



    private Long goodsId;
    private String goodsName;
    private String goodsImgUrl;
    private String goodsBigUrl;
    private BigDecimal goodsAmount;
    private Integer width;
    private Integer height;
    private Integer time;
    private String goodsMsg;


    private String goodsIdStr;
    private String goodsAmountStr;


    public String getGoodsIdStr() {
        return goodsIdStr;
    }

    public void setGoodsIdStr(String goodsIdStr) {
        this.goodsIdStr = goodsIdStr;
    }

    public String getGoodsAmountStr() {
        return goodsAmountStr;
    }

    public void setGoodsAmountStr(String goodsAmountStr) {
        this.goodsAmountStr = goodsAmountStr;
    }

    public String getGoodsBigUrl() {
        return goodsBigUrl;
    }

    public void setGoodsBigUrl(String goodsBigUrl) {
        this.goodsBigUrl = goodsBigUrl;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getGoodsMsg() {
        return goodsMsg;
    }

    public void setGoodsMsg(String goodsMsg) {
        this.goodsMsg = goodsMsg;
    }

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImgUrl() {
        return goodsImgUrl;
    }

    public void setGoodsImgUrl(String goodsImgUrl) {
        this.goodsImgUrl = goodsImgUrl;
    }
}
