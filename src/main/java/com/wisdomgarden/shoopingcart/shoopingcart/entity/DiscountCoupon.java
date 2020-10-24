package com.wisdomgarden.shoopingcart.shoopingcart.entity;

import lombok.Data;

/**
 * @author: wei.zhang
 * @date 2020/10/23-17:02
 * @description: 优惠券信息
 */
@Data
public class DiscountCoupon {

    /**
     * 到期时间
     */
    private String endTime;

    /**
     * 优惠券信息
     */
    private String description;

    /**
     * 需要达到的金额
     */
    private Double moreThanAmount;

    /**
     * 减少的金额
     */
    private Double decreaseAmount;
}
