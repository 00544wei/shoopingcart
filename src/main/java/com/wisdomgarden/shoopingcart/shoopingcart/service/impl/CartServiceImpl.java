package com.wisdomgarden.shoopingcart.shoopingcart.service.impl;

import com.wisdomgarden.shoopingcart.shoopingcart.decorate.DefaultCalculatePriceDecorator;
import com.wisdomgarden.shoopingcart.shoopingcart.decorate.DiscountCouponCalculatePriceDecorator;
import com.wisdomgarden.shoopingcart.shoopingcart.decorate.FestivalCalculatePriceDecorator;
import com.wisdomgarden.shoopingcart.shoopingcart.entity.Cart;
import com.wisdomgarden.shoopingcart.shoopingcart.service.CartService;
import com.wisdomgarden.shoopingcart.shoopingcart.utils.DoubleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private FestivalCalculatePriceDecorator festivalCalculatePriceDecorator;

    @Autowired
    private DiscountCouponCalculatePriceDecorator discountCouponCalculatePriceDecorator;

    @Autowired
    private DefaultCalculatePriceDecorator defaultCalculatePriceDecorator;

    @Override
    public String getPrice(Cart cart) {
        cart.buildTotalAmount();
        // 促销优惠
        defaultCalculatePriceDecorator.calculatePrice(cart);
        // 优惠券优惠
        discountCouponCalculatePriceDecorator.calculatePrice(cart);

        Double totalAmount = Optional.ofNullable(cart.getTotalAmount()).orElse(0D);
        return DoubleUtils.transferDouble(totalAmount);
    }
}
