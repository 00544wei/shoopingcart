package com.wisdomgarden.shoopingcart.shoopingcart.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.StringWriter;

/**
 * @author: wei.zhang
 * @date 2020/10/23-17:52
 * @description: TODO
 */
@Slf4j
public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String bean2json(Object bean){
        StringWriter sw = new StringWriter();
        try (JsonGenerator gen = new JsonFactory().createGenerator(sw)){
            objectMapper.writeValue(gen, bean);
        } catch (Exception e) {
            log.debug("bean2json转换异常,源类型{{}}异常信息{{}}",bean.getClass().getName(),e.getMessage());
            return null;
        }
        return sw.toString();
    }
}
