package com.wisdomgarden.shoopingcart.shoopingcart.enums;

public enum FestivalEnum implements IBizEnum {
    MAY_DAY(1, "五一"),
    DOUBLE_ELEVEN(2, "双十一")
    ;

    private Integer value;

    private String description;

    FestivalEnum(Integer value, String description){
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
