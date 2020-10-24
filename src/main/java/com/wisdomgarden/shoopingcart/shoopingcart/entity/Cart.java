package com.wisdomgarden.shoopingcart.shoopingcart.entity;

import com.wisdomgarden.shoopingcart.shoopingcart.utils.DoubleUtils;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

/**
 * @author: wei.zhang
 * @date 2020/10/23-17:14
 * @description: 购物车
 */
@Data
public class Cart {

    /**
     * 促销信息
     */
    private List<Promotion> promotionList;

    /**
     * 商品列表
     */
    private List<Commodity> commodityList;

    /**
     * 结算日期
     */
    private String balanceDate;

    /**
     * 优惠券信息
     */
    private DiscountCoupon discountCoupon;

    /**
     * 所有商品价格
     */
    private Double totalAmount;

    private String totalAmountValue;

    /***
     * description: 算出购物清单里面没有打折前的总价格
     * @author wei.zhang
     * @date 2020/10/24 13:58
     */
    public void buildTotalAmount() {
        if (!CollectionUtils.isEmpty(this.commodityList)){
            for (Commodity item : this.commodityList) {
                Integer count = Optional.ofNullable(item.getCount()).orElse(0);
                Double price = Optional.ofNullable(item.getPrice()).orElse(0D);
                this.totalAmount = DoubleUtils.add(Optional.ofNullable(this.totalAmount).orElse(0D), count * price);
            }
        }
    }
}
