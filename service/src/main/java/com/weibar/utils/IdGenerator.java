package com.weibar.utils;

import java.util.Date;
import java.util.Random;

/**
 * Created by nixiaoming on 2017/11/19.
 */
public class IdGenerator {


    public static Long generateIdByTime(){
        Random random = new Random();
        return random.nextInt() % 10000 + System.currentTimeMillis();
    }

    public static String generateIdByTimeStr(){
        return generateIdByTime().toString();
    }
}
