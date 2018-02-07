package com.weibar.controller;

import com.weibar.pojo.db.WeibarMerchantsBarrageInfo;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BarpinResult;
import com.weibar.pojo.result.BarrageInfo;
import com.weibar.pojo.result.BaseResult;
import com.weibar.service.function.BarpinService;
import com.weibar.service.function.BarrageService;
import com.weibar.utils.IpUtil;
import com.weibar.utils.LoginUserUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 * 进入酒吧之后相关接口，酒吧聊天界面接口
 */

@RestController
public class BarrageController {

    private static final Logger LOG = LoggerFactory.getLogger(BarrageController.class);

    @Autowired
    private BarrageService barrageService;
    @Autowired
    private BarpinService barpinService;

    /**
     * 不校验登录态
     * @param merchantId
     * @param count
     * @param beginTime
     * @param endTime
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "/pc/barrageList" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object PcBarrageList(@RequestParam Long merchantId,
                                @RequestParam Integer count,
                                @RequestParam(required = false) Long beginTime,
                                @RequestParam(required = false) Long endTime) throws BaseException {

        List<BarrageInfo> barrageInfoList =  barrageService.getBarrageList(endTime,beginTime,count,merchantId,null);
        return BaseResult.getSuccessfulResult(barrageInfoList);
    }

    /**
     * @param merchantId
     * @param count
     * @param endTime
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "/h5/barrageList" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object h5BarrageList(@RequestParam Long merchantId,
                                @RequestParam Integer count,
                                @RequestParam(required = false) Long beginTime,
                                @RequestParam(required = false) Long endTime) throws BaseException {

        List<BarrageInfo> barrageInfoList =  barrageService.getBarrageList(endTime,beginTime,count,merchantId, LoginUserUtil.getLoginUserInfo().getUserId());
        return BaseResult.getSuccessfulResult(barrageInfoList);
    }

    @RequestMapping(value = "/h5/deleteBarrage" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object deleteBarrage(@RequestParam Long merchantId,
                                @RequestParam Long messageId)throws BaseException{
        barrageService.deleteBarrage(messageId,LoginUserUtil.getLoginUserInfo().getOpenId(),merchantId);
        return BaseResult.getSuccessfulResult(null);
    }


    @RequestMapping(value = "/h5/addWordsAndPic" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object addWordsAndPicBarrage(@RequestParam Long merchantId,
                                  @RequestParam(required = false) String content,
                                  @RequestParam(required = false) String picUrl) throws BaseException {
        if(StringUtils.isAllEmpty(content,picUrl)){
            throw BaseException.getException(ErrorCodeEnum.BARRAGE_BARRAGE_EMPTY.getCode());
        }

        BarrageInfo barrageInfo;
        if(StringUtils.isEmpty(picUrl)){
            barrageInfo = barrageService.addNewWordBarrageInfo(merchantId,LoginUserUtil.getLoginUserInfo().getOpenId(),content);
        }else if(StringUtils.isEmpty(content)){
            barrageInfo = barrageService.addNewPicBarrageInfo(merchantId,LoginUserUtil.getLoginUserInfo().getOpenId(),picUrl);
        }else{
            barrageInfo = barrageService.addNewWordsAndPicBarrageInfo(merchantId,LoginUserUtil.getLoginUserInfo().getOpenId(),picUrl,content);
        }
        return BaseResult.getSuccessfulResult(barrageInfo);
    }




    @RequestMapping(value = "/h5/addBarping" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object addBarping(@RequestParam Long merchantId,
                             @RequestParam(required = false) String content,
                             @RequestParam(required = false) String picUrl,
                             @RequestParam Integer second,
                             @RequestParam(required = false) Integer theme,
                             @RequestParam Integer times, HttpServletRequest request) throws BaseException {
        BarrageInfo barrageInfo = barrageService.addNotShowBarrageInfo(merchantId,LoginUserUtil.getLoginUserInfo().getOpenId(),picUrl,content);
        BarpinResult barpinResult = barpinService.barpin(merchantId,barrageInfo.getMessageId(),second,barrageInfo.getUserId(),times, IpUtil.getRequestIp(request),theme,content);
        return BaseResult.getSuccessfulResult(barpinResult);
    }

}
