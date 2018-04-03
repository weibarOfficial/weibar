package com.weibar.controller;


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

@RestController
public class AdminMerchantController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminMerchantController.class);

    @Autowired
    private MerchantService merchantService;





    @RequestMapping(value = "/admin/createMerchant" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object createMerchant( HttpServletRequest request,@RequestParam String name,@RequestParam String loginName,@RequestParam int roleId,
                                  @RequestParam String pwd,@RequestParam Long parentMerchantId) throws BaseException {

        String md5pwd = EncryptUtil.getMD5(loginName + pwd);
        return BaseResult.getSuccessfulResult(merchantService.createMerchant(loginName,name,md5pwd,parentMerchantId,roleId));
    }

    @RequestMapping(value = "/admin/verifyPwd" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object verifyPwd( HttpServletRequest request,@RequestParam String loginName, @RequestParam String pwd) throws BaseException {

        String md5pwd = EncryptUtil.getMD5(loginName + pwd);
        MerchantInfo merchantInfo =merchantService.verifyPwd(loginName,md5pwd);
        BaseResult baseResult =  BaseResult.getSuccessfulResult(merchantInfo);
        request.getSession().setAttribute(SessionConsts.USER_LOGIN_INFO_SESSION, merchantInfo);
        return baseResult;
    }


    @RequestMapping(value = "/admin/createRootMerchant" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object createRootMerchant( HttpServletRequest request) throws BaseException {
        return BaseResult.getSuccessfulResult(merchantService.createRootMerchant());
    }

    @RequestMapping(value = "/admin/logout" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object logout( HttpServletRequest request,@RequestParam String loginName, @RequestParam String pwd) throws BaseException {

        request.getSession().setAttribute(SessionConsts.USER_LOGIN_INFO_SESSION, null);
        return BaseResult.getSuccessfulResult(merchantService.createRootMerchant());
    }


}
