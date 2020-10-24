package com.wisdomgarden.shoopingcart.shoopingcart.utils;

import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

public class DoubleUtils {

    private final static Double DEFAULT_VALUE = 0.00D;

    /***
     * description: 计算两个DOUBLE值相乘的值
     * @author wei.zhang
     * @date 2020/10/24 15:23
     */
    public static Double multiply(Double item1, Double item2){
        if (Objects.isNull(item1) || Objects.isNull(item2)){
            return DEFAULT_VALUE;
        }
        return new BigDecimal(item1).setScale(2,   BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal(item2).setScale(2,   BigDecimal.ROUND_HALF_UP)).doubleValue();
    }

    /***
     * description: 计算两个DOUBLE值得差
     * @author wei.zhang
     * @date 2020/10/24 17:25
     */
    public static Double subtract(Double item1, Double item2){
        if (Objects.isNull(item1) || Objects.isNull(item2)){
            return DEFAULT_VALUE;
        }
        return new BigDecimal(item1).setScale(2,   BigDecimal.ROUND_HALF_UP)
                .subtract(new BigDecimal(item2).setScale(2,   BigDecimal.ROUND_HALF_UP)).doubleValue();
    }

    /***
     * description: 计算两个DOUBLE值的和 默认保留两位小数 四舍五入
     * @author wei.zhang
     * @date 2020/10/24 19:33
     */
    public static Double add(Double item1, Double item2){
        if (Objects.isNull(item1) || Objects.isNull(item2)){
            return DEFAULT_VALUE;
        }
        return new BigDecimal(item1).setScale(2,   BigDecimal.ROUND_HALF_UP)
                .add(new BigDecimal(item2).setScale(2,   BigDecimal.ROUND_HALF_UP)).doubleValue();
    }

    /***
     * description: 将一个double值转换成带两位小数的字符串
     * @author wei.zhang
     * @date 2020/10/24 19:54
     */
    public static String transferDouble(Double target){
        Assert.notNull(target, "target must not be null");
        DecimalFormat df = new DecimalFormat(".00");
        return df.format(target);
    }

    public static void main(String[] args) {
        Double item1 = new Double(1);
        Double item2 = new Double(2);
        System.out.println(add(item1, item2));
    }
}
