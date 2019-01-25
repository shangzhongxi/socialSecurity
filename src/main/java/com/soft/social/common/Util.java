package com.soft.social.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 工具类
 */
public class Util {

    /**
     * 获取当前日期
     * @return String
     */
    public static String nowDate (){
        Date utilDate = new Date();//uilt.Date
        System.out.println("utilDate : " + utilDate);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return format.format(utilDate);
    }


}
