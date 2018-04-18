package com.weibar.controller;


import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.service.function.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MerchantUserController extends AbstractController {

    @Autowired
    private MerchantService merchantService;


    @RequestMapping(value = "/admin/getMerchantUsers" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getMerchantUsers( HttpServletRequest request) {
        return BaseResult.getSuccessfulResult(merchantService.getMerchantUsers(getMerchantInfoFromSession(request).getMerchantId()));
    }



}
