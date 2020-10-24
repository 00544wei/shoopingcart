package com.wisdomgarden.shoopingcart.shoopingcart.service;

import com.wisdomgarden.shoopingcart.shoopingcart.entity.Cart;

/**
 * @author: wei.zhang
 * @date 2020/10/23-16:58
 * @description: 购物车service
 */
public interface CartService {

    /**
     * @description 根据购物车的信息获取需要付的金额
     * @author wei.zhang
     * @date 2020/10/23
     **/
    String getPrice(Cart cart);

}
