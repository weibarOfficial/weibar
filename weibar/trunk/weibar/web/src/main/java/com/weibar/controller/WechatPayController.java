package com.weibar.controller;

import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.pojo.result.RechargeOrderInfo;
import com.weibar.pojo.result.WechatPrePay;
import com.weibar.service.function.PayAttachService;
import com.weibar.service.function.WechatPayService;
import com.weibar.utils.IpUtil;
import com.weibar.utils.LoginUserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/12/12.
 */
@RestController
@RequestMapping("/wechat/pay")
public class WechatPayController {

    @Autowired
    private WechatPayService wechatPayService;

    @Autowired
    private PayAttachService payAttachService;

    private static final Logger LOG = LoggerFactory.getLogger(WechatPayController.class);

    @RequestMapping(value = "/mp/createOrder" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object mpCreateOrder(@RequestParam Integer amountFen ,HttpServletRequest request, HttpServletResponse response) throws BaseException, IOException {
        WechatPrePay wechatPrePay = wechatPayService.createOrder(amountFen, IpUtil.getRequestIp(request), LoginUserUtil.getLoginUserInfo().getOpenId(),payAttachService.generatePurePayAttach());
        BaseResult baseResult =  BaseResult.getSuccessfulResult(wechatPrePay);
        LOG.info("mpCreateOrder return " + baseResult);
        return baseResult;
    }


    /**
     * 都依赖微信的通知，这样可以获取attach做后续处理
     * @param orderId
     * @param request
     * @param response
     * @return
     * @throws BaseException
     * @throws IOException
     */
    @Deprecated
    //@RequestMapping(value = "/mp/queryOrder" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object mpQueryOrder(@RequestParam String orderId ,HttpServletRequest request, HttpServletResponse response) throws BaseException, IOException {
        return BaseResult.getSuccessfulResult(RechargeOrderInfo.getRechargeOrderInfo(wechatPayService.queryOrder(null,orderId)));
    }

}
