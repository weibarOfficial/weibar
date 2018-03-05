package com.weibar.controller;

import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.service.function.DakaService;
import com.weibar.service.function.WechatMiniProgramService;
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


    @RequestMapping(value = "/daka/pay" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object pay(@RequestParam String sessionKey,@RequestParam String amount,HttpServletRequest request) throws BaseException {
        return BaseResult.getSuccessfulResult(dakaService.createDakaOrder(sessionKey,new BigDecimal(amount), IpUtil.getRequestIp(request)));
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
        dakaService.refreshAndSendDakaMoney(timeDate);
        return BaseResult.getSuccessfulResult(null);
    }

}
