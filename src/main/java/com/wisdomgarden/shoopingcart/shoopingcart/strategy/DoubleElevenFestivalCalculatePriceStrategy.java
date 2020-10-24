package com.wisdomgarden.shoopingcart.shoopingcart.strategy;

import com.wisdomgarden.shoopingcart.shoopingcart.entity.Cart;
import com.wisdomgarden.shoopingcart.shoopingcart.entity.Commodity;
import com.wisdomgarden.shoopingcart.shoopingcart.enums.ProductCategoryEnum;
import com.wisdomgarden.shoopingcart.shoopingcart.utils.FestivalUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/***
 * description: 双十一优惠策略
 * @author wei.zhang
 * @date 2020/10/24 13:36
 */
@Component
public class DoubleElevenFestivalCalculatePriceStrategy extends AbstractFestivalCalculatePriceStrategy {
    @Override
    public Double calculatePrice(Cart cart) {
        List<Commodity> commodities = cart.getCommodityList();
        if (!CollectionUtils.isEmpty(commodities)){
            List<Commodity> eletricalCommodites = commodities.stream()
                    .filter(p -> Objects.equals(p.getProductCategoryType(), ProductCategoryEnum.ELETRICAL_PRODUCT))
                    .collect(Collectors.toList());

        }
        return null;
    }

    /***
     * description: 分局当前时间判断是否是双十一
     * @author wei.zhang
     * @date 2020/10/24 13:35
     */
    @Override
    public boolean support() {
        return FestivalUtils.isDoubleEleven(new Date());
    }
}
