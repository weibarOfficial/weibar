package com.weibar.service.function;

import com.weibar.pojo.db.DakaDaySummary;
import com.weibar.pojo.db.DakaOrder;
import com.weibar.pojo.db.UserBaseInfo;
import com.weibar.pojo.enu.DakaOrderStatusEnum;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.service.mapper.DakaDaySummaryMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/12.
 */
@Service
public class DakaFreeService {

    private static final Logger LOG = LoggerFactory.getLogger(DakaService.class);

    @Autowired
    private UserService userService;

    //用于免费打卡发放的奖励金的账号
    private static Long ADMIN_USER_ID  = 1519721304464L;
    //用于免费打卡发放的奖励金金额
    private static BigDecimal DAKA_FREE_GET_MONEY = new BigDecimal(10);


    @Autowired
    private DakaDaySummaryMapper dakaDaySummaryMapper;

    @Autowired
    private DakaService dakaService;


    public void createDakaForFree(String sessionKey,String clientIp) throws BaseException {

        UserBaseInfo userBaseInfo = dakaService.getUserInfoBySessionKey(sessionKey);


        LOG.info("createDakaOrder free userId " + userBaseInfo.getUserId() +
                " openId " + userBaseInfo.getOpenid() +
                " nickName " + userBaseInfo.getNickname() + " clientIp " + clientIp);

        createDakaHasPayed(userBaseInfo.getUserId(),clientIp,new BigDecimal(0));
    }





    public void generateAdminPay(){

        try {
            LOG.info("generateAdminPay begin");
            createDakaHasPayed(ADMIN_USER_ID,"127.0.0.1",DAKA_FREE_GET_MONEY);
            LOG.info("generateAdminPay finish successfully");
        } catch (BaseException e) {
            LOG.error("generateAdminPay error" ,e);
        }

    }


    private void createDakaHasPayed(Long userId,String clientIp,BigDecimal amount) throws BaseException {

        UserBaseInfo userBaseInfo = userService.getUserById(userId);

        Date now = new Date();

        LOG.info("createDakaOrder payed userId " + userBaseInfo.getUserId() +
                " openId " + userBaseInfo.getOpenid() +
                " nickName " + userBaseInfo.getNickname() + " clientIp " + clientIp);

        dakaService.checkAndInsertDakaOrder(amount,userBaseInfo,DakaOrderStatusEnum.PAYED.getState());


        //更新打卡用户表数据
        dakaService.updateDakaUserData(userBaseInfo.getUserId());

        //更新统计表
        DakaDaySummary dakaDaySummary = dakaService.getTomorrowDakaDaySummary(now);
        dakaDaySummary.setUpdateTime(now);
        dakaDaySummary.setCount(dakaDaySummary.getCount() + 1);
        dakaDaySummary.setPayAmount(dakaDaySummary.getPayAmount().add(amount));
        dakaDaySummaryMapper.updateByPrimaryKey(dakaDaySummary);

    }


}
