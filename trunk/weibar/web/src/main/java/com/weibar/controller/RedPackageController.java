package com.weibar.controller;

import com.weibar.utils.IpUtil;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.pojo.result.UserRedPackage;
import com.weibar.service.function.RedPackageService;
import com.weibar.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/11/14.
 */
@RestController
public class RedPackageController {

    @Autowired
    private RedPackageService redPackageService;

    @RequestMapping(value = "/h5/prepareCreateRedPackage" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object createRedPackageBeforePay(HttpServletRequest request,@RequestParam String amount,
                                            @RequestParam Long merchantId,
                                          @RequestParam int sendNumber,@RequestParam String redPackageTitle) throws BaseException {
        return BaseResult.getSuccessfulResult(redPackageService.
                prepareCreateRedPackage(merchantId, LoginUserUtil.getLoginUserInfo().getUserId(),amount,sendNumber,redPackageTitle,IpUtil.getRequestIp(request)));
    }

    @RequestMapping(value = "/h5/createRedPackage" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object createRedPackageAfterPay(@RequestParam long redPackageId) throws BaseException {
        return BaseResult.getSuccessfulResult(redPackageService.createRedPackage(redPackageId));
    }

    @RequestMapping(value = "/h5/userOpenRedPackage" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object userOpenRedPackage(HttpServletRequest request,@RequestParam Long merchantId,@RequestParam long redPackageId) throws BaseException {
        return BaseResult.getSuccessfulResult(UserRedPackage.getUserRedPackage(
                redPackageService.userOpenRedPackage(merchantId,redPackageId,LoginUserUtil.getLoginUserInfo().getUserId(), IpUtil.getRequestIp(request),"用户领取红包")));
    }

    @RequestMapping(value = "/h5/getRedPackageList" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getRedPackageList(HttpServletRequest request,@RequestParam long redPackageId) throws BaseException {
        return BaseResult.getSuccessfulResult(redPackageService.getUserRedPackageList(redPackageId));
    }

}
