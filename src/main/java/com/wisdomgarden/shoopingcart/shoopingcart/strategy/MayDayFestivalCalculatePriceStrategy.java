package com.wisdomgarden.shoopingcart.shoopingcart.strategy;
import com.wisdomgarden.shoopingcart.shoopingcart.entity.Cart;
import com.wisdomgarden.shoopingcart.shoopingcart.utils.FestivalUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MayDayFestivalCalculatePriceStrategy extends AbstractFestivalCalculatePriceStrategy {
    @Override
    public Double calculatePrice(Cart cart) {
        return null;
    }

    /***
     * description: 根据当前时间判断是否是五一节
     * @author wei.zhang
     * @date 2020/10/24 13:33
     */
    @Override
    public boolean support() {
        return FestivalUtils.isMayDay(new Date());
    }
}
