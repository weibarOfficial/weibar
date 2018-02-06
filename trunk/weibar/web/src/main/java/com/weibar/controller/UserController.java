package com.weibar.controller;

import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.pojo.result.UserBalance;
import com.weibar.pojo.result.UserInfo;
import com.weibar.service.function.UserBalanceService;
import com.weibar.service.function.UserService;
import com.weibar.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/1.
 */
@RestController
public class UserController {

    @Autowired
    private UserBalanceService userBanlaceService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/h5/getUserBalance" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getUserBalance() throws BaseException {
        return BaseResult.getSuccessfulResult(UserBalance.getUserBalance(userBanlaceService.getUserBalanceByOpenId(LoginUserUtil.getLoginUserInfo().getOpenId())));
    }

    @RequestMapping(value = "/h5/getUserInfo" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getUserInfo()throws BaseException{
        return BaseResult.getSuccessfulResult(UserInfo.getUserInfo(userService.getUserByOpenId(LoginUserUtil.getLoginUserInfo().getOpenId())));
    }

    @RequestMapping(value = "/h5/getUserInfoByUserId" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getUserInfoByUserId(@RequestParam Long userId)throws BaseException{
        return BaseResult.getSuccessfulResult(UserInfo.getUserInfo(userService.getUserById(userId)));
    }

}
