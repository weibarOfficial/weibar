package com.weibar.controller;

import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/12/12.
 */
@RestController
@RequestMapping("/wechat/user")
public class WeixinUserController {

    @Autowired
    private WxMpService wxMpService;

    @RequestMapping(value = "/list" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object list( HttpServletRequest request, HttpServletResponse response) throws BaseException, IOException, WxErrorException {
        return BaseResult.getSuccessfulResult(wxMpService.getUserService().userList(null));
    }


    @RequestMapping(value = "/userInfo" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object userInfo( HttpServletRequest request, HttpServletResponse response,@RequestParam String openId) throws BaseException, IOException, WxErrorException {
        return BaseResult.getSuccessfulResult(wxMpService.getUserService().userInfo(openId));
    }
}
