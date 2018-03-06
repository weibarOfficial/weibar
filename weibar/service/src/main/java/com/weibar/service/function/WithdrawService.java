package com.weibar.service.function;

import com.weibar.pojo.consts.UserBalanceTranRemark;
import com.weibar.pojo.db.UserBaseInfo;
import com.weibar.pojo.db.UserWithdrawLog;
import com.weibar.pojo.db.UserWithdrawLogCriteria;
import com.weibar.pojo.enu.RedPackageSceneIdEnum;
import com.weibar.pojo.enu.WithdrawStatusEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.WithdrawLog;
import com.weibar.service.mapper.UserWithdrawLogMapper;
import com.weibar.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nixiaoming on 2017/11/19.
 */
@Service
public class WithdrawService {

    @Autowired
    private UserWithdrawLogMapper userWithdrawLogMapper;
    @Autowired
    private UserBalanceService userBalanceService;
    @Autowired
    private WechatRedPackageService redPackageOrderService;
    @Autowired
    private UserService userService;


    /**
     * 用户发起提现
     * @param userId
     * @param amount
     * @throws BaseException
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public void withdraw(Long userId,String amount,String clientIp) throws BaseException {
        BigDecimal withdrawAmount = userBalanceService.checkAndChangeAmountForWithdraw(amount);
        //扣除用户余额
        userBalanceService.subtractUserBalance(userId,withdrawAmount, UserBalanceTranRemark.OUT_USER_WITHDRAW);
        Long withdrawId = IdGenerator.generateIdByTime();
        UserBaseInfo userBaseInfo = userService.getUserById(userId);
        Date now = new Date();
        UserWithdrawLog userWithdrawLog = new UserWithdrawLog();
        userWithdrawLog.setUserId(userId);
        userWithdrawLog.setUpdateTime(now);
        userWithdrawLog.setCreateTime(now);
        userWithdrawLog.setId(withdrawId);
        userWithdrawLog.setOpenId(userBaseInfo.getOpenid());
        userWithdrawLog.setPoint(withdrawAmount);
        userWithdrawLog.setStatus(WithdrawStatusEnum.USER_POST.getState());

        //科目暂时只存1
        userWithdrawLog.setSubject("1");
        userWithdrawLogMapper.insert(userWithdrawLog);

        //给用户发放红包
        //发放红包 插入红包表 再起异步线程去跑
        redPackageOrderService.createRedPackageOrder(withdrawAmount,
                withdrawId.toString(),
                userBaseInfo.getOpenid(),
                userId,
                clientIp,
                RedPackageSceneIdEnum.WEIBAR_USER_WITHDRAW.getState().toString(),
                RedPackageSceneIdEnum.WEIBAR_USER_WITHDRAW.getDesc(),
                null);

    }


    public List<WithdrawLog> getUserWithdrawLogs(Long userId){
        UserWithdrawLogCriteria userWithdrawLogCriteria = new UserWithdrawLogCriteria();
        UserWithdrawLogCriteria.Criteria criteria = userWithdrawLogCriteria.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<UserWithdrawLog> logs = userWithdrawLogMapper.selectByExample(userWithdrawLogCriteria);

        List<WithdrawLog> withdrawLogs = new ArrayList<>();
        for(UserWithdrawLog userWithdrawLog : logs){
            withdrawLogs.add(WithdrawLog.getWithdrawLog(userWithdrawLog));
        }
        return withdrawLogs;
    }


    public UserWithdrawLog getUserWithdrawLog(Long withdrawId){
        UserWithdrawLog userWithdrawLog = userWithdrawLogMapper.selectByPrimaryKey(withdrawId);
        return userWithdrawLog;
    }


    public void updateWithdrawSuccess(Long withdrawId){
        UserWithdrawLog withdrawLog = getUserWithdrawLog(withdrawId);
        withdrawLog.setStatus(WithdrawStatusEnum.SUCCESS.getState());
        userWithdrawLogMapper.updateByPrimaryKey(withdrawLog);
    }
}
