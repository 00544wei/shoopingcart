package com.wisdomgarden.shoopingcart.shoopingcart.entity;

import com.wisdomgarden.shoopingcart.shoopingcart.enums.CommodityEnum;
import com.wisdomgarden.shoopingcart.shoopingcart.enums.ProductCategoryEnum;
import lombok.Data;

import java.math.BigInteger;

/**
 * @author: wei.zhang
 * @date 2020/10/23-16:25
 * @description: 商品实体类
 */
@Data
public class Commodity {

    /**
     * 商品ID
     */
    private BigInteger id;

    /**
     * 商品类型
     */
    private CommodityEnum commodityType;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品所属类型
     */
    private ProductCategoryEnum productCategoryType;

    /**
     * 商品单价
     */
    private Double price;

    /**
     * 商品的数量
     */
    private Integer count;
}
