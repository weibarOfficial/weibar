package com.weibar.pojo.result;

import com.weibar.pojo.db.WeibarMerchantsBaseInfo;
import com.weibar.pojo.enu.MerchantRoleEnum;

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
        merchantInfo.setParentMerchantid(weibarMerchantsBaseInfo.getParentMerchantid());
        merchantInfo.setRole(weibarMerchantsBaseInfo.getRole());
        merchantInfo.setSharingRatio(weibarMerchantsBaseInfo.getSharingRatio());
        merchantInfo.setSharingRatioBarpin(weibarMerchantsBaseInfo.getSharingRatioBarpin());
        if(weibarMerchantsBaseInfo.getSharingRatioBarpin() > 0) {
            merchantInfo.setSharingRatioBarpinStr(weibarMerchantsBaseInfo.getSharingRatioBarpin()/10.0 + "%");
        }else{
            merchantInfo.setSharingRatioBarpinStr("0");
        }
        if(weibarMerchantsBaseInfo.getSharingRatioRedp() > 0){
            merchantInfo.setSharingRatioRedpStr(weibarMerchantsBaseInfo.getSharingRatioRedp()/10.0 + "%");
        }else{
            merchantInfo.setSharingRatioRedpStr("0");
        }
        if(weibarMerchantsBaseInfo.getSharingRatioGive() > 0){
            merchantInfo.setSharingRatioGiveStr(weibarMerchantsBaseInfo.getSharingRatioGive()/10.0 + "%");
        }else {
            merchantInfo.setSharingRatioGiveStr("0");
        }


        merchantInfo.setRoleStr(MerchantRoleEnum.getRoleByType(merchantInfo.getRole()).getDesc());
        merchantInfo.setSharingRatioRedp(weibarMerchantsBaseInfo.getSharingRatioRedp());
        merchantInfo.setSharingRatioGive(weibarMerchantsBaseInfo.getSharingRatioGive());
        merchantInfo.setLoginName(weibarMerchantsBaseInfo.getLoginName());
        merchantInfo.setUserId(weibarMerchantsBaseInfo.getUserId());
        merchantInfo.setMerchantIdStr(merchantInfo.getMerchantId().toString());
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
    private Long parentMerchantid;
    private Integer role;
    private Integer sharingRatio;
    private Integer sharingRatioBarpin;
    private Integer sharingRatioRedp;
    private Integer sharingRatioGive;
    private String loginName;
    private Long userId;


    private String sharingRatioBarpinStr;
    private String sharingRatioRedpStr;
    private String sharingRatioGiveStr;
    private String roleStr;
    private String merchantIdStr;


    public String getRoleStr() {
        return roleStr;
    }

    public void setRoleStr(String roleStr) {
        this.roleStr = roleStr;
    }

    public Long getParentMerchantid() {
        return parentMerchantid;
    }

    public void setParentMerchantid(Long parentMerchantid) {
        this.parentMerchantid = parentMerchantid;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getSharingRatio() {
        return sharingRatio;
    }

    public void setSharingRatio(Integer sharingRatio) {
        this.sharingRatio = sharingRatio;
    }

    public Integer getSharingRatioBarpin() {
        return sharingRatioBarpin;
    }

    public void setSharingRatioBarpin(Integer sharingRatioBarpin) {
        this.sharingRatioBarpin = sharingRatioBarpin;
    }

    public Integer getSharingRatioRedp() {
        return sharingRatioRedp;
    }

    public void setSharingRatioRedp(Integer sharingRatioRedp) {
        this.sharingRatioRedp = sharingRatioRedp;
    }

    public Integer getSharingRatioGive() {
        return sharingRatioGive;
    }

    public void setSharingRatioGive(Integer sharingRatioGive) {
        this.sharingRatioGive = sharingRatioGive;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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


    public String getSharingRatioBarpinStr() {
        return sharingRatioBarpinStr;
    }

    public void setSharingRatioBarpinStr(String sharingRatioBarpinStr) {
        this.sharingRatioBarpinStr = sharingRatioBarpinStr;
    }

    public String getSharingRatioRedpStr() {
        return sharingRatioRedpStr;
    }

    public void setSharingRatioRedpStr(String sharingRatioRedpStr) {
        this.sharingRatioRedpStr = sharingRatioRedpStr;
    }

    public String getSharingRatioGiveStr() {
        return sharingRatioGiveStr;
    }

    public void setSharingRatioGiveStr(String sharingRatioGiveStr) {
        this.sharingRatioGiveStr = sharingRatioGiveStr;
    }


    public String getMerchantIdStr() {
        return merchantIdStr;
    }

    public void setMerchantIdStr(String merchantIdStr) {
        this.merchantIdStr = merchantIdStr;
    }
}
