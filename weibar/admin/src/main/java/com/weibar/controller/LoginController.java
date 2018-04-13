package com.weibar.controller;

import com.weibar.consts.PageNameConsts;
import com.weibar.consts.SessionConsts;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.pojo.result.MerchantInfo;
import com.weibar.service.function.MerchantService;
import com.weibar.utils.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LoginController {


    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private MerchantService merchantService;


    @RequestMapping(value = "/admin/verifyPwd" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object verifyPwd(HttpServletRequest request, @RequestParam String loginName, @RequestParam String pwd) throws BaseException {

        String md5pwd = EncryptUtil.getMD5(loginName + pwd);
        MerchantInfo merchantInfo =merchantService.verifyPwd(loginName,md5pwd);
        BaseResult baseResult =  BaseResult.getSuccessfulResult(merchantInfo);
        request.getSession().setAttribute(SessionConsts.USER_LOGIN_INFO_SESSION, merchantInfo);
        return baseResult;
    }


    @RequestMapping(value = "/admin/logout" ,method = {RequestMethod.POST,RequestMethod.GET})
    public void logout(HttpServletRequest request, HttpServletResponse res) throws BaseException, IOException {

        request.getSession().setAttribute(SessionConsts.USER_LOGIN_INFO_SESSION, null);
        res.sendRedirect(PageNameConsts.LOGIN_URL);
    }






//    @RequestMapping(value = "/admin/testLogin" ,method = {RequestMethod.POST,RequestMethod.GET})
//    public Object testLogin( HttpServletRequest request) throws BaseException {
//
//        MerchantInfo merchantInfo = (MerchantInfo) request.getSession().getAttribute(SessionConsts.USER_LOGIN_INFO_SESSION);
//        boolean hasLogin = false;
//        // 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆
//        if (merchantInfo == null || "".equals(merchantInfo.getMerchantId())) {
//            hasLogin = false;
//        }else {
//            hasLogin = true;
//        }
//        return BaseResult.getSuccessfulResult(hasLogin);
//    }



}
