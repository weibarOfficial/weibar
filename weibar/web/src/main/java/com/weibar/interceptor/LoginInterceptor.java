package com.weibar.interceptor;

import com.weibar.pojo.consts.WechatConsts;
import com.weibar.utils.CookieUtils;
import com.weibar.utils.LoginUserUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/12/7.
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String openId = CookieUtils.getCookieValue(httpServletRequest,WechatConsts.COOKIE_OPENID);
        //String nickName = CookieUtils.getCookieValue(httpServletRequest,WechatConsts.COOKIE_NICKNAME);
        String userId = CookieUtils.getCookieValue(httpServletRequest,WechatConsts.COOKIE_USERID);
        String sessionKey = CookieUtils.getCookieValue(httpServletRequest,WechatConsts.COOKIE_SESSION_KEY);
        LoginUserUtil.setLoginUserInfo(openId,userId,sessionKey);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
