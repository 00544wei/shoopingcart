package com.wisdomgarden.shoopingcart.shoopingcart.strategy;

/***
 * description: 当是节假日时，默认节假日没有任何优惠
 * @author wei.zhang
 * @date 2020/10/24 13:30
 */
public abstract class AbstractFestivalCalculatePriceStrategy implements FestivalCalculatePriceStrategy {

    /***
     * description: 默认不走当前策略
     * @author wei.zhang
     * @date 2020/10/24 13:30
     */
    @Override
    public boolean support() {
        return false;
    }
}
