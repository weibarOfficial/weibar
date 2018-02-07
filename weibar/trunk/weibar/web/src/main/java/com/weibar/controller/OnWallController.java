package com.weibar.controller;

import com.weibar.pojo.consts.WechatConsts;
import com.weibar.pojo.db.UserBaseInfo;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.service.function.GameFunctionService;
import com.weibar.service.function.MerchantService;
import com.weibar.service.function.UserLoginLogService;
import com.weibar.service.function.UserService;
import com.weibar.utils.CookieUtils;
import com.weibar.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/10/31.
 * 上墙页面controller
 */
@RestController
public class OnWallController {

    @Autowired
    private UserLoginLogService userLoginService;
    @Autowired
    private GameFunctionService gameFunctionService;
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private UserService userService;

    /**
     * 获取上墙酒吧 和 最近访问酒吧（上墙酒吧为第一个酒吧)
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "/h5/getLoginLog" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getLoginLog(HttpServletRequest request, HttpServletResponse response) throws BaseException {
        return BaseResult.getSuccessfulResult(userLoginService.getRecentLoginLog(LoginUserUtil.getLoginUserInfo().getOpenId()));
    }




    @RequestMapping(value = "/h5/deleteLoginLog" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object deleteLog(@RequestParam Long logId) throws BaseException {
        userLoginService.deleteLog(LoginUserUtil.getLoginUserInfo().getOpenId(),logId);
        return BaseResult.getSuccessfulResult(null);
    }


    @RequestMapping(value = "/h5/getFunctionList" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getFunctionList(@RequestParam Long merchantId){
        return BaseResult.getSuccessfulResult(gameFunctionService.getGameFunctions(merchantId));
    }


    /**
     * 获取商户信息（进入酒吧页面时候调用）
     * @param merchantId
     * @return
     */
    @RequestMapping(value = "/h5/getMerchantInfoWhenLogin" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getMerchantInfoWhenLogin(@RequestParam Long merchantId) throws BaseException {
        return BaseResult.getSuccessfulResult(merchantService.getMerchantInfoWhenLogin(merchantId,LoginUserUtil.getLoginUserInfo().getOpenId()));
    }

}
