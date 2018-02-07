package com.weibar.pojo.result;

import com.weibar.pojo.db.UserWithdrawLog;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/20.
 */
public class WithdrawLog {


    public static WithdrawLog getWithdrawLog(UserWithdrawLog userWithdrawLog){
        WithdrawLog withdrawLog = new WithdrawLog();
        withdrawLog.setCreateTime(userWithdrawLog.getCreateTime());
        withdrawLog.setStatus(userWithdrawLog.getStatus());
        withdrawLog.setAmount(userWithdrawLog.getPoint());
        return withdrawLog;
    }

    private Date createTime;
    private Integer status;
    private BigDecimal amount;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
