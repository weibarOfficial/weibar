package com.weibar.service.function;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.binarywang.wx.miniapp.bean.WxMaWxcodeLimit;
import cn.binarywang.wx.miniapp.util.http.QrCodeRequestExecutor;
import com.weibar.pojo.db.DakaUser;
import com.weibar.pojo.db.UserBaseInfo;
import com.weibar.pojo.enu.AppEnum;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.DakaQrCodeFix;
import com.weibar.utils.AliOssClient;
import com.weibar.utils.JsonConverter;
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
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;

import static cn.binarywang.wx.miniapp.api.WxMaQrcodeService.GET_WXACODE_UNLIMIT_URL;

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


    public String createMaQrcode(String scene,String page) throws BaseException {
        try {
            //File file = wxService.getQrcodeService().createWxCode(page);


            //为了修复原来微信调用库的bug而创建
            DakaQrCodeFix wxMaWxcodeLimit = new DakaQrCodeFix();
            wxMaWxcodeLimit.setScene(scene);
            wxMaWxcodeLimit.setPage(page);
            wxMaWxcodeLimit.setWidth(430);
            wxMaWxcodeLimit.setAuto_color(true);
            wxMaWxcodeLimit.setLine_color(null);

            File file = wxService.execute(new QrCodeRequestExecutor(wxService.getRequestHttp()),
                    GET_WXACODE_UNLIMIT_URL, wxMaWxcodeLimit);


            String url = AliOssClient.getImgUrlByFileName(AliOssClient.uploadFile(file));
            return url;
        } catch (WxErrorException e) {
            LOG.error("createMaQrcode error ",e);
            throw BaseException.getException(ErrorCodeEnum.MINIPRAGRAM_GET_QR_ERROR.getCode());
        }
    }
}
