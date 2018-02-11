package com.weibar.shedu;


import com.weibar.pojo.exception.BaseException;
import com.weibar.service.function.DakaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DakaJob {

    private static final Logger LOG = LoggerFactory.getLogger(DakaJob.class);
    @Autowired
    private DakaService dakaService;

    @Scheduled(cron = "0 1 8 * * ?")
    public void dakaFinishJob(){
        try {
            Date now = new Date();
            dakaService.refreshAndSendDakaMoney(now);
        } catch (BaseException e) {
            LOG.error("refreshAndSendDakaMoney error",e);
        }
    }

}
