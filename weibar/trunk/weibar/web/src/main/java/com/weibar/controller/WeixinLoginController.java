package com.weibar.controller;

import com.weibar.pojo.consts.WechatConsts;
import com.weibar.pojo.db.UserBaseInfo;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.service.function.UserService;
import com.weibar.service.function.WeChatLogService;
import com.weibar.utils.CookieUtils;
import com.weibar.utils.JsonConverter;
import com.weibar.utils.LoginUserUtil;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/28.
 * 处理微信授权登录
 */
@RestController
public class WeixinLoginController {

    private static final Logger logger = LoggerFactory.getLogger(WeixinLoginController.class);

    @Autowired
    private WxMpService wxMpService;
    @Autowired
    private UserService userService;
    @Autowired
    private WeChatLogService weChatLogService;

    private static final String INDEX_PAGE = "/static/choose.html";




    @RequestMapping(value = "/wechat/login" ,method = {RequestMethod.POST,RequestMethod.GET})
    public void wechatLogin(@RequestParam String code,
                            @RequestParam(required = false) String state,
                            HttpServletRequest request, HttpServletResponse response) throws BaseException, IOException {

        logger.info("wechat login request code " + code + " state:" + state );
        //微信无法传回原样的json 所以这里state直接就是重定向url
//        Map stateParam = new HashMap<>();
//        if(StringUtils.isNotBlank(state)){
//            stateParam = JsonConverter.jsonToMap(state);
//        }

        try{
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken = weChatLogService.getTokenByCode(code);
            if(wxMpOAuth2AccessToken == null){
                //从微信获取信息
                wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
                weChatLogService.addWeChatLog(wxMpOAuth2AccessToken,code);
            }


            //logger.info("WxMpOAuth2AccessToken is " + wxMpOAuth2AccessToken);
            WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
            //logger.info("WxMpUser is " + ToStringBuilder.reflectionToString(wxMpUser));
            //更新数据库用户信息
            if(wxMpUser != null){
                UserBaseInfo userBaseInfo = userService.updateUserInfoByWechat(wxMpUser);
                //logger.info("WxMpUser userBaseInfo " + ToStringBuilder.reflectionToString(userBaseInfo));
                LoginUserUtil.SessionUserInfo sessionUserInfo = LoginUserUtil.getSessionUserInfo(
                        userBaseInfo.getOpenid(),userBaseInfo.getUserId());
                //logger.info("WxMpUser LoginUserUtil.SessionUserInfo " + ToStringBuilder.reflectionToString(sessionUserInfo));
                //写入cookie 跳转到主页
                CookieUtils.addCookie(request, response,WechatConsts.COOKIE_OPENID, sessionUserInfo.getOpenId());
                CookieUtils.addCookie(request,response,WechatConsts.COOKIE_USERID,sessionUserInfo.getUserId().toString());
                CookieUtils.addCookie(request,response,WechatConsts.COOKIE_SESSION_KEY,sessionUserInfo.getSessionKey());

                //String redirectUrl = (String) stateParam.get(WechatConsts.STATE_PARAM_REDI_URL);
                if(StringUtils.isNotBlank(state)){
                    response.sendRedirect(state);
                }else{
                    response.sendRedirect(INDEX_PAGE);
                }

            }else{
                logger.error("wechat login error wxMpUser is null");
                throw BaseException.getException(ErrorCodeEnum.WECHAT_MP_ERROR_LOGIN_ERROR.getCode());
            }

        }catch (WxErrorException e){
            logger.error("wechat login error " + e.getError().toString());
            throw BaseException.getException(ErrorCodeEnum.WECHAT_MP_ERROR_LOGIN_ERROR.getCode());
        }
    }

}
