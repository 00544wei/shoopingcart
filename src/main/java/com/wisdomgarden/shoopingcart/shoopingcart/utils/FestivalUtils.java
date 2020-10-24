package com.wisdomgarden.shoopingcart.shoopingcart.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: wei.zhang
 * @date 2020/10/23-17:36
 * @description: 节日工具类
 */
@Slf4j
public class FestivalUtils {

    private final static String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    private static Date MAY_DAY = null;

    /**
     * @author: wei.zhang
     * @date 2020/10/23
     * @description: 是否是五一
     */
    public static boolean isMayDay(Date time){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 4);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date curTime = getDateOfYYYYMMDD(time);
        return calendar.getTime().equals(curTime);
    }

    /**
     * @author: wei.zhang
     * @date 2020/10/23
     * @description: 获取只保留年 月  日的时间
     */
    private static Date getDateOfYYYYMMDD(Date time) {
        Assert.notNull(time, "time must is not null");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
        String format = simpleDateFormat.format(time);
        try {
            return simpleDateFormat.parse(format);
        } catch (ParseException e) {
            log.error("时间解析异常： {}", JsonUtils.bean2json(e.getMessage()));
        }
        return null;
    }

    /**
     * @author: wei.zhang
     * @date 2020/10/23
     * @description: 是否是双十一
     */
    public static boolean isDoubleEleven(Date time){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 10);
        calendar.set(Calendar.DAY_OF_MONTH, 11);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date curTime = getDateOfYYYYMMDD(time);
        return calendar.getTime().equals(curTime);
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 10);
        calendar.set(Calendar.DAY_OF_MONTH, 11);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(isDoubleEleven(calendar.getTime()));
    }
}
