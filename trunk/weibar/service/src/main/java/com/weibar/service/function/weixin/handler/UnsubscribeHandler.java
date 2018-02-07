package com.weibar.service.function.weixin.handler;

import com.weibar.pojo.db.UserBaseInfo;
import com.weibar.pojo.db.UserBaseInfoCriteria;
import com.weibar.pojo.enu.UserInfoStatusEnum;
import com.weibar.service.mapper.UserBaseInfoMapper;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class UnsubscribeHandler extends AbstractHandler {


    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) {
        String openId = wxMessage.getFromUser();
        this.logger.info("user un subscribe  " + wxMessage);
        //可以更新本地数据库为取消关注状态

        UserBaseInfoCriteria baseInfoCriteria = new UserBaseInfoCriteria();
        UserBaseInfoCriteria.Criteria criteria1 = baseInfoCriteria.createCriteria();
        criteria1.andOpenidEqualTo(wxMessage.getFromUser());
        List<UserBaseInfo> userBaseInfoList = userBaseInfoMapper.selectByExample(baseInfoCriteria);

        if(userBaseInfoList != null && userBaseInfoList.size() > 0){
            userBaseInfoList.get(0).setStatus(UserInfoStatusEnum.NOT_SUB.getState());
            userBaseInfoList.get(0).setUpdateTime(new Date());
            userBaseInfoMapper.updateByPrimaryKey(userBaseInfoList.get(0));
        }
        return null;
    }

}
