package com.weibar.service.function;

import com.weibar.pojo.db.WeibarWechatLoginLog;
import com.weibar.pojo.db.WeibarWechatLoginLogCriteria;
import com.weibar.service.mapper.WeibarWechatLoginLogMapper;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 */
@Service
public class WeChatLogService {

    @Autowired
    private WeibarWechatLoginLogMapper weibarWechatLoginLogMapper;

    public void addWeChatLog(WxMpOAuth2AccessToken wxMpOAuth2AccessToken,String code){
        WeibarWechatLoginLog loginLog = new WeibarWechatLoginLog();
        loginLog.setScope(wxMpOAuth2AccessToken.getScope());
        loginLog.setRefreshToken(wxMpOAuth2AccessToken.getRefreshToken());
        loginLog.setAccessToken(wxMpOAuth2AccessToken.getAccessToken());
        loginLog.setCode(code);
        Date now = new Date();
        loginLog.setCreateTime(now);
        loginLog.setExpiresIn(new Long(wxMpOAuth2AccessToken.getExpiresIn()));
        loginLog.setOpenid(wxMpOAuth2AccessToken.getOpenId());
        loginLog.setUpdateTime(now);
        weibarWechatLoginLogMapper.insert(loginLog);
    }


    /**
     * 判断这个code是不是已经使用过，因为微信的code只能用一次
     * 这里只是为了防止那种URL被APP重复刷新导致code被使用失败的情况
     * @param code
     * @return
     */
    public WxMpOAuth2AccessToken getTokenByCode(String code){
        WeibarWechatLoginLogCriteria loginLogCriteria = new WeibarWechatLoginLogCriteria();
        WeibarWechatLoginLogCriteria.Criteria criteria = loginLogCriteria.createCriteria();
        criteria.andCodeEqualTo(code);
        List<WeibarWechatLoginLog> loginLogs =  weibarWechatLoginLogMapper.selectByExample(loginLogCriteria);
        if(loginLogs == null || loginLogs.size() == 0){
            return null;
        }else{
            WeibarWechatLoginLog loginLog  = loginLogs.get(0);
            WxMpOAuth2AccessToken token = new WxMpOAuth2AccessToken();
            token.setAccessToken(loginLog.getAccessToken());
            token.setExpiresIn(Math.toIntExact(loginLog.getExpiresIn()));
            token.setOpenId(loginLog.getOpenid());
            token.setRefreshToken(loginLog.getRefreshToken());
            token.setScope(loginLog.getScope());
            return token;
        }
    }
}
