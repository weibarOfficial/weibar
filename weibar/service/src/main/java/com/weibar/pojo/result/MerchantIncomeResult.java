package com.weibar.pojo.result;

import com.weibar.pojo.db.MerchantIncome;
import com.weibar.pojo.db.WeibarMerchantsBaseInfo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantIncomeResult {

    private String income;

    private String totalIncome;

    private String totalPeople;

    private String people;

    private String perConsume;

    private String createTime;



    public static MerchantIncomeResult getMerchantIncome(MerchantIncome merchantIncome){
        MerchantIncomeResult merchantIncomeResult = new MerchantIncomeResult();
        merchantIncomeResult.setIncome(merchantIncome.getIncome().setScale(2).toPlainString());
        merchantIncomeResult.setPeople(merchantIncome.getPeople().toString());
        merchantIncomeResult.setTotalIncome(merchantIncome.getTotalIncome().setScale(2).toPlainString());
        merchantIncomeResult.setTotalPeople(merchantIncome.getTotalPeople().toString());
        merchantIncomeResult.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(merchantIncome.getCreateTime()));
        if(merchantIncome.getPeople() == 0){
            merchantIncomeResult.setPerConsume("0");
        }else{
            merchantIncomeResult.setPerConsume(merchantIncome.getIncome().divide(new BigDecimal(merchantIncome.getPeople())).setScale(2).toPlainString());
        }
        return merchantIncomeResult;
    }


    public static List<MerchantIncomeResult> getMerchantIncomes(List<MerchantIncome> merchantIncomes){
        List<MerchantIncomeResult> list = new ArrayList<>();
        for(MerchantIncome merchantIncome : merchantIncomes){
            list.add(getMerchantIncome(merchantIncome));
        }
        return list;
    }


    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(String totalIncome) {
        this.totalIncome = totalIncome;
    }

    public String getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(String totalPeople) {
        this.totalPeople = totalPeople;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getPerConsume() {
        return perConsume;
    }

    public void setPerConsume(String perConsume) {
        this.perConsume = perConsume;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MerchantIncomeResult{" +
                "income=" + income +
                ", totalIncome=" + totalIncome +
                ", totalPeople=" + totalPeople +
                ", people=" + people +
                ", perConsume=" + perConsume +
                ", createTime=" + createTime +
                '}';
    }
}
