package com.weibar.controller;

import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.service.function.GiveService;
import com.weibar.service.function.UserService;
import com.weibar.utils.IpUtil;
import com.weibar.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 打赏
 * Created by Administrator on 2017/11/22.
 */
@RestController
public class GiveController {

    @Autowired
    private GiveService giveService;

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/h5/give" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object give(@RequestParam Long merchantId,
                          @RequestParam Long goodsId,
                          @RequestParam Integer giveType,
                          @RequestParam Long userIdGiven,
                          @RequestParam(required = false) String content,
                       HttpServletRequest request) throws BaseException {

        return BaseResult.getSuccessfulResult(giveService.give(merchantId,
                userService.getUserByOpenId(LoginUserUtil.getLoginUserInfo().getOpenId()),
                userService.getUserById(userIdGiven),
                IpUtil.getRequestIp(request),
                goodsId,content,giveType));
    }

}
