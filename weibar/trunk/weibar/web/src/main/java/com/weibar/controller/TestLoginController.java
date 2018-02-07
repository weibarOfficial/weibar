package com.weibar.controller;

import com.weibar.pojo.consts.WechatConsts;
import com.weibar.pojo.db.UserBaseInfo;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.pojo.result.UserInfo;
import com.weibar.service.function.UserService;
import com.weibar.utils.CookieUtils;
import com.weibar.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/12/6.
 */
//暂时关闭
@RestController
public class TestLoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test/loginByOpenId" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object loginByOpenId(HttpServletRequest request, HttpServletResponse response,@RequestParam String openId)throws BaseException {
        UserBaseInfo userBaseInfo = userService.getUserByOpenId(openId);
        writeCookies(userBaseInfo,request,response);
        return BaseResult.getSuccessfulResult(null);
    }

    @RequestMapping(value = "/test/loginByUserId" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object loginByUserId(HttpServletRequest request, HttpServletResponse response,@RequestParam Long userId)throws BaseException {
        UserBaseInfo userBaseInfo = userService.getUserById(userId);
        writeCookies(userBaseInfo,request,response);
        return BaseResult.getSuccessfulResult(null);
    }


    private void writeCookies(UserBaseInfo userBaseInfo,HttpServletRequest request, HttpServletResponse response){
        LoginUserUtil.SessionUserInfo sessionUserInfo = LoginUserUtil.getSessionUserInfo(
                userBaseInfo.getOpenid(),userBaseInfo.getUserId());
        //写入cookie 跳转到主页
        CookieUtils.addCookie(request,response, WechatConsts.COOKIE_OPENID, sessionUserInfo.getOpenId());
        CookieUtils.addCookie(request,response,WechatConsts.COOKIE_USERID,sessionUserInfo.getUserId().toString());
        CookieUtils.addCookie(request,response,WechatConsts.COOKIE_SESSION_KEY,sessionUserInfo.getSessionKey());
    }
}
