package com.weibar.controller;


import com.weibar.consts.SessionConsts;
import com.weibar.pojo.result.MerchantInfo;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

public class AbstractController {

    public MerchantInfo getMerchantInfoFromSession(HttpServletRequest request){
        MerchantInfo merchantInfo = (MerchantInfo) request.getSession().getAttribute(SessionConsts.USER_LOGIN_INFO_SESSION);
        return merchantInfo;
    }
}
