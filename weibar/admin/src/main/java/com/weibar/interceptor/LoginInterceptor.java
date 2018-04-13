package com.weibar.interceptor;

import com.weibar.consts.PageNameConsts;
import com.weibar.consts.SessionConsts;
import com.weibar.controller.LoginController;
import com.weibar.pojo.enu.MerchantRoleEnum;
import com.weibar.pojo.result.MerchantInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/2/16.
 */
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);





    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {

        LOG.info("LoginInterceptor " + req.getRequestURI());
        /**
         * 注册登录相关的页面不需要校验登录态
         */
        if(req.getRequestURI().startsWith("/admin/login")
                || req.getRequestURI().startsWith("/admin/logout")
                || req.getRequestURI().startsWith("/admin/verifyPwd")
                || req.getRequestURI().startsWith("/admin/createMerchant")
                || req.getRequestURI().startsWith("/error")
                || req.getRequestURI().startsWith("/admin/testLogin")
                || req.getRequestURI().startsWith("/admin/media")
                || req.getRequestURI().startsWith("/admin/page/login")){

            return true;
        }



        MerchantInfo merchantInfo = (MerchantInfo) req.getSession().getAttribute(SessionConsts.USER_LOGIN_INFO_SESSION);
        // 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆
        if (merchantInfo == null || "".equals(merchantInfo.getMerchantId())) {
            res.sendRedirect(PageNameConsts.LOGIN_URL);
            return false;
        }else{
            return true;
        }


    }


    /**
     * 渲染用户相关信息
     */
    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object arg2, ModelAndView model) throws Exception {

        /**
         * 非页面不处理
         */
        if(model == null){
            return;
        }

        /**
         * 未登录页面不处理
         */
        MerchantInfo merchantInfo = (MerchantInfo) req.getSession().getAttribute(SessionConsts.USER_LOGIN_INFO_SESSION);
        if(merchantInfo == null ){
            return;
        }


        model.addObject(SessionConsts.MODEL_MERCHANT_INFO,merchantInfo);

        MerchantRoleEnum merchantRoleEnum = MerchantRoleEnum.getRoleByType(merchantInfo.getRole());
        switch (merchantRoleEnum){
            case BAR:
                model.addObject(SessionConsts.MODEL_USER_MENU_FTL,"../common/barSlide.ftl");
                break;
            case AGENT:
                model.addObject(SessionConsts.MODEL_USER_MENU_FTL,"../common/agentSlide.ftl");
                break;
            case HANGZHOU:
                model.addObject(SessionConsts.MODEL_USER_MENU_FTL,"../common/agentSlide.ftl");
                break;
                default:
        }


    }


    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3) throws Exception {

    }
}
