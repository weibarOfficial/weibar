package com.weibar.service.function;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.weibar.pojo.db.DakaUser;
import com.weibar.pojo.db.UserBaseInfo;
import com.weibar.pojo.enu.AppEnum;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.exception.BaseException;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.util.crypto.PKCS7Encoder;
import org.apache.catalina.User;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;

/**
 * Created by Administrator on 2018/2/1.
 */
@Service
public class WechatMiniProgramService {


    private static final Logger LOG = LoggerFactory.getLogger(WechatMiniProgramService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private WxMaService wxService;



    public UserBaseInfo login(String code,String nickName, String avatarUrl,String gender,String province,String ctiy,String country) throws BaseException {
        WxMaJscode2SessionResult sessionResult = null;
        try {
            sessionResult = wxService.getUserService().getSessionInfo(code);
        } catch (WxErrorException e) {
            LOG.error("get session info error ",e);
            throw BaseException.getException(ErrorCodeEnum.MINIPRAGRAM_CODE_FAIL.getCode());
        }
        LOG.info("daka login get sessionResult openId" + sessionResult.getOpenid());
        WxMaUserInfo userInfo = new WxMaUserInfo();
        userInfo.setOpenId(sessionResult.getOpenid());
        userInfo.setAvatarUrl(avatarUrl);
        userInfo.setGender(gender);
        userInfo.setProvince(province);
        userInfo.setCity(ctiy);
        userInfo.setCountry(country);
        userInfo.setNickName(nickName);
        userInfo.setUnionId(sessionResult.getUnionid());
        UserBaseInfo userBaseInfo = userService.updateUserInfoByWechatMiniProgram(userInfo, AppEnum.DAKA_MINI);

        return userBaseInfo;
    }
}
