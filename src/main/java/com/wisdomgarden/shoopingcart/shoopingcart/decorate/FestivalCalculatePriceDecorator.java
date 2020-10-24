package com.wisdomgarden.shoopingcart.shoopingcart.decorate;

import com.wisdomgarden.shoopingcart.shoopingcart.entity.Cart;
import com.wisdomgarden.shoopingcart.shoopingcart.strategy.FestivalCalculatePriceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/***
 * description: 关于节日的价格计算装饰器
 * @author wei.zhang
 * @date 2020/10/24 13:19
 */
@Component
public class FestivalCalculatePriceDecorator extends CalculatePriceDecoratorAdapter {

    // 所有的节日优惠策略
    @Autowired
    private List<FestivalCalculatePriceStrategy> festivalCalculatePriceStrategyList;

    @Override
    public void calculatePrice(Cart cart) {
        if (!CollectionUtils.isEmpty(festivalCalculatePriceStrategyList)){
            for (FestivalCalculatePriceStrategy item : festivalCalculatePriceStrategyList) {
                if (item.support()){
                    item.calculatePrice(cart);
                }
            }
        }
    }
}
