package com.weibar.service.function.weixin.handler;


import com.weibar.pojo.consts.WechatConsts;
import com.weibar.pojo.result.MerchantInfo;
import com.weibar.service.function.MerchantService;
import com.weibar.service.function.weixin.builder.TextBuilder;
import com.weibar.service.function.weixin.util.JsonUtils;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MsgHandler extends AbstractHandler {

    @Autowired
    private MerchantService merchantService;

    private static final Logger logger = LoggerFactory.getLogger(MsgHandler.class);

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

//        if (!wxMessage.getMsgType().equals(WxConsts.XML_MSG_EVENT)) {
//            //TODO 可以选择将消息保存到本地
//        }


        String content = "收到信息内容：" + JsonUtils.toJson(wxMessage);
        logger.info(content);

        //组装回复消息
        List<MerchantInfo> infoList =  merchantService.getMerchantInfosByName(wxMessage.getContent());

        String result = "";

        if(infoList == null || infoList.size() == 0){
            result = WechatConsts.DEFAULT_MSG_HANDLE_TEMPLATE;
        }else{
            StringBuilder stringBuilder = new StringBuilder();
            for(MerchantInfo merchantInfo : infoList){
                stringBuilder.append(String.format(WechatConsts.MSG_HANDLE_TEMPLATE_BAR_SINGLE,merchantInfo.getWechatLoginUrl(),merchantInfo.getName()));
            }
            result = String.format(WechatConsts.MSG_HANDLE_TEMPLATE_BAR,stringBuilder.toString());
        }

        return new TextBuilder().build(result, wxMessage, weixinService);

    }

}
