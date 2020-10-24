package com.wisdomgarden.shoopingcart.shoopingcart.decorate;

import com.wisdomgarden.shoopingcart.shoopingcart.entity.Cart;
import com.wisdomgarden.shoopingcart.shoopingcart.entity.Commodity;
import com.wisdomgarden.shoopingcart.shoopingcart.entity.Promotion;
import com.wisdomgarden.shoopingcart.shoopingcart.enums.ProductCategoryEnum;
import com.wisdomgarden.shoopingcart.shoopingcart.utils.DateUtils;
import com.wisdomgarden.shoopingcart.shoopingcart.utils.DoubleUtils;
import com.wisdomgarden.shoopingcart.shoopingcart.utils.EnumUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/***
 * description: 默认的打折装饰器
 * @author wei.zhang
 * @date 2020/10/24 14:40
 */
@Component
public class DefaultCalculatePriceDecorator extends CalculatePriceDecoratorAdapter {

    @Override
    public void calculatePrice(Cart cart) {
        Double result = new Double(0);
        // 根据促销信息进行打折 格式为：日期 | 折扣 | 产品分类
        String balanceDate = cart.getBalanceDate();
        List<Commodity> commodityList = cart.getCommodityList();
        List<Commodity> newCommodityList = new ArrayList<>();
        newCommodityList.addAll(commodityList);
        List<Promotion> promotionList = cart.getPromotionList();
        // 如果没有商品 直接返回
        if (CollectionUtils.isEmpty(newCommodityList)){
            return;
        }
        // 如果有促销信息
        if (!CollectionUtils.isEmpty(promotionList)){
            for (Promotion item : promotionList) {
                String discount = item.getDiscount();
                Integer productCategoryType = item.getProductCategoryType();
                ProductCategoryEnum productCategoryEnum = EnumUtils.of(productCategoryType, ProductCategoryEnum.class);
                if (!CollectionUtils.isEmpty(newCommodityList)){
                    List<Commodity> curCategoryCommodities = newCommodityList.stream().filter(p -> Objects.equals(p.getProductCategoryType(), productCategoryEnum))
                            .collect(Collectors.toList());
                    // 如果选购了该类的商品并且结算时间和优惠时间是同一时间 进行优惠处理,并移除商品信息
                    if (!CollectionUtils.isEmpty(curCategoryCommodities) && isTimeEquals(balanceDate, item.getTime())){
                        Double curCategoryTotalAmount = curCategoryCommodities.stream()
                                .map(p -> {
                                    Double singlePrice = Optional.ofNullable(p.getPrice()).orElse(0D);
                                    Integer count = Optional.ofNullable(p.getCount()).orElse(0);
                                    return DoubleUtils.multiply(singlePrice, Double.valueOf(count));
                                })
                                .reduce((a, b) -> DoubleUtils.add(a, b))
                                .orElse(0D);
                        Double curCategoryDiscountAmount = DoubleUtils.multiply(curCategoryTotalAmount, Double.valueOf(discount));
                        result = DoubleUtils.add(result, curCategoryDiscountAmount);
                        newCommodityList.removeAll(curCategoryCommodities);
                    }
                }
            }
        }
        // 计算不需要优惠的商品金额
        if (!CollectionUtils.isEmpty(newCommodityList)){
            Double notDiscountTotalAmount = newCommodityList.stream()
                    .map(p -> {
                        Double singlePrice = Optional.ofNullable(p.getPrice()).orElse(0D);
                        Integer count = Optional.ofNullable(p.getCount()).orElse(0);
                        return DoubleUtils.multiply(singlePrice, Double.valueOf(count));
                    })
                    .reduce((a, b) -> DoubleUtils.add(a, b))
                    .orElse(0D);
            result = DoubleUtils.add(result, notDiscountTotalAmount);
        }

        cart.setTotalAmount(result);
    }

    /***
     * description: 判断结算时间和促销时间是否一样
     * @author wei.zhang
     * @date 2020/10/24 19:13
     */
    private boolean isTimeEquals(String balanceDate, String promotionTime) {

        return Objects.equals(balanceDate.trim(), promotionTime.trim());
    }
}
