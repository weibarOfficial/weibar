package com.weibar.service.function;

import com.weibar.pojo.db.WeibarMerchantsLoginLog;
import com.weibar.pojo.db.WeibarMerchantsLoginLogCriteria;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.UserLoginLog;
import com.weibar.service.mapper.WeibarMerchantsLoginLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2017/10/31.
 * 用户登录相关
 */
@Service
public class UserLoginLogService {

    @Autowired
    private WeibarMerchantsLoginLogMapper weibarMerchantsLoginLogMapper;
    @Autowired
    private UserService userService;

    private static int DEFAULT_LOG_COUNT = 30;



    /*
     * * 根据用户ID获取到用户最近访问的酒吧，最近一个就是第一个
     * 每个酒吧只取一条记录
     * @param openId
     * @return
     */
    public List<UserLoginLog> getRecentLoginLog(String openId) throws BaseException {
        List<WeibarMerchantsLoginLog> loginLogs = doGetRecentLoginLog(openId);
        List<UserLoginLog> userLoginLogs = new ArrayList<>();
        Set<Long> merchantIds = new HashSet<>();
        for(int i = 0 ; i < loginLogs.size(); i++){
            WeibarMerchantsLoginLog weibarMerchantsLoginLog = loginLogs.get(i);
            if(merchantIds.contains(weibarMerchantsLoginLog.getMerchantid())){
                continue;
            }
            merchantIds.add(weibarMerchantsLoginLog.getMerchantid());
            userLoginLogs.add(UserLoginLog.getUserLoginLog(weibarMerchantsLoginLog));
        }
        return userLoginLogs;
    }



    public void deleteLog(String openId,Long logId) throws BaseException {
        Long userId = userService.getUserIdByOpenId(openId);
        WeibarMerchantsLoginLogCriteria weibarMerchantsLoginLogCriteria = new WeibarMerchantsLoginLogCriteria();
        WeibarMerchantsLoginLogCriteria.Criteria criteria = weibarMerchantsLoginLogCriteria.createCriteria();
        criteria.andOpenidEqualTo(openId);
        criteria.andIdEqualTo(logId);
        int count = weibarMerchantsLoginLogMapper.deleteByExample(weibarMerchantsLoginLogCriteria);
        if(count != 1){
            throw new BaseException(ErrorCodeEnum.USER_USER_LOG_DELETE_FAIL.getCode(),ErrorCodeEnum.USER_USER_LOG_DELETE_FAIL.getMsg());
        }
    }


    /**
     * 增加登录记录（微信授权登录的时候调用）
     */
    public void addLog(Long merchantId,String openId,String merchantName,String merchantImgUrl,Long userId){
        WeibarMerchantsLoginLog log = new WeibarMerchantsLoginLog();
        Date now = new Date();
        log.setCreateTime(now);
        log.setLoginTime(now);
        log.setUpdateTime(now);
        log.setMerchantid(merchantId);
        log.setOpenid(openId);
        log.setMerchantsName(merchantName);
        log.setProducerlogoUrl(merchantImgUrl);
        log.setUserId(userId);
        weibarMerchantsLoginLogMapper.insert(log);
    }


    /**
     * 默认取出最近30条访问记录
     * @param openId
     * @return
     * @throws BaseException
     */
    public List<WeibarMerchantsLoginLog> doGetRecentLoginLog(String openId) throws BaseException {

        Long userId = userService.getUserIdByOpenId(openId);
        WeibarMerchantsLoginLogCriteria weibarMerchantsLoginLogCriteria = new WeibarMerchantsLoginLogCriteria();
        WeibarMerchantsLoginLogCriteria.Criteria criteria = weibarMerchantsLoginLogCriteria.createCriteria();
        criteria.andUserIdEqualTo(userId);
        weibarMerchantsLoginLogCriteria.setLimit(DEFAULT_LOG_COUNT);
        weibarMerchantsLoginLogCriteria.setOrderByClause(" login_time desc ");
        List<WeibarMerchantsLoginLog> loginLogs = weibarMerchantsLoginLogMapper.selectByExample(weibarMerchantsLoginLogCriteria);
        return loginLogs;
    }
}
