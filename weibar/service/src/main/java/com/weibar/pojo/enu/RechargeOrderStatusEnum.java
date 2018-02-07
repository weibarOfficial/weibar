package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2017/12/13.
 */
public enum  RechargeOrderStatusEnum {

    UNPAY(1,"未付款"),SUC(2,"付款成功"),PAYING(3,"支付中"),PAYERR(4,"支付失败"),REFUND(5,"已退款");


    public static RechargeOrderStatusEnum get(int state){
        for(RechargeOrderStatusEnum statusEnum : RechargeOrderStatusEnum.values()){
            if(statusEnum.getState() == state){
                return statusEnum;
            }
        }
        return null;
    }

    RechargeOrderStatusEnum(int state, String desc) {
        this.state = state;
        this.desc = desc;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private int state;
    private String desc;
}
