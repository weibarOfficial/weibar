package com.weibar.pojo.result;

import com.weibar.pojo.db.WeibarMerchantsPriceTimeSettingInfo;
import com.weibar.pojo.db.WeibarPriceTimeSettingInfo;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/11/21.
 * 霸屏时长类
 */
public class PriceTimeSettingInfo {


    public static PriceTimeSettingInfo getPriceTimeSettingInfo(WeibarMerchantsPriceTimeSettingInfo weibarPriceTimeSettingInfo){
        PriceTimeSettingInfo info = new PriceTimeSettingInfo();
        info.setSecond(weibarPriceTimeSettingInfo.getTimesid());
        info.setPrice(weibarPriceTimeSettingInfo.getAmount());
        info.setTimeDesc(weibarPriceTimeSettingInfo.getTimesdesc());
        info.setTimeId(weibarPriceTimeSettingInfo.getTimesid());
        info.setTimeIdStr(weibarPriceTimeSettingInfo.getTimesid().toString());
        info.setPriceStr(weibarPriceTimeSettingInfo.getAmount().toPlainString());
        return info;
    }


    private Integer timeId;
    private Integer second;
    private String timeDesc;
    private BigDecimal price;
    private String priceStr;
    private String timeIdStr;


    public String getPriceStr() {
        return priceStr;
    }

    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
    }

    public String getTimeIdStr() {
        return timeIdStr;
    }

    public void setTimeIdStr(String timeIdStr) {
        this.timeIdStr = timeIdStr;
    }

    public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public String getTimeDesc() {
        return timeDesc;
    }

    public void setTimeDesc(String timeDesc) {
        this.timeDesc = timeDesc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
