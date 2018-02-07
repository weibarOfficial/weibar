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
        return info;
    }

    private Integer second;
    private String timeDesc;
    private BigDecimal price;


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
