package com.weibar.service.function;

import com.weibar.pojo.db.UserBaseInfo;
import com.weibar.pojo.db.UserRechargeOrder;
import com.weibar.pojo.db.UserRechargeOrderCriteria;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.enu.PayChTypeEnum;
import com.weibar.pojo.enu.RechargeOrderStatusEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.UserBalance;
import com.weibar.service.mapper.UserRechargeOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/12/13.
 */
@Service
public class UserRechargeOrderService {

    @Autowired
    private UserRechargeOrderMapper userRechargeOrderMapper;

    @Autowired
    private UserBalanceService userBalanceService;

    public UserRechargeOrder createOrder(String orderId,UserBaseInfo userBaseInfo, PayChTypeEnum payChType,String clientIp,Integer amountFen){

        UserRechargeOrder userRechargeOrder = new UserRechargeOrder();
        Date now = new Date();
        userRechargeOrder.setOpenid(userBaseInfo.getOpenid());
        userRechargeOrder.setChmethod(payChType.getPayMethodType().getType());
        userRechargeOrder.setOrderId(orderId);
        userRechargeOrder.setChTpye(payChType.getType());
        userRechargeOrder.setCreateTime(now);
        userRechargeOrder.setUpdateTime(now);
        userRechargeOrder.setUserIp(clientIp);
        userRechargeOrder.setUserId(userBaseInfo.getUserId());
        userRechargeOrder.setStatus(RechargeOrderStatusEnum.UNPAY.getState());
        userRechargeOrder.setTotalFee(amountFen);
        userRechargeOrderMapper.insert(userRechargeOrder);
        return userRechargeOrder;
    }


    public UserRechargeOrder queryOrder(String orderId) throws BaseException {
        UserRechargeOrderCriteria userRechargeOrderCriteria = new UserRechargeOrderCriteria();
        UserRechargeOrderCriteria.Criteria criteria = userRechargeOrderCriteria.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<UserRechargeOrder> userRechargeOrderList =  userRechargeOrderMapper.selectByExample(userRechargeOrderCriteria);
        if(userRechargeOrderList == null || userRechargeOrderList.size() == 0){
            throw BaseException.getException(ErrorCodeEnum.RECHARGE_ERROR_ORDER_NOT_EXIST.getCode());
        }
        return userRechargeOrderList.get(0);
    }


    public UserRechargeOrder changeOrder(String orderId,RechargeOrderStatusEnum status,
                                         Integer amountFen,String bankType,
                                         String chOrderId,Date payCompDate,String chOriMsg,
                                         String chState,String chStateMsg) throws BaseException {
        UserRechargeOrder userRechargeOrder = queryOrder(orderId);

        //状态一致表示已经处理
        if(RechargeOrderStatusEnum.get(userRechargeOrder.getStatus()).equals(status)){
            return userRechargeOrder;
        }

        if(!userRechargeOrder.getTotalFee().equals(amountFen)){
            throw BaseException.getException(ErrorCodeEnum.RECHARGE_ERROR_ORDER_AMOUNT_NOT_SAME.getCode());
        }

        userRechargeOrder.setDescription(chOriMsg);
        userRechargeOrder.setStatus(status.getState());
        userRechargeOrder.setChStatus(chState);
        userRechargeOrder.setChStatusmsg(chStateMsg);

        switch (status){
            case REFUND:
                break;
            case PAYERR:
                break;
            case PAYING:
                break;
            case SUC:
                userRechargeOrder.setPayCompTime(payCompDate);
                userRechargeOrder.setChorderid(chOrderId);
                userRechargeOrder.setChBankTpye(bankType);
                BigDecimal payAmount = new BigDecimal(amountFen).divide(new BigDecimal(100),2, BigDecimal.ROUND_HALF_UP);
                userBalanceService.addUserBalance(userRechargeOrder.getUserId(),payAmount,"用户充值:渠道" + userRechargeOrder.getChTpye());
                break;
            case UNPAY:
                break;
        }

        userRechargeOrderMapper.updateByPrimaryKey(userRechargeOrder);
        return userRechargeOrder;
    }
}
