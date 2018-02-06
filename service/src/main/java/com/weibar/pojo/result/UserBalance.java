package com.weibar.pojo.result;

import com.weibar.pojo.db.UserAccountBalance;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/11/2.
 */
public class UserBalance {

    private Long userId;
    private String openId;
    private BigDecimal balance;

    public static UserBalance getUserBalance(UserAccountBalance userAccountBalance){
        UserBalance userBalance = new UserBalance();
        userBalance.setBalance(userAccountBalance.getBalance());
        userBalance.setUserId(userAccountBalance.getUserId());
        userBalance.setOpenId(userAccountBalance.getOpenid());
        return userBalance;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


}
