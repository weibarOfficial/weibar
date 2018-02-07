package com.weibar.shedu;


import com.weibar.pojo.db.WeibarRedpackageOrder;
import com.weibar.service.function.WechatRedPackageService;
import com.weibar.service.function.WsCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/12/29.
 * websocket job
 */
@Component
public class WechatRedPackageJob {

    @Autowired
    private WechatRedPackageService wechatRedPackageService;

    private static final Logger LOG = LoggerFactory.getLogger(WechatRedPackageJob.class);

    public final static long ONE_SECOND =   1000;
    public final static long HALF_ONE_SECOND =   500;
    public final static long TEN_SECOND =   10000;


    @Scheduled(fixedDelay=TEN_SECOND)
    public void sendWechatRedPackJob(){
        long now = System.currentTimeMillis();
        List<WeibarRedpackageOrder> list =  wechatRedPackageService.getUnSendRedPackOrders();
        int count = wechatRedPackageService.sendRedPackages(list);
        LOG.info("sendWechatRedPackJob cost time " + (System.currentTimeMillis() - now)/1000.0 +
                " seconds.redPacks size " + list.size() + " send successfully count " + count);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
