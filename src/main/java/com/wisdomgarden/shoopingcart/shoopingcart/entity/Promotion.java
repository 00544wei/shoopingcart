package com.wisdomgarden.shoopingcart.shoopingcart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: wei.zhang
 * @date 2020/10/23-17:01
 * @description: 促销信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promotion {

    /**
     * 促销时间
     */
    private String time;

    /**
     * 折扣
     */
    private String discount;

    /**
     * 商品所属分类描述
     */
    private String productCategoryValue;

    /**
     * 商品所属分类
     */
    private Integer productCategoryType;
}
