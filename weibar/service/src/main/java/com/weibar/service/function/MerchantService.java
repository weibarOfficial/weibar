package com.weibar.service.function;

import com.weibar.pojo.consts.WechatConsts;
import com.weibar.pojo.db.WeibarMerchantsBaseInfo;
import com.weibar.pojo.db.WeibarMerchantsBaseInfoCriteria;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.enu.MerchantRoleEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.MerchantInfo;
import com.weibar.service.mapper.WeibarMerchantsBaseInfoMapper;
import com.weibar.utils.EncryptUtil;
import com.weibar.utils.IdGenerator;
import com.weibar.utils.QRCodeUtils;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.*;

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

    @Autowired
    private UserBalanceService userBalanceService;

    public static final Long MERCHANT_HANGZHOU_ID = 100L;
    public static final String MERCHANT_HANGZHOU_NAME = "杭州秉烛公司";
    public static final String MERCHANT_HANGZHOU_LOGIN_NAME = "hzbz";
    public static final String MERCHANT_HANGZHOU_PWD = "888888";


    private static final String MERCHANT_URL = "http://www.yylive.com/static/index.html?merchantId=";

    private static final Logger LOG = LoggerFactory.getLogger(MerchantService.class);



    public


    /**
     * 生成杭州公众号的函数
     */
    public MerchantInfo createRootMerchant() throws BaseException {
        userService.createMerchantUser(MERCHANT_HANGZHOU_ID,MERCHANT_HANGZHOU_NAME);
        WeibarMerchantsBaseInfo merchantsBaseInfo = new WeibarMerchantsBaseInfo();
        merchantsBaseInfo.setMerchantid(MERCHANT_HANGZHOU_ID);
        merchantsBaseInfo.setLoginName(MERCHANT_HANGZHOU_LOGIN_NAME);
        merchantsBaseInfo.setMerchantsName(MERCHANT_HANGZHOU_NAME);
        //用户登录密码【md5（md5（用户名 + 密码） + 盐）】
        SecureRandom secureRandom = new SecureRandom();
        merchantsBaseInfo.setParentMerchantid(0L);
        merchantsBaseInfo.setUserId(MERCHANT_HANGZHOU_ID);
        String hashSalt =  new Long(secureRandom.nextLong()).toString();
        merchantsBaseInfo.setHashSalt(hashSalt);
        merchantsBaseInfo.setHashPwd(EncryptUtil.getMD5(EncryptUtil.getMD5(MERCHANT_HANGZHOU_PWD + MERCHANT_HANGZHOU_NAME) + hashSalt));



        merchantsBaseInfo.setSharingRatioBarpin(1000);
        merchantsBaseInfo.setSharingRatioGive(500);
        merchantsBaseInfo.setSharingRatioRedp(750);

        merchantsBaseInfo.setRole(MerchantRoleEnum.HANGZHOU.getType());
        Date now = new Date();
        merchantsBaseInfo.setCreateTime(now);
        merchantsBaseInfo.setUpdateTime(now);

        weibarMerchantsBaseInfoMapper.insert(merchantsBaseInfo);

        userBalanceService.createMerchantUserBalnceIfNotExist(MERCHANT_HANGZHOU_ID);
        return getMerchantInfo(merchantsBaseInfo.getMerchantid());
    }


    /**
     *
     * @param loginName
     * @param md5Pwd md5（用户名 + 密码）
     * @param parentMerchantId
     * @return
     */
    public MerchantInfo createMerchant(String loginName,String name ,String md5Pwd, Long parentMerchantId,int roleId) throws BaseException {


        WeibarMerchantsBaseInfo weibarMerchantsBaseInfo = null;
        try{
            weibarMerchantsBaseInfo = getMerchantInfoByNameFromDb(loginName);
        }catch (Exception e){

        }

        if(weibarMerchantsBaseInfo != null){
            throw BaseException.getException(ErrorCodeEnum.MERCHANT_MERCHANT_NAME_EXIST.getCode());
        }

        try {
            getMerchantInfoFromDb(parentMerchantId);
        }catch (BaseException e){
            throw BaseException.getException(ErrorCodeEnum.MERCHANT_MERCHANT_AGENT_ID_NOT_EXIST.getCode());
        }



        Long merchantId = IdGenerator.generateIdByTime();
        userService.createMerchantUser(merchantId,loginName);


        //生成数据库记录
        WeibarMerchantsBaseInfo merchantsBaseInfo = new WeibarMerchantsBaseInfo();
        merchantsBaseInfo.setMerchantid(merchantId);
        merchantsBaseInfo.setMerchantsName(name);
        merchantsBaseInfo.setLoginName(loginName);
        //用户登录密码【md5（md5（用户名 + 密码） + 盐）】
        SecureRandom secureRandom = new SecureRandom();
        String hashSalt =  new Long(secureRandom.nextLong()).toString();
        merchantsBaseInfo.setHashSalt(hashSalt);
        merchantsBaseInfo.setHashPwd(EncryptUtil.getMD5(md5Pwd + hashSalt));


        merchantsBaseInfo.setSharingRatioBarpin(0);
        merchantsBaseInfo.setSharingRatioGive(0);
        merchantsBaseInfo.setSharingRatioRedp(0);

        merchantsBaseInfo.setRole(roleId);
        //merchantsBaseInfo.setRole(MerchantRoleEnum.AGENT.getType());

        // 代理上级所属,如果没有，则属于杭州公司
        if(parentMerchantId != null && parentMerchantId != 0){
            merchantsBaseInfo.setParentMerchantid(parentMerchantId);
        }else{
            merchantsBaseInfo.setParentMerchantid(MERCHANT_HANGZHOU_ID);
        }
        merchantsBaseInfo.setUserId(merchantId);

        Date now = new Date();
        merchantsBaseInfo.setCreateTime(now);
        merchantsBaseInfo.setUpdateTime(now);
        weibarMerchantsBaseInfoMapper.insert(merchantsBaseInfo);


        userBalanceService.createMerchantUserBalnceIfNotExist(merchantId);
        return getMerchantInfo(merchantsBaseInfo.getMerchantid());
    }






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


    public WeibarMerchantsBaseInfo getMerchantInfoByNameFromDb(String loginName)throws BaseException {
        WeibarMerchantsBaseInfoCriteria weibarMerchantsBaseInfoCriteria = new WeibarMerchantsBaseInfoCriteria();
        WeibarMerchantsBaseInfoCriteria.Criteria criteria = weibarMerchantsBaseInfoCriteria.createCriteria();
        criteria.andLoginNameEqualTo(loginName);
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
        criteria.andRoleEqualTo(MerchantRoleEnum.BAR.getType());
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


    /**
     * 根据酒吧ID获取代理链，根据酒吧节点 为 酒吧--> 代理---> .... --->杭州公司
     * @param merchantId
     * @return
     */
    public List<WeibarMerchantsBaseInfo> getMerchantList(Long merchantId) throws BaseException {
        List<WeibarMerchantsBaseInfo> merchantList = new ArrayList<>();
        while (true){
            WeibarMerchantsBaseInfo weibarMerchantsBaseInfo = getMerchantInfoFromDb(merchantId);
            merchantList.add(weibarMerchantsBaseInfo);
            Long parentMerchantId = weibarMerchantsBaseInfo.getParentMerchantid();
            if(parentMerchantId == null || parentMerchantId <= 0){
                break;
            }else{
                merchantId = parentMerchantId;
            }
        }
        //Collections.reverse(merchantList);
        for(int i = 0; i < merchantList.size() - 1; i++){
            WeibarMerchantsBaseInfo weibarMerchantsBaseInfo = merchantList.get(i);
            WeibarMerchantsBaseInfo weibarMerchantsBaseInfoParent = merchantList.get(i+1);
            if((weibarMerchantsBaseInfo.getSharingRatioBarpin() > weibarMerchantsBaseInfoParent.getSharingRatioBarpin() )
                    || (weibarMerchantsBaseInfo.getSharingRatioGive() > weibarMerchantsBaseInfoParent.getSharingRatioGive())
                    || (weibarMerchantsBaseInfo.getSharingRatioRedp() > weibarMerchantsBaseInfoParent.getSharingRatioRedp())){
                LOG.error("son shareRotio greter than parent." +
                        " son merchantId " + weibarMerchantsBaseInfo.getMerchantid()
                        + " parent Id " + weibarMerchantsBaseInfoParent.getMerchantid());
                throw BaseException.getException(ErrorCodeEnum.MERCHANT_MERCHANT_SHARE_ERROR.getCode());
            }
        }
        return merchantList;
    }





}
