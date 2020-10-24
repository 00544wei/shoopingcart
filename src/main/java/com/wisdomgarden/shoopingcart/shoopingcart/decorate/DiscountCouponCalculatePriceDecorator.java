package com.wisdomgarden.shoopingcart.shoopingcart.decorate;

import com.wisdomgarden.shoopingcart.shoopingcart.entity.Cart;
import com.wisdomgarden.shoopingcart.shoopingcart.entity.Commodity;
import com.wisdomgarden.shoopingcart.shoopingcart.entity.DiscountCoupon;
import com.wisdomgarden.shoopingcart.shoopingcart.utils.DateUtils;
import com.wisdomgarden.shoopingcart.shoopingcart.utils.DoubleUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/***
 * description: 优惠券优惠装饰器
 * @author wei.zhang
 * @date 2020/10/24 13:38
 */
@Component
public class DiscountCouponCalculatePriceDecorator extends CalculatePriceDecoratorAdapter {

    @Override
    public void calculatePrice(Cart cart) {
        Double totalAmount = cart.getTotalAmount();
        String balanceDate = cart.getBalanceDate();
        DiscountCoupon discountCoupon = cart.getDiscountCoupon();
        List<Commodity> commodityList = cart.getCommodityList();
        List<Commodity> newCommodityList = new ArrayList<>();
        newCommodityList.addAll(commodityList);
        // 如果购物车为空 则直接返回
        if (CollectionUtils.isEmpty(newCommodityList)){
            return;
        }
        // 如果有优惠券 进行优惠
        if (!Objects.isNull(discountCoupon)){
            // 如果优惠券预期 则直接返回
            String endTime = discountCoupon.getEndTime();
            Double moreThanAmount = discountCoupon.getMoreThanAmount();
            Double decreaseAmount = discountCoupon.getDecreaseAmount();
            if (isOverdue(balanceDate, endTime)){
                return;
            }
            // 如果商品总金额没有达到优惠券的优惠价格，则直接返回
            if (Double.compare(moreThanAmount, totalAmount) > 0){
                return;
            }

            Double subtractAmount = DoubleUtils.subtract(totalAmount, decreaseAmount);

            cart.setTotalAmount(subtractAmount);

        }
    }

    /***
     * description: 判断是否过期
     * @author wei.zhang
     * @date 2020/10/24 16:57
     */
    private boolean isOverdue(String balanceDate, String endTime) {
        Date blanceTime = DateUtils.getTimeOfPattern(balanceDate, DateUtils.DEFAULT_TIME_PATTERN);
        Date endDate = DateUtils.getTimeOfPattern(endTime, DateUtils.DEFAULT_TIME_PATTERN);

        return DateUtils.isAfter(blanceTime, endDate);
    }
}
