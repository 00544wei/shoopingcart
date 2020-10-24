package com.wisdomgarden.shoopingcart.shoopingcart.strategy;

import com.wisdomgarden.shoopingcart.shoopingcart.entity.Cart;

/***
 * description: 计算价格的的策略接口 不同的节日走不同的计算逻辑
 * @author wei.zhang
 * @date 2020/10/24 13:23
 */
public interface FestivalCalculatePriceStrategy {

    /***
     * description: 计算价格的接口
     * @author wei.zhang
     * @date 2020/10/24 13:25
     */
    Double calculatePrice(Cart cart);

    /***
     * description: 判断是否需要走当前策略
     * @author wei.zhang
     * @date 2020/10/24 13:26
     */
    boolean support();
}
