package com.weibar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestWebsocketController {
    private static final Logger LOG = LoggerFactory.getLogger(TestWebsocketController.class);


    @Autowired
    private SimpMessagingTemplate template;


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return "Hello, " + message + "!";
    }

    @RequestMapping(value = "/test/sendViaWs" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object testSendViaWs(@RequestParam String content) throws Exception {
        template.convertAndSend("/topic/greetings", content);
        return content;
    }

}
