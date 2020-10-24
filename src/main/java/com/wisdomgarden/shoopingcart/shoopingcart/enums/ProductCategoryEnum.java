package com.wisdomgarden.shoopingcart.shoopingcart.enums;

/**
 * @author: wei.zhang
 * @date 2020/10/23-16:17
 * @description: 商品所属分类
 */
public enum  ProductCategoryEnum implements IBizEnum {
    ELETRICAL_PRODUCT(1, "电子"),
    FOOD_PRODUCT(2, "食品"),
    DAILY_NECESSITIES_PRODUCT(3, "日用品"),
    WINE_PRODUCT(4, "酒类"),
    ;

    private Integer value;

    private String description;

    ProductCategoryEnum(Integer value, String description){
        this.value = value;
        this.description = description;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
