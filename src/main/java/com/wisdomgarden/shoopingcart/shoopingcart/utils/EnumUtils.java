package com.wisdomgarden.shoopingcart.shoopingcart.utils;

import com.wisdomgarden.shoopingcart.shoopingcart.enums.IBizEnum;

import java.util.function.Function;

public class EnumUtils {

    /**
     * 从实现了IBizEnum接口的枚举中,获取值对应的枚举类型.找不到返回null
     * @param value
     * @param clazz
     * @return 如果没有匹配到枚举,则返回null
     */
    public static <T extends IBizEnum> T of(Integer value, Class<T> clazz){
        return of(value,clazz,IBizEnum::getValue,null );
    }

    /**
     * 从实现了IBizEnum接口的枚举中,获取特定值对应的枚举类型.找不到返回null
     * @param value
     * @param clazz
     * @param fieldGetter 根据特定值获取对应枚举
     * @return 如果没有匹配到枚举,则返回null
     */
    public static <T extends IBizEnum> T of(Integer value, Class<T> clazz,Function<T,Integer> fieldGetter){
        return of(value,clazz,fieldGetter,null );
    }

    /**
     * 从实现了IBizEnum接口的枚举中,获取值对应的枚举类型.找不到返回null
     * @param value
     * @param clazz
     * @param defaultEnum 如果没有匹配到枚举,则返回该默认值
     * @return
     */
    public static <T extends IBizEnum> T of(Integer value, Class<T> clazz, Function<T,Integer> getter, T defaultEnum){
        if(value == null || clazz == null || getter == null ){
            return defaultEnum;
        }
        IBizEnum[] enumConstants = clazz.getEnumConstants();
        for (IBizEnum enumConstant : enumConstants) {
            Integer enumValue = getter.apply((T) enumConstant);
            if(enumValue != null && enumValue.equals(value)){
                return (T) enumConstant;
            }
        }
        return defaultEnum;
    }


    public static <T extends IBizEnum> T ofDescription(String description, Class<T> clazz){
        return ofDescription(description,clazz,IBizEnum::getDescription,null );
    }

    public static <T extends IBizEnum> T ofDescription(String description, Class<T> clazz,Function<T,String> fieldGetter){
        return ofDescription(description,clazz,fieldGetter,null );
    }


    public static <T extends IBizEnum> T ofDescription(String description, Class<T> clazz, Function<T,String> getter, T defaultEnum){
        if(description == null || clazz == null || getter == null ){
            return defaultEnum;
        }
        IBizEnum[] enumConstants = clazz.getEnumConstants();
        for (IBizEnum enumConstant : enumConstants) {
            String enumValue = getter.apply((T) enumConstant);
            if(enumValue != null && enumValue.equals(description)){
                return (T) enumConstant;
            }
        }
        return defaultEnum;
    }
}
