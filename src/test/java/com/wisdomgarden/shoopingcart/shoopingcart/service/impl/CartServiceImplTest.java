package com.wisdomgarden.shoopingcart.shoopingcart.service.impl;

import com.wisdomgarden.shoopingcart.shoopingcart.entity.Cart;
import com.wisdomgarden.shoopingcart.shoopingcart.entity.Commodity;
import com.wisdomgarden.shoopingcart.shoopingcart.entity.DiscountCoupon;
import com.wisdomgarden.shoopingcart.shoopingcart.entity.Promotion;
import com.wisdomgarden.shoopingcart.shoopingcart.enums.CommodityEnum;
import com.wisdomgarden.shoopingcart.shoopingcart.enums.ProductCategoryEnum;
import com.wisdomgarden.shoopingcart.shoopingcart.service.CartService;
import com.wisdomgarden.shoopingcart.shoopingcart.utils.EnumUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class CartServiceImplTest {

    @Autowired
    private CartServiceImpl cartService;



    /***
     * description: 测试时将文件名变更即可
     * @author wei.zhang
     * @date 2020/10/24 20:02
     */
    @Test
    public void getPrice() throws Exception {
        Cart cart = new Cart();
        List<Promotion> promotionList = new ArrayList<>();
        List<Commodity> commodityList = new ArrayList<>();
        String balanceDate = new String();
        DiscountCoupon discountCoupon = null;

        List<String> lines = new ArrayList<>();
        readFile(lines, "classpath:caseF.txt");
        // 促销信息
        List<String> promotions = lines.subList(0, lines.indexOf(""));
        for (String item : promotions) {
            Promotion newItem = new Promotion();
            String[] splits = item.split("\\|");
            newItem.setTime(splits[0]);
            newItem.setDiscount(splits[1]);
            ProductCategoryEnum productCategoryEnum = EnumUtils.ofDescription(splits[2].trim(), ProductCategoryEnum.class);
            newItem.setProductCategoryType(productCategoryEnum.getValue());
            newItem.setProductCategoryValue(productCategoryEnum.getDescription());
            promotionList.add(newItem);
        }
        // 商品信息
        List<String> commdities = lines.subList(lines.indexOf("") + 1, lines.lastIndexOf(""));
        if (!CollectionUtils.isEmpty(commdities)){
            for (String item : commdities) {
                Commodity newItem = new Commodity();
                String[] splits = item.split("\\s+");
                newItem.setCount(Integer.parseInt(splits[0]));
                CommodityEnum commodityEnum = EnumUtils.ofDescription(splits[2], CommodityEnum.class);
                newItem.setCommodityType(commodityEnum);
                newItem.setProductCategoryType(commodityEnum.getProductCategoryEnum());
                newItem.setPrice(Double.valueOf(splits[4]));
                newItem.setName(commodityEnum.getDescription());
                commodityList.add(newItem);
            }
        }

        // 结算时间  和  优惠券信息
        List<String> blanceAndDiscountInfo = lines.subList(lines.lastIndexOf("") + 1, lines.size());

        if (!CollectionUtils.isEmpty(blanceAndDiscountInfo)){
            if (blanceAndDiscountInfo.size() == 1){
                balanceDate = blanceAndDiscountInfo.get(0).trim();
            }else {
                balanceDate = blanceAndDiscountInfo.get(0).trim();
                String discountInfo = blanceAndDiscountInfo.get(1);
                if (!StringUtils.isEmpty(discountInfo)){
                    discountCoupon = new DiscountCoupon();
                    String[] splits = discountInfo.split("\\s+");
                    discountCoupon.setDescription(discountInfo);
                    discountCoupon.setEndTime(splits[0]);
                    discountCoupon.setMoreThanAmount(Double.valueOf(splits[1]));
                    discountCoupon.setDecreaseAmount(Double.valueOf(splits[2]));
                }
            }
        }

        cart.setPromotionList(promotionList);
        cart.setCommodityList(commodityList);
        cart.setBalanceDate(balanceDate);
        cart.setDiscountCoupon(discountCoupon);

        System.out.println(cartService.getPrice(cart));
    }

    private void readFile(List<String> lines, String filename) throws Exception {
        FileInputStream fis = null;
        BufferedReader br = null;
        try {
            String file = ResourceUtils.getURL(filename).getFile();
            File file1 = new File(file);

            fis = new FileInputStream(file1);
            br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } finally {
            if (fis != null){
                fis.close();
            }
            if (br != null){
                br.close();
            }
        }
    }
}