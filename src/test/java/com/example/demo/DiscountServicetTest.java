package com.example.demo;

import com.example.demo.config.Constants;
import com.example.demo.model.ProductDetails;
import com.example.demo.service.DiscountSerice;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountServicetTest {
    private final DiscountSerice discountSerice = new DiscountSerice();

    @Test
    void testGenerateSavings_NullProduct() {
        assertEquals(BigDecimal.ZERO, discountSerice.generateDiscount(null));

    }

    @Test
    void testGenearateSavings_ElectroincsDiscountEligibility() {
        ProductDetails product = new ProductDetails(1,"laptop", Constants.ELECTRONICS, new BigDecimal("90000"));
        assertEquals(0, discountSerice.generateDiscount(product).compareTo(new BigDecimal("9000")));

    }

    @Test
    void testGenearateSavings_Grocerybulk() {
        ProductDetails product = new ProductDetails(10,"groceries", Constants.GROCERY, new BigDecimal("10000"));
        assertEquals(0, discountSerice.generateDiscount(product).compareTo(new BigDecimal("5000")));
    }

    @Test
    void testGenerateSavings_ClothingBuy2Get1() {
        ProductDetails product = new ProductDetails(9,"Dress", Constants.CLOTHING, new BigDecimal("1000"));
        assertEquals(0, discountSerice.generateDiscount(product).compareTo(new BigDecimal("3000")));
    }

    @Test
    void testGenerateSavings_InEligibilityOnQuantity() {
        ProductDetails product = new ProductDetails(2,"Dress", Constants.CLOTHING, new BigDecimal("1000"));
        assertEquals(BigDecimal.ZERO, discountSerice.generateDiscount(product));
    }

    @Test
    void testGenerateFinalPrice_NullProduct() {
        assertEquals(BigDecimal.ZERO, discountSerice.generateFinalPrice(null));

    }

    @Test
    void testGenearateFinalPrice_ElectroincsDiscountEligible() {
        ProductDetails product = new ProductDetails(1,"laptop", Constants.ELECTRONICS, new BigDecimal("90000"));
        assertEquals(0, discountSerice.generateFinalPrice(product).compareTo(new BigDecimal("81000")));
    }

    @Test
    void testGenearateFinalPrice_Grocerybulk() {
        ProductDetails product = new ProductDetails(10,"groceries", Constants.GROCERY, new BigDecimal("10000"));
        assertEquals(0, discountSerice.generateFinalPrice(product).compareTo(new BigDecimal("95000")));
    }

    @Test
    void testGenerateFinalPrice_ClothingBuy2Get1() {
        ProductDetails product = new ProductDetails(9,"Dress", Constants.CLOTHING, new BigDecimal("1000"));
        assertEquals(0, discountSerice.generateFinalPrice(product).compareTo(new BigDecimal("6000")));
    }

    @Test
    void testGenerateFinalPrice_InEligibilityOnQuantity() {
        ProductDetails product = new ProductDetails(2,"Dress", Constants.CLOTHING, new BigDecimal("1000"));
        assertEquals(0, discountSerice.generateFinalPrice(product).compareTo(new BigDecimal("2000")));
    }

}
