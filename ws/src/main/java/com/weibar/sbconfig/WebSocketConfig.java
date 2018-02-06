package com.weibar.sbconfig;


import com.weibar.pojo.consts.WechatConsts;
import com.weibar.pojo.exception.BaseException;
import com.weibar.utils.CookieUtils;
import com.weibar.utils.LoginUserUtil;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

@Configuration
@Validated
@EnableWebSocketMessageBroker
@ConfigurationProperties(prefix="websocket")
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    private static final Logger LOG = LoggerFactory.getLogger(WebSocketConfig.class);

    @NotEmpty
    private String endPoint;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(endPoint).setAllowedOrigins("*").withSockJS();
    }

    //没有使用到 目前对用户登录态支持并不好
//    public class LoginHandshakeHandler extends DefaultHandshakeHandler {
//
//        @Override
//        protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler,
//                                          Map<String, Object> attributes) {
//
//            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
//            String openId = CookieUtils.getCookieValue(servletRequest.getServletRequest(), WechatConsts.COOKIE_OPENID);
//            String userId = CookieUtils.getCookieValue(servletRequest.getServletRequest(),WechatConsts.COOKIE_USERID);
//            String sessionKey = CookieUtils.getCookieValue(servletRequest.getServletRequest(),WechatConsts.COOKIE_SESSION_KEY);
//            LOG.info("LoginHandshakeHandler beforeHandshake openId " + openId + " userId " + userId + " sessionKey " + sessionKey + "request.getPrincipal() " + request.getPrincipal());
//            try {
//                LoginUserUtil.validate(openId,userId,sessionKey);
//            } catch (BaseException e) {
//                LOG.error("LoginHandshakeHandler error",e);
//                return null;
//            }
//
//
//            return request.getPrincipal();
//        }
//    }

    //没有必要在这里使用前缀
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker(messageBrokerPrefixes);
//        config.setApplicationDestinationPrefixes(appDestinationPrefixes);
//    }






    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }



}