package com.weibar.controller;

import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.service.function.DakaRefreshService;
import com.weibar.service.function.DakaFreeService;
import com.weibar.service.function.DakaService;
import com.weibar.service.function.DakaUserRankService;
import com.weibar.utils.IpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/31.
 */
@RestController
public class DakaController {

    private static final Logger LOG = LoggerFactory.getLogger(DakaController.class);


    @Autowired
    private DakaService dakaService;
    @Autowired
    private DakaFreeService dakaFreeService;

    @Autowired
    private DakaUserRankService dakaUserRankService;

    @Autowired
    private DakaRefreshService dakaRefreshService;




    @RequestMapping(value = "/daka/pay" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object pay(@RequestParam String sessionKey,@RequestParam String amount,HttpServletRequest request) throws BaseException {

        //暂时屏蔽掉支付一元接口
        BigDecimal amountB = new BigDecimal(amount);
        //写死一元
        amountB = new BigDecimal(1);
        return BaseResult.getSuccessfulResult(dakaService.createDakaOrder(sessionKey,amountB, IpUtil.getRequestIp(request)));
        //使用免费打卡接口并抛异常
//        dakaFreeService.createDakaForFree(sessionKey, IpUtil.getRequestIp(request));
//        throw BaseException.getException(ErrorCodeEnum.DAKA_RULE_CHANGE.getCode());
    }

    @RequestMapping(value = "/daka/payForFree" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object payForFree(@RequestParam String sessionKey,HttpServletRequest request) throws BaseException {
        dakaFreeService.createDakaForFree(sessionKey, IpUtil.getRequestIp(request));
        return BaseResult.getSuccessfulResult(null);
    }


    @RequestMapping(value = "/daka/daka" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object daka(@RequestParam String sessionKey,HttpServletRequest request) throws BaseException {
        dakaService.daka(sessionKey,IpUtil.getRequestIp(request));
        return BaseResult.getSuccessfulResult(null);
    }


    @RequestMapping(value = "/daka/getIndexSummary" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getIndexSummary() throws BaseException {
        return BaseResult.getSuccessfulResult(dakaService.getDakaIndexSummary());
    }

    @RequestMapping(value = "/daka/getUserInfo" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getDakaUser(@RequestParam String sessionKey) throws BaseException {
        return BaseResult.getSuccessfulResult(dakaService.getDakaUserBySessionKey(sessionKey));
    }


    @RequestMapping(value = "/daka/getDakaMyInfo" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getDakaMyInfo(@RequestParam String sessionKey) throws BaseException {
        return BaseResult.getSuccessfulResult(dakaService.getDakaMyInfo(sessionKey));
    }


    @RequestMapping(value = "/daka/login" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object dakaLogin(@RequestParam String code,
                            @RequestParam String nickName,
                            @RequestParam String gender,
                            @RequestParam String avatarUrl,
                            @RequestParam(required = false) String province,
                            @RequestParam(required = false) String ctiy,
                            @RequestParam(required = false) String country) throws BaseException {
        return BaseResult.getSuccessfulResult(dakaService.dakaLogin(code,nickName,avatarUrl,gender,province,ctiy,country));
    }

    @RequestMapping(value = "/daka/getDakaQRCode" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getDakaQrCodeUrl() throws BaseException {
        return BaseResult.getSuccessfulResult(dakaService.getQRCodeURL());
    }



    @RequestMapping(value = "/daka/dakaFinishSepcificDateJob" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object dakaFinishSepcificDateJob(@RequestParam Long time) throws BaseException {
        Date timeDate = new Date(time);
        dakaRefreshService.refreshAndSendDakaMoney(timeDate);
        return BaseResult.getSuccessfulResult(null);
    }

    @RequestMapping(value = "/daka/dakaRefreshRank" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object dakaRefreshRankJob() throws BaseException {
        dakaUserRankService.refreshRanks();
        return BaseResult.getSuccessfulResult(null);
    }

    @RequestMapping(value = "/daka/getRanks" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getRanks() throws BaseException {
        return BaseResult.getSuccessfulResult(dakaUserRankService.getUserRanks());
    }

    @RequestMapping(value = "/daka/generateAdminPay" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object generateAdminPay() throws BaseException {
        dakaFreeService.generateAdminPay();
        return BaseResult.getSuccessfulResult(null);
    }

}
