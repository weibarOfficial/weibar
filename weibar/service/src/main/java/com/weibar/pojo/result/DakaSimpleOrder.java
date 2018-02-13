package com.weibar.pojo.result;

import com.weibar.pojo.db.DakaOrder;
import com.weibar.pojo.enu.DakaOrderStatusEnum;

import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2018/2/12.
 */
public class DakaSimpleOrder {

    private String date;
    private String result;
    private String money;


    public DakaSimpleOrder(){

    }

    public DakaSimpleOrder(DakaOrder dakaOrder){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.setDate(simpleDateFormat.format(dakaOrder.getOrderDate()));

        int status = dakaOrder.getStatus();
        if(status == DakaOrderStatusEnum.DAKA_SUC.getState() || status == DakaOrderStatusEnum.SEND.getState()){
            this.setResult("打卡成功");
            this.setMoney(dakaOrder.getGetAmount().setScale(2).toPlainString());
        }else{
            this.setResult("打卡失败");
            this.setMoney("-" + dakaOrder.getPayAmount().setScale(2).toPlainString());
        }

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
