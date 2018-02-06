package com.weibar.service.function;

import com.weibar.pojo.db.UserAccountBalance;
import com.weibar.pojo.db.UserAccountBalanceCriteria;
import com.weibar.pojo.db.UserBaseInfo;
import com.weibar.pojo.db.UserTransaction;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.enu.TransctionTypeEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.service.mapper.UserAccountBalanceMapper;
import com.weibar.service.mapper.UserTransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 * 用户加减余额需要调用这里的方法，不能直接操作数据库
 */
@Service
public class UserBalanceService {

    @Autowired
    private UserAccountBalanceMapper userAccountBalanceMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserTransactionMapper userTransactionMapper;


    /**
     * 消费时候使用，向上取整
     * @param amount
     * @return
     */
    public BigDecimal checkAndChangeAmountForPay(String amount){
        //TODO 判断金额是否合法
        BigDecimal bg = new BigDecimal(amount).setScale(2, RoundingMode.UP);
        return bg;
    }

    /**
     * 提现时候使用 向下取整
     * @param amount
     * @return
     */
    public BigDecimal checkAndChangeAmountForWithdraw(String amount) throws BaseException {
        //TODO 判断金额是否合法
        BigDecimal bg = new BigDecimal(amount).setScale(2, RoundingMode.DOWN);
        if(bg.compareTo(new BigDecimal(200)) > 0 || bg.compareTo(new BigDecimal(1)) < 0){
            throw BaseException.getException(ErrorCodeEnum.WITHDRAW_ERROR_AMOUNT.getCode());
        }
        return bg;
    }


    /**
     * 增加余额
     * @param userId
     * @param amount
     * @param remark
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public void addUserBalance(Long userId,BigDecimal amount,String remark) throws BaseException {

        UserBaseInfo userBaseInfo = userService.getUserById(userId);
        UserAccountBalance userAccountBalance = getBalanceAccountByUserId(userId);


        UserTransaction userTransaction = new UserTransaction();
        Date now = new Date();
        userTransaction.setUpdateTime(now);
        userTransaction.setAmount(amount);
        userTransaction.setCreateTime(now);
        userTransaction.setBalance(userAccountBalance.getBalance());
        userTransaction.setOpenid(userBaseInfo.getOpenid());
        userTransaction.setRemark(remark);
        userTransaction.setTransactionType(TransctionTypeEnum.IN.getType());
        userTransaction.setStatus(0);
        userTransaction.setUserId(userId.toString());
        userTransactionMapper.insert(userTransaction);

        BigDecimal oldAmount = userAccountBalance.getBalance();
        BigDecimal newAmount = userAccountBalance.getBalance().add(amount);
        userAccountBalance.setBalance(newAmount);
        userAccountBalance.setUpdateTime(new Date());
        UserAccountBalanceCriteria balanceCriteria = new UserAccountBalanceCriteria();
        UserAccountBalanceCriteria.Criteria criteria = balanceCriteria.createCriteria();
        criteria.andBalanceEqualTo(oldAmount);
        criteria.andUserIdEqualTo(userId);
        int count = userAccountBalanceMapper.updateByExample(userAccountBalance,balanceCriteria);

        if(count != 1){
            throw BaseException.getException(ErrorCodeEnum.USER_USER_BALANCE_UPDATE_FAIL.getCode());
        }
    }


    /**
     * 扣除用户余额
     * @param userId
     * @param amount
     * @param remark
     * @throws BaseException
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public void subtractUserBalance(Long userId,BigDecimal amount,String remark) throws BaseException {

        UserBaseInfo userBaseInfo = userService.getUserById(userId);
        UserAccountBalance userAccountBalance = getBalanceAccountByUserId(userId);

        if(userAccountBalance.getBalance().compareTo(amount) < 0){
            throw BaseException.getException(ErrorCodeEnum.USER_USER_BALANCE_NOT_ENOUGH.getCode());
        }


        UserTransaction userTransaction = new UserTransaction();
        Date now = new Date();
        userTransaction.setUpdateTime(now);
        userTransaction.setAmount(amount);
        userTransaction.setCreateTime(now);
        userTransaction.setBalance(userAccountBalance.getBalance());
        userTransaction.setOpenid(userBaseInfo.getOpenid());
        userTransaction.setRemark(remark);
        userTransaction.setTransactionType(TransctionTypeEnum.OUT.getType());
        userTransaction.setStatus(0);
        userTransaction.setUserId(userId.toString());
        userTransactionMapper.insert(userTransaction);

        BigDecimal oldAmount = userAccountBalance.getBalance();
        BigDecimal newAmount = userAccountBalance.getBalance().subtract(amount);
        userAccountBalance.setBalance(newAmount);
        userAccountBalance.setUpdateTime(new Date());
        UserAccountBalanceCriteria balanceCriteria = new UserAccountBalanceCriteria();
        UserAccountBalanceCriteria.Criteria criteria = balanceCriteria.createCriteria();
        criteria.andBalanceEqualTo(oldAmount);
        criteria.andUserIdEqualTo(userId);
        int count = userAccountBalanceMapper.updateByExample(userAccountBalance,balanceCriteria);

        if(count != 1){
            throw BaseException.getException(ErrorCodeEnum.USER_USER_BALANCE_UPDATE_FAIL.getCode());
        }
    }


    /**
     * 获取用户余额
     * @param openId
     * @return
     * @throws BaseException
     */
    public UserAccountBalance getUserBalanceByOpenId(String openId)throws BaseException {

        UserBaseInfo userBaseInfo = userService.getUserByOpenId(openId);

        UserAccountBalanceCriteria balanceCriteria = new UserAccountBalanceCriteria();
        UserAccountBalanceCriteria.Criteria criteria = balanceCriteria.createCriteria();
        criteria.andOpenidEqualTo(openId);
        List<UserAccountBalance> balanceList =  userAccountBalanceMapper.selectByExample(balanceCriteria);

        if(balanceList != null && balanceList.size() != 0){
            return balanceList.get(0);
        }else{
            UserAccountBalance userAccountBalance = new UserAccountBalance();
            userAccountBalance.setBalance(new BigDecimal(0));
            Date now = new Date();
            userAccountBalance.setCreateTime(now);
            userAccountBalance.setUpdateTime(now);
            userAccountBalance.setOpenid(userBaseInfo.getOpenid());
            userAccountBalance.setUserId(userBaseInfo.getUserId());

            //科目暂时只存1
            userAccountBalance.setSubject("1");
            userAccountBalanceMapper.insert(userAccountBalance);
            return userAccountBalance;
        }
    }



    public UserAccountBalance getBalanceAccountByUserId(Long userId)throws BaseException {
        UserBaseInfo userBaseInfo = userService.getUserById(userId);
        return getUserBalanceByOpenId(userBaseInfo.getOpenid());
    }

    public BigDecimal getLeastNeedRechargeAmount(Long userId,String amount) throws BaseException {

        UserAccountBalance userAccountBalance = getBalanceAccountByUserId(userId);
        //需要支付的金额
        BigDecimal needPay = new BigDecimal(amount).setScale(2, RoundingMode.UP);
        BigDecimal needRecharge = needPay.subtract(userAccountBalance.getBalance());
        needRecharge.setScale(2, RoundingMode.UP);
        return needRecharge;

    }


}
