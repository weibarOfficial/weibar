package com.weibar.service.function;

import com.weibar.pojo.db.UserConsumeOrder;
import com.weibar.pojo.enu.UserConsumeTypeEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.service.mapper.UserConsumeOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/22.
 */
@Service
public class UserConsumeOrderService {

    @Autowired
    private UserConsumeOrderMapper userConsumeOrderMapper;
    @Autowired
    private UserService userService;

    public UserConsumeOrder createUserConsumeOrder(Long merchantId,Long userId, Long beneficialUserId,
                                       BigDecimal consumeAmount,Date payTime,
                                       Long goodsId,String goodsName,Integer goodsNum,UserConsumeTypeEnum userConsumeTypeEnum,
                                       String userIp) throws BaseException {
        UserConsumeOrder userConsumeOrder = new UserConsumeOrder();
        Date now = new Date();
        userConsumeOrder.setUpdateTime(now);
        userConsumeOrder.setCreateTime(now);
        userConsumeOrder.setAmount(consumeAmount);
        userConsumeOrder.setPayTime(payTime);
        userConsumeOrder.setBalanceType(1);
        if(userId != null){
            userConsumeOrder.setUserId(userId);
            userConsumeOrder.setOpenid(userService.getUserById(userId).getOpenid());
        }
        if(beneficialUserId != null){
            userConsumeOrder.setBeneficialUserId(beneficialUserId);
            userConsumeOrder.setBeneficialOpenid(userService.getUserById(beneficialUserId).getOpenid());
        }

        userConsumeOrder.setGoodsId(goodsId);
        userConsumeOrder.setGoodsName(goodsName);
        userConsumeOrder.setGoodsNum(goodsNum);
        userConsumeOrder.setPayType(userConsumeTypeEnum.getType());
        userConsumeOrder.setUserIp(userIp);
        userConsumeOrder.setMerchantid(merchantId);
        userConsumeOrderMapper.insert(userConsumeOrder);
        return userConsumeOrder;
    }
}
