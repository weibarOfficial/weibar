package com.weibar.pojo.result;

import com.weibar.pojo.db.WeibarMerchantsBaseInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
public class MerchantInfo {


    public static MerchantInfo getMerchantInfo(WeibarMerchantsBaseInfo weibarMerchantsBaseInfo){
        MerchantInfo merchantInfo = new MerchantInfo();
        merchantInfo.setName(weibarMerchantsBaseInfo.getMerchantsName());
        merchantInfo.setLogoUrl(weibarMerchantsBaseInfo.getProducerlogoUrl());
        merchantInfo.setQRCodeUrl(weibarMerchantsBaseInfo.getQrcodeUrl());
        merchantInfo.setMerchantId(weibarMerchantsBaseInfo.getMerchantid());
        merchantInfo.setWechatLoginUrl(weibarMerchantsBaseInfo.getWechatLoginUrl());
        return merchantInfo;
    }


    public static List<MerchantInfo> getMerchantInfos(List<WeibarMerchantsBaseInfo> weibarMerchantsBaseInfos){
        List<MerchantInfo> list = new ArrayList<>();
        for(WeibarMerchantsBaseInfo weibarMerchantsBaseInfo : weibarMerchantsBaseInfos){
            list.add(getMerchantInfo(weibarMerchantsBaseInfo));
        }
        return list;
    }

    private Long merchantId;
    private String name;
    private String logoUrl;
    private String QRCodeUrl;
    private String wechatLoginUrl;

    public String getWechatLoginUrl() {
        return wechatLoginUrl;
    }

    public void setWechatLoginUrl(String wechatLoginUrl) {
        this.wechatLoginUrl = wechatLoginUrl;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getQRCodeUrl() {
        return QRCodeUrl;
    }

    public void setQRCodeUrl(String QRCodeUrl) {
        this.QRCodeUrl = QRCodeUrl;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
