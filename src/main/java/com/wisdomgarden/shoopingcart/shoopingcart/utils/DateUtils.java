package com.wisdomgarden.shoopingcart.shoopingcart.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DateUtils {

    public final static String DEFAULT_TIME_PATTERN = "yyyy.MM.dd";

    /***
     * description: 判断前者的时间是否在后者时间之前
     * @author wei.zhang
     * @date 2020/10/24 16:41
     */
    public static boolean isBefore(Date oneTime, Date otherTime){
        Assert.notNull(oneTime, "the firsttime must is not null");
        Assert.notNull(otherTime, "the secondtime must is not null");

        return oneTime.before(otherTime);
    }

    public static boolean isAfter(Date oneTime, Date otherTime){
        Assert.notNull(oneTime, "the firsttime must is not null");
        Assert.notNull(otherTime, "the secondtime must is not null");

        return otherTime.before(oneTime);
    }


    /***
     * description: 根据指定格式转换成Date对象
     * @author wei.zhang
     * @date 2020/10/24 16:55
     */
    public static Date getTimeOfPattern(String time, String pattern){
        Assert.hasText(time, "time must is not empty");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            return simpleDateFormat.parse(time);
        } catch (ParseException e) {
            log.error("时间转换异常，错误信息为：{}", JsonUtils.bean2json(e.getMessage()));
        }
        return null;
    }
}
