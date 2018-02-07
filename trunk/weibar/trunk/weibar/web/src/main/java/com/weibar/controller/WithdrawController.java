package com.weibar.controller;

import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.pojo.result.UserBalance;
import com.weibar.service.function.UserService;
import com.weibar.service.function.WithdrawService;
import com.weibar.utils.IpUtil;
import com.weibar.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nixiaoming on 2017/11/19.
 */
@RestController
public class WithdrawController {

    @Autowired
    private WithdrawService withdrawService;
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/h5/withdraw" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object withdraw(@RequestParam String amount, HttpServletRequest request) throws BaseException {
        withdrawService.withdraw(userService.getUserIdByOpenId(LoginUserUtil.getLoginUserInfo().getOpenId()),amount, IpUtil.getRequestIp(request));
        return BaseResult.getSuccessfulResult(null);
    }

    @RequestMapping(value = "/h5/withdrawList" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object withdrawList() throws BaseException {
        return BaseResult.getSuccessfulResult(withdrawService.getUserWithdrawLogs(userService.getUserIdByOpenId(LoginUserUtil.getLoginUserInfo().getOpenId())));
    }
}
