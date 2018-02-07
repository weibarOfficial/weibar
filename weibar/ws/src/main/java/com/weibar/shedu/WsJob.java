package com.weibar.shedu;

import com.weibar.controller.TestWebsocketController;
import com.weibar.pojo.db.WeibarWsCache;
import com.weibar.service.function.WsCacheService;
import com.weibar.service.mapper.WeibarWsCacheMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/29.
 * websocket job
 */
@Component
public class WsJob {

    @Autowired
    private SimpMessagingTemplate wsTemplate;
    @Autowired
    private WsCacheService wsCacheService;

    private static final Logger LOG = LoggerFactory.getLogger(WsJob.class);

    public final static long ONE_SECOND =   1000;
    public final static long HALF_ONE_SECOND =   500;

    @Scheduled(fixedDelay=HALF_ONE_SECOND)
    public void sendWsJob(){
        long now = System.currentTimeMillis();
        List<WeibarWsCache> cacheList =  wsCacheService.getCacheWs();
        List<Long> ids = new ArrayList<>();
        for(WeibarWsCache weibarWsCache : cacheList){
            wsTemplate.convertAndSend(weibarWsCache.getSubUrl(),weibarWsCache.getRes());
            ids.add(weibarWsCache.getId());
        }
        wsCacheService.deleteWsCache(ids);
        LOG.info("sendWsJob cost time " + (System.currentTimeMillis() - now)/1000.0 + " seconds. send " + cacheList.size() + " messages");
    }


}
