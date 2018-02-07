package com.weibar.service.function;

import com.github.binarywang.wxpay.service.WxPayService;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.exception.BaseException;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2018/1/25.
 */
@Service
public class WechatMpService {


    private static final Logger LOG = LoggerFactory.getLogger(WechatMpService.class);


    @Autowired
    private WxMpService wxMpService;

    /**
     * 不同消息有不同消息模板，需要在公众号内设置
     * http://www.cnblogs.com/txw1958/p/wechat-template-message.html
     */
    public void sendTemplateMsg(String templateId, Map<String,String> data,String openId) throws BaseException {

        WxMpTemplateMessage wxMpTemplateMessage = new WxMpTemplateMessage();
        wxMpTemplateMessage.setTemplateId(templateId);
        wxMpTemplateMessage.setToUser(openId);

        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(wxMpTemplateMessage);
        } catch (WxErrorException e) {
            LOG.error("wechat mp send msg error",e);
            throw BaseException.getException(ErrorCodeEnum.WECHAT_MP_ERROR_SEND_TEMPLATE_MSG.getCode());
        }
    }

}
