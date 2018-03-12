package com.weibar.pojo.result;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2018/2/1.
 */
public class DakaIndexSummary {

    private DakaResultDaySummary todaySummary;
    private DakaResultDaySummary tomorrowSummary;


    public DakaResultDaySummary getTodaySummary() {
        return todaySummary;
    }

    public void setTodaySummary(DakaResultDaySummary todaySummary) {
        this.todaySummary = todaySummary;
    }

    public DakaResultDaySummary getTomorrowSummary() {
        return tomorrowSummary;
    }

    public void setTomorrowSummary(DakaResultDaySummary tomorrowSummary) {
        this.tomorrowSummary = tomorrowSummary;
    }
}
