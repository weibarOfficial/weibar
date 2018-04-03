package com.weibar.interceptor;

import com.weibar.consts.SessionConsts;
import com.weibar.pojo.result.MerchantInfo;
import com.yy.genesis.constant.GenesisConstant;
import com.yy.genesis.model.AppUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/2/16.
 */
public class LoginInterceptor implements HandlerInterceptor {
    private static final String LOGIN_URL = "/login.html";

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {

        /**
         * 注册相关的页面不需要校验登录态
         */
        if(req.getRequestURI().startsWith("/platform/register")){
            return true;
        }


        MerchantInfo merchantInfo = (MerchantInfo) req.getSession().getAttribute(SessionConsts.USER_LOGIN_INFO_SESSION);
        // 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆
        if (merchantInfo == null || "".equals(merchantInfo.getMerchantId())) {
            res.sendRedirect(LOGIN_URL);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object arg2, ModelAndView arg3) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3) throws Exception {

    }
}
