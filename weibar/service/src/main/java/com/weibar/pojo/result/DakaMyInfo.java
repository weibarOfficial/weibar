package com.weibar.pojo.result;

import java.util.List;

/**
 * Created by Administrator on 2018/2/12.
 */
public class DakaMyInfo {


    private String allPay;
    private String allGet;
    private String allSucDaka;
    private List<DakaSimpleOrder> dakaDetails;

    public String getAllPay() {
        return allPay;
    }

    public void setAllPay(String allPay) {
        this.allPay = allPay;
    }

    public String getAllGet() {
        return allGet;
    }

    public void setAllGet(String allGet) {
        this.allGet = allGet;
    }

    public String getAllSucDaka() {
        return allSucDaka;
    }

    public void setAllSucDaka(String allSucDaka) {
        this.allSucDaka = allSucDaka;
    }

    public List<DakaSimpleOrder> getDakaDetails() {
        return dakaDetails;
    }

    public void setDakaDetails(List<DakaSimpleOrder> dakaDetails) {
        this.dakaDetails = dakaDetails;
    }
}
