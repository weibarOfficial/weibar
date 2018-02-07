package com.weibar.controller;

import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.service.function.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/12/18.
 */
@RestController
public class MerchantController {

    @Autowired
    private MerchantService merchantService;


    @RequestMapping(value = "/h5/getAllMerchants" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getAllMerchants(HttpServletRequest request, HttpServletResponse response) throws BaseException {
        return BaseResult.getSuccessfulResult(merchantService.getMerchantInfos());
    }




    @RequestMapping(value = "/pc/getMerchant" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getMerchant(HttpServletRequest request, HttpServletResponse response,@RequestParam Long merchantId) throws BaseException {
        return BaseResult.getSuccessfulResult(merchantService.getMerchantInfo(merchantId));
    }




    //test url

    @RequestMapping(value = "/h5/getMerchantByName" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getMerchantByName(HttpServletRequest request, HttpServletResponse response,@RequestParam String name) throws BaseException {
        return BaseResult.getSuccessfulResult(merchantService.getMerchantInfosByName(name));
    }

    @RequestMapping(value = "/h5/getMerchantQRImg" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getMerchantQRImg(HttpServletRequest request, HttpServletResponse response,@RequestParam Long merchantId) throws BaseException {
        return BaseResult.getSuccessfulResult(merchantService.generateQRCodeImgUrl(merchantId));
    }


    @RequestMapping(value = "/h5/getMerchantLoginUrl" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getMerchantLoginUrl(HttpServletRequest request, HttpServletResponse response,@RequestParam Long merchantId) throws BaseException {
        return BaseResult.getSuccessfulResult(merchantService.getMerchantLogInUrl(merchantId));
    }
}
