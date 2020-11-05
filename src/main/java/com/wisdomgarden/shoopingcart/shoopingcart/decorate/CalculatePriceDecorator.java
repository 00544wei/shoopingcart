package com.wisdomgarden.shoopingcart.shoopingcart.decorate;

import com.wisdomgarden.shoopingcart.shoopingcart.entity.Cart;
import com.wisdomgarden.shoopingcart.shoopingcart.service.CartService;

/***
 * description: 计算价格的装饰器接口
 * @author wei.zhang
 * @date 2020/10/24 12:58
 */
public interface CalculatePriceDecorator {

    /***
     * description: 就散购物车所有商品的价格
     * @author wei.zhang
     * @date 2020/10/24 13:07
     */
    void calculatePrice(Cart cart);
}
