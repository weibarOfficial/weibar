package com.weibar.controller;

import com.weibar.pojo.consts.WebSocketConsts;
import com.weibar.pojo.result.PrivateChat;
import com.weibar.service.function.PrivateChatService;
import com.weibar.service.function.WsCacheService;
import com.weibar.utils.JsonConverter;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/12/28.
 */

@Controller
public class WebSocketController {

    private static final Logger LOG = LoggerFactory.getLogger(WebSocketController.class);



    @Autowired
    private PrivateChatService privateChatService;

    @Autowired
    private WsCacheService wsCacheService;


    @MessageMapping(WebSocketConsts.WS_PATH_PRIVATE_CHAT_PREFIX + "{chatId}")
    public void websocketChat(@DestinationVariable String chatId) throws Exception {
//        List<PrivateChat> privateChatList = privateChatService.getPrivateChatListByChatId(Long.parseLong(chatId),System.currentTimeMillis(),PrivateChatService.DEFAULT_CHAT_COUNT);
//        String result = JsonConverter.toJson(privateChatList);
//        wsCacheService.addNewWs(WebSocketConsts.WS_PATH_SEND_PRIVATE_CHAT_PREFIX + chatId,result);
    }


    @MessageMapping(WebSocketConsts.WS_PATH_BARRAGE + "{merchatId}")
    public void websocketBarrage(@DestinationVariable String merchatId) throws Exception {
    }
}
