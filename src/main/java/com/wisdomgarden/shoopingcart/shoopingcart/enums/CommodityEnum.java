package com.wisdomgarden.shoopingcart.shoopingcart.enums;

/**
 * @author: wei.zhang
 * @date 2020/10/23-16:27
 * @description: 商品所属类型
 */
public enum CommodityEnum implements IBizEnum {
    // 电子类商品
    IPAD(1, "ipad", ProductCategoryEnum.ELETRICAL_PRODUCT),
    IPHONE(2, "iphone", ProductCategoryEnum.ELETRICAL_PRODUCT),
    SCREEN(3, "显示器", ProductCategoryEnum.ELETRICAL_PRODUCT),
    PERSON_COMPUTER(4, "笔记本电脑", ProductCategoryEnum.ELETRICAL_PRODUCT),
    KEY_BOARD(5, "键盘", ProductCategoryEnum.ELETRICAL_PRODUCT),

    // 食品类商品
    BREAD(6, "面包", ProductCategoryEnum.FOOD_PRODUCT),
    COOKIE(7, "饼干", ProductCategoryEnum.FOOD_PRODUCT),
    CAKE(8, "蛋糕", ProductCategoryEnum.FOOD_PRODUCT),
    BEEF(9, "牛肉", ProductCategoryEnum.FOOD_PRODUCT),
    FISH(10, "鱼", ProductCategoryEnum.FOOD_PRODUCT),
    VEGETABLES(11, "蔬菜", ProductCategoryEnum.FOOD_PRODUCT),

    // 日用品商品
    NAPKIN(12, "餐巾纸", ProductCategoryEnum.DAILY_NECESSITIES_PRODUCT),
    STORAGE_BOX(13, "收纳箱", ProductCategoryEnum.DAILY_NECESSITIES_PRODUCT),
    COFFEE_CUP(14, "咖啡杯", ProductCategoryEnum.DAILY_NECESSITIES_PRODUCT),
    UMBRELLA(15, "雨伞", ProductCategoryEnum.DAILY_NECESSITIES_PRODUCT),

    // 酒类
    BEER(16, "啤酒", ProductCategoryEnum.WINE_PRODUCT),
    WHITE_WINE(17, "白酒", ProductCategoryEnum.WINE_PRODUCT),
    VODKA(18, "伏特加", ProductCategoryEnum.WINE_PRODUCT),
    ;

    private Integer value;

    private String description;

    private ProductCategoryEnum productCategoryEnum;

    CommodityEnum(Integer value, String description, ProductCategoryEnum productCategoryEnum) {
        this.value = value;
        this.description = description;
        this.productCategoryEnum = productCategoryEnum;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    public ProductCategoryEnum getProductCategoryEnum() {
        return productCategoryEnum;
    }
}
