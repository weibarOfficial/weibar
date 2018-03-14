package com.weibar.service;

import com.weibar.pojo.db.DakaDaySummary;
import com.weibar.pojo.db.DakaOrder;
import com.weibar.pojo.db.DakaUser;
import com.weibar.pojo.enu.DakaOrderStatusEnum;
import com.weibar.pojo.enu.RedPackageSceneIdEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.service.function.*;
import com.weibar.service.mapper.DakaDaySummaryMapper;
import com.weibar.service.mapper.DakaOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * Created by Administrator on 2018/3/13.
 */
@Service
public class DakaRefreshService {


    @Autowired
    private DakaService dakaService;
    @Autowired
    private DakaFreeService dakaFreeService;
    @Autowired
    private DakaUserRankService dakaUserRankService;

    @Autowired
    private WechatRedPackageService wechatRedPackageService;

    @Autowired
    private DiscountService discountService;

    @Autowired
    private DakaOrderMapper dakaOrderMapper;

    @Autowired
    private RedPackageService redPackageService;

    @Autowired
    private UserService userService;

    @Autowired
    private DakaDaySummaryMapper dakaDaySummaryMapper;

    private static final Logger LOG = LoggerFactory.getLogger(DakaRefreshService.class);

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public void refreshAndSendDakaMoney(Date date) throws BaseException {

        DakaDaySummary dakaDaySummary = dakaService.getDakaDaySummary(date);
        // 计算失败人数
        dakaDaySummary.setFcount(dakaDaySummary.getCount() - dakaDaySummary.getScount());

        List<Integer> sucStatus = new ArrayList<>();
        List<Integer> failStatus = new ArrayList<>();
        sucStatus.add(DakaOrderStatusEnum.DAKA_SUC.getState());
        sucStatus.add(DakaOrderStatusEnum.SEND.getState());
        failStatus.add(DakaOrderStatusEnum.PAYED.getState());
        failStatus.add(DakaOrderStatusEnum.DAKA_FAIL.getState());

        List<DakaOrder> succOrds = dakaService.getDakaOrders(date,sucStatus);
        List<DakaOrder> failOrds = dakaService.getDakaOrders(date,failStatus);

        if(succOrds.size() != dakaDaySummary.getScount() || failOrds.size() != dakaDaySummary.getFcount()){
            //BaseException baseException = BaseException.getException(ErrorCodeEnum.DAKA_ORDER_TABLE_SUM_TABLE_ERROR.getCode());
            //throw baseException;

            //不一致以订单表为准
            dakaDaySummary.setScount(succOrds.size());
            dakaDaySummary.setFcount(failOrds.size());
            dakaDaySummary.setCount(succOrds.size() + failOrds.size());
        }

        BigDecimal failMoney = new BigDecimal(0);
        for(DakaOrder dakaOrder : failOrds){
            failMoney = failMoney.add(dakaOrder.getPayAmount());
            dakaService.updateDakaUserData(dakaOrder.getUserId());
            if(dakaOrder.getStatus() == DakaOrderStatusEnum.DAKA_FAIL.getState()){
                continue;
            }
            dakaOrder.setStatus(DakaOrderStatusEnum.DAKA_FAIL.getState());
            dakaOrder.setUpdateTime(new Date());
            dakaOrderMapper.updateByPrimaryKey(dakaOrder);
        }

        BigDecimal sendMoneySum = discountService.getDakaDiscount(failMoney,succOrds.size());

        List<BigDecimal> succGetMoneyList = redPackageService.getRedPackageAmountList(sendMoneySum,succOrds.size(),true);



        // 最佳 和 最有毅力
        DakaOrder luckyUser = null;
        DakaUser gutUser = null;


        for(int i = 0; i < succGetMoneyList.size() ; i++){


            //更新订单表
            Date now = new Date();
            DakaOrder dakaOrder = succOrds.get(i);

            if(dakaOrder.getStatus() == DakaOrderStatusEnum.SEND.getState()){
                continue;
            }

            dakaOrder.setGetAmount(dakaOrder.getPayAmount().add(succGetMoneyList.get(i)));
            dakaOrder.setUpdateTime(now);
            dakaOrder.setStatus(DakaOrderStatusEnum.SEND.getState());
            dakaOrderMapper.updateByPrimaryKey(dakaOrder);


            //更新用户收入表
            DakaUser dakaUser = dakaService.updateDakaUserData(dakaOrder.getUserId());

            // 更新最佳和最有毅力
            if(luckyUser == null){
                luckyUser = dakaOrder;
            }else if(dakaOrder.getGetAmount().compareTo(luckyUser.getGetAmount()) > 0){
                luckyUser = dakaOrder;
            }

            if(gutUser == null){
                gutUser = dakaUser;
            }else if(gutUser.getScount() < dakaUser.getScount()){
                gutUser = dakaUser;
            }

            try{
                wechatRedPackageService.createRedPackageOrder(dakaOrder.getGetAmount(),
                        dakaOrder.getOrderid().toString(),
                        dakaOrder.getOpenid(),
                        dakaOrder.getUserId(),
                        dakaOrder.getClientIp(),
                        RedPackageSceneIdEnum.DAKA.getState().toString(),
                        RedPackageSceneIdEnum.DAKA.getDesc(),
                        "发放打卡成功奖励金");
            }catch (BaseException e){
                LOG.error("createRedPackageOrder error",e);
            }


        }

        //更新统计表
        dakaDaySummary.setUpdateTime(new Date());
        if(luckyUser != null) {
            dakaDaySummary.setLuckyAmount(luckyUser.getGetAmount());
            dakaDaySummary.setLuckyOpenId(luckyUser.getOpenid());
            dakaDaySummary.setLuckyUserId(luckyUser.getUserId());
            DakaUser dakaUserLucky = dakaService.getDakaUser(luckyUser.getUserId());
            dakaDaySummary.setLuckyUserPicture(dakaUserLucky.getUserPicture());
            dakaDaySummary.setLuckyUserName(dakaUserLucky.getNickname());
        }
        if(gutUser != null) {
            dakaDaySummary.setGutsCount(gutUser.getScount());
            dakaDaySummary.setGutsOpenId(gutUser.getOpenid());
            dakaDaySummary.setGutsUserId(gutUser.getUserId());
            dakaDaySummary.setGutsUserPicture(gutUser.getUserPicture());
            dakaDaySummary.setGutsUserName(userService.getUserById(gutUser.getUserId()).getNickname());
        }

        dakaDaySummaryMapper.updateByPrimaryKey(dakaDaySummary);

        dakaUserRankService.refreshRanks();

        dakaFreeService.generateAdminPay();

    }
}
