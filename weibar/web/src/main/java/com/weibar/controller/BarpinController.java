package com.weibar.controller;

import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.service.function.BarpinService;
import com.weibar.service.function.PriceTimeService;
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
 * 霸屏相关
 * Created by Administrator on 2017/11/21.
 */
@RestController
public class BarpinController {

    @Autowired
    private BarpinService barpinService;
    @Autowired
    private UserService userService;
    @Autowired
    private PriceTimeService priceTimeService;


    @RequestMapping(value = "/h5/priceTimeInfo" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object priceTimeInfo(@RequestParam Long merchantId) throws BaseException {
        return BaseResult.getSuccessfulResult(priceTimeService.getPriceTimeSettingInfo(merchantId));
    }

    /**
     * 为TA霸屏
     * @param merchantId
     * @param messageId
     * @param second
     * @param times
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "/h5/barping" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object barping(@RequestParam Long merchantId,
                          @RequestParam Long messageId,
                          @RequestParam Integer second,
                          @RequestParam(required = false) String content,
                          @RequestParam(required = false) Integer theme,
                          @RequestParam Integer times, HttpServletRequest request) throws BaseException {

        return BaseResult.getSuccessfulResult(barpinService.barpin(merchantId,messageId,second,
                userService.getUserIdByOpenId(LoginUserUtil.getLoginUserInfo().getOpenId()),times, IpUtil.getRequestIp(request),theme,content));
    }


    @RequestMapping(value = "/h5/barpinThemes" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object barpinTitle() throws BaseException {
        return BaseResult.getSuccessfulResult(barpinService.getTitles());
    }

    @RequestMapping(value = "/pc/barpinThemes" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object barpinTitlePc() throws BaseException {
        return BaseResult.getSuccessfulResult(barpinService.getTitles());
    }
}
