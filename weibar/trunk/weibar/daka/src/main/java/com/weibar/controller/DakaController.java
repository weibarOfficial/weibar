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

/**
 * Created by Administrator on 2018/1/31.
 */
@RestController
public class DakaController {

    private static final Logger LOG = LoggerFactory.getLogger(DakaController.class);


    @Autowired
    private DakaService dakaService;


    @RequestMapping(value = "/daka/daka" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object daka(@RequestParam String sessionKey,@RequestParam String amount,HttpServletRequest request) throws BaseException {
        return BaseResult.getSuccessfulResult(dakaService.createDakaOrder(sessionKey,new BigDecimal(amount), IpUtil.getRequestIp(request)));
    }


    @RequestMapping(value = "/daka/getIndexSummary" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getIndexSummary() throws BaseException {
        return BaseResult.getSuccessfulResult(dakaService.getDakaIndexSummary());
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

}
