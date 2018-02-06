package com.weibar.controller;

import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.service.function.WechatPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/12/14.
 */
@RestController
@RequestMapping("/ch/notify")
public class ChannelNotifyController {

    private static final Logger LOG = LoggerFactory.getLogger(ChannelNotifyController.class);

    @Autowired
    private WechatPayService wechatPayService;

    @RequestMapping(value = "/wechatMp" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object notify(@RequestBody String xmlData , HttpServletRequest request, HttpServletResponse response) throws BaseException, IOException {
        LOG.info("wechatMp notify " + xmlData);
        String xmlRes = wechatPayService.handlePayResultNotify(xmlData);
        return xmlRes;
    }
}
