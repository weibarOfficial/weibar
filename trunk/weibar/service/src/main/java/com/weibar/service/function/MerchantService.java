package com.weibar.service.function;

import com.weibar.pojo.consts.WechatConsts;
import com.weibar.pojo.db.WeibarMerchantsBaseInfo;
import com.weibar.pojo.db.WeibarMerchantsBaseInfoCriteria;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.MerchantInfo;
import com.weibar.service.mapper.WeibarMerchantsBaseInfoMapper;
import com.weibar.utils.JsonConverter;
import com.weibar.utils.QRCodeUtils;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/30.
 */
@Service
public class MerchantService {

    @Autowired
    private WeibarMerchantsBaseInfoMapper weibarMerchantsBaseInfoMapper;

    @Autowired
    private UserLoginLogService userLoginLogService;

    @Autowired
    private UserService userService;

    @Autowired
    private WxMpService wxService;


    private static final String MERCHANT_URL = "http://www.yylive.com/static/index.html?merchantId=";

    private static final Logger LOG = LoggerFactory.getLogger(MerchantService.class);


    /**
     * 获取商户信息（进入酒吧页面时候调用）
     * @param merchantId
     * @param openId
     * @return
     * @throws BaseException
     */
    public MerchantInfo getMerchantInfoWhenLogin(Long merchantId,String openId)throws BaseException{
        MerchantInfo merchantInfo = getMerchantInfo(merchantId);
        userLoginLogService.addLog(merchantInfo.getMerchantId(),openId,merchantInfo.getName(),merchantInfo.getLogoUrl(),userService.getUserIdByOpenId(openId));
        return merchantInfo;
    }

    public MerchantInfo getMerchantInfo(Long merchantId)throws BaseException {
        MerchantInfo merchantInfo = MerchantInfo.getMerchantInfo(getMerchantInfoFromDb(merchantId));
        return merchantInfo;
    }


    /**
     * 返回商户信息
     * @param merchantId
     * @return
     * @throws BaseException
     */
    public WeibarMerchantsBaseInfo getMerchantInfoFromDb(Long merchantId)throws BaseException {
        WeibarMerchantsBaseInfoCriteria weibarMerchantsBaseInfoCriteria = new WeibarMerchantsBaseInfoCriteria();
        WeibarMerchantsBaseInfoCriteria.Criteria criteria = weibarMerchantsBaseInfoCriteria.createCriteria();
        criteria.andMerchantidEqualTo(merchantId);
        List<WeibarMerchantsBaseInfo> merchantsBaseInfoList =  weibarMerchantsBaseInfoMapper.selectByExample(weibarMerchantsBaseInfoCriteria);
        if(merchantsBaseInfoList == null || merchantsBaseInfoList.size() == 0){
            throw BaseException.getException(ErrorCodeEnum.MERCHANT_MERCHANT_ID_NOT_EXIST.getCode());
        }
        return merchantsBaseInfoList.get(0);
    }


    /**
     * 获取全部酒吧信息
     * @return
     */
    public List<MerchantInfo> getMerchantInfos(){
        WeibarMerchantsBaseInfoCriteria weibarMerchantsBaseInfoCriteria = new WeibarMerchantsBaseInfoCriteria();
        WeibarMerchantsBaseInfoCriteria.Criteria criteria = weibarMerchantsBaseInfoCriteria.createCriteria();
        List<WeibarMerchantsBaseInfo> merchantsBaseInfoList =  weibarMerchantsBaseInfoMapper.selectByExample(weibarMerchantsBaseInfoCriteria);
        return MerchantInfo.getMerchantInfos(merchantsBaseInfoList);
    }


    /**
     * 根据关键字获取酒吧信息
     * @param name
     * @return
     */
    public List<MerchantInfo> getMerchantInfosByName(String name){
        WeibarMerchantsBaseInfoCriteria weibarMerchantsBaseInfoCriteria = new WeibarMerchantsBaseInfoCriteria();
        WeibarMerchantsBaseInfoCriteria.Criteria criteria = weibarMerchantsBaseInfoCriteria.createCriteria();
        criteria.andMerchantsNameLike("%" + name + "%");
        List<WeibarMerchantsBaseInfo> merchantsBaseInfoList =  weibarMerchantsBaseInfoMapper.selectByExample(weibarMerchantsBaseInfoCriteria);
        return MerchantInfo.getMerchantInfos(merchantsBaseInfoList);
    }


    /**
     * 获取酒吧二维码
     * @param merchantId
     * @return
     * @throws BaseException
     */
    public String generateQRCodeImgUrl(Long merchantId) throws BaseException {

        return QRCodeUtils.getQrCodeImgUrl(getMerchantLogInUrl(merchantId));
    }


    /**
     * 获取酒吧授权登录url
     * @param merchantId
     * @return
     * @throws BaseException
     */
    public String getMerchantLogInUrl(Long merchantId)throws BaseException{
        //微信无法传回原样的json 所以这里state直接就是重定向url
        String redirectUrl = MERCHANT_URL + String.valueOf(merchantId);
        String state = redirectUrl;
        LOG.info("getMerchantLogInUrl state " + state);
        try {
            state = URLEncoder.encode(state,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOG.error("getMerchantLogInUrl encode error state " + state,e);
            throw BaseException.getException(ErrorCodeEnum.URL_ENCODE_ERROR.getCode());
        }
        String url = wxService.oauth2buildAuthorizationUrl(WechatConsts.LOGIN_IN_REDIRECT_URL, WxConsts.OAUTH2_SCOPE_USER_INFO, state);
        return url;
    }





}
