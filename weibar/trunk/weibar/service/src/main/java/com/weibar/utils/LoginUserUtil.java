package com.weibar.utils;



import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.exception.BaseException;
import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Created by Administrator on 2017/12/6.
 * 保存每个请求的用户信息（进入interceptor清除上一个请求的的SessionUserInfo）
 */

public class LoginUserUtil {


    private static final Logger LOG = LoggerFactory.getLogger(LoginUserUtil.class);

    public static class SessionUserInfo {

        private String openId;
        private Long userId;
        private String sessionKey;

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getSessionKey() {
            return sessionKey;
        }

        public void setSessionKey(String sessionKey) {
            this.sessionKey = sessionKey;
        }


        @Override
        public String toString() {
            return "SessionUserInfo{" +
                    "openId='" + openId + '\'' +
                    ", userId=" + userId +
                    ", sessionKey='" + sessionKey + '\'' +
                    '}';
        }
    }

    /**
     * 校验cookie是否合法
     * @param openId
     * @param userId
     * @param sessionKey
     * @return
     * @throws BaseException
     *
     */
    public static SessionUserInfo validate(String openId,String userId,String sessionKey)throws BaseException{

        if(StringUtils.isAnyBlank(openId,sessionKey,userId)){
            throw BaseException.getException(ErrorCodeEnum.LOGIN_ERROR_NO_LOGIN.getCode());
        }
        SessionUserInfo sessionUserInfo = getSessionUserInfo(openId,Long.parseLong(userId));
        //LOG.info("sessionUserInfo " + sessionUserInfo  + " sessionKey :" + sessionKey);
        if(!StringUtils.equals(sessionUserInfo.getSessionKey(),sessionKey)){
            throw BaseException.getException(ErrorCodeEnum.LOGIN_ERROR_LOGIN_INFO_ERROR.getCode());
        }
        return sessionUserInfo;
    }


//    public static void main(String[] args){
//        UserBaseInfo userBaseInfo = new UserBaseInfo();
//        System.out.println(ToStringBuilder.reflectionToString(userBaseInfo));
//    }


    public static SessionUserInfo getSessionUserInfo(String openId,Long userId){

        SessionUserInfo sessionUserInfo = new SessionUserInfo();
        sessionUserInfo.setOpenId(openId);
        sessionUserInfo.setUserId(userId);
        sessionUserInfo.setSessionKey(genSessionKey(openId,userId));
        return sessionUserInfo;
    }


    private static String genSessionKey(String openId,Long userId){
        String signStr = openId + userId.toString() ;
        return SignUtils.encryptAES(signStr);
    }

    public static SessionUserInfo getLoginUserInfo(){
        return userInfoThreadLocal.get();
    }

    public static void setLoginUserInfo(String openId,String userId,String sessionKey)throws BaseException{
        userInfoThreadLocal.set(null);
        SessionUserInfo userInfo = validate(openId,userId,sessionKey);
        userInfoThreadLocal.set(userInfo);
    }





    private static ThreadLocal<SessionUserInfo> userInfoThreadLocal = new ThreadLocal<>() ;
}
