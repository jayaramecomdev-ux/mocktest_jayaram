package com.example.demo.service;

import com.example.demo.config.Constants;
import com.example.demo.model.ProductDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class DiscountSerice {

    public BigDecimal generateDiscount(ProductDetails productDetails) {

        if (null == productDetails) {
            return BigDecimal.ZERO;
        }

        BigDecimal finalPrice = productDetails.getPrice().multiply(new BigDecimal(productDetails.getQuantity()));

        if(productDetails.getQuantity() <= 0 || productDetails.getPrice().compareTo(BigDecimal.ZERO) <=0 ) {
            return BigDecimal.ZERO;
        }

        if(Constants.ELECTRONICS.equals(productDetails.getCategory())
           && productDetails.getPrice().compareTo(new BigDecimal(20000)) >=0 ) {
            return finalPrice.multiply(new BigDecimal("0.10"));
        }
        if(Constants.GROCERY.equals(productDetails.getCategory())
            && productDetails.getQuantity() >= 10) {
            return finalPrice.multiply(new BigDecimal("0.05"));
        }
        if(Constants.CLOTHING.equals(productDetails.getCategory())
           && productDetails.getQuantity() >=3 ) {
            int freeClothes = productDetails.getQuantity() / 3;
            return productDetails.getPrice().multiply(new BigDecimal(freeClothes));

        }

        return BigDecimal.ZERO;
    }

    public BigDecimal generateFinalPrice(ProductDetails productDetails) {

        if (null == productDetails) {
            return BigDecimal.ZERO;
        }

        BigDecimal discountedPrice = productDetails.getPrice().multiply(new BigDecimal(productDetails.getQuantity()));

        if(productDetails.getQuantity() <= 0 || productDetails.getPrice().compareTo(BigDecimal.ZERO) <=0 ) {
            return discountedPrice;
        }

        if(Constants.ELECTRONICS.equals(productDetails.getCategory())
                && productDetails.getPrice().compareTo(new BigDecimal(20000)) >=0 ) {
           BigDecimal discount = discountedPrice.multiply(new BigDecimal("0.10"));
            discountedPrice = discountedPrice.subtract(discount);
        }
        if(Constants.GROCERY.equals(productDetails.getCategory())
                && productDetails.getQuantity() >= 10) {
            BigDecimal discount = discountedPrice.multiply(new BigDecimal("0.05"));
            discountedPrice = discountedPrice.subtract(discount);
        }
        if(Constants.CLOTHING.equals(productDetails.getCategory())
                && productDetails.getQuantity() >=3 ) {
            int freeClothes = productDetails.getQuantity() / 3;
            BigDecimal discount = productDetails.getPrice().multiply(new BigDecimal(freeClothes));
            discountedPrice = discountedPrice.subtract(discount);
        }

        return discountedPrice;
    }
}