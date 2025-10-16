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
    void testGenerateDiscount_NullProdcut() {
        assertEquals(BigDecimal.ZERO, discountSerice.generateDiscount(null));

    }

    @Test
    void testGenearateDiscount_ElectroincsDiscountEligibility() {
        ProductDetails product = new ProductDetails(1,"laptop", Constants.ELECTRONICS, new BigDecimal("90000"));
        assertEquals(new BigDecimal(9000), discountSerice.generateDiscount(product));
    }

    @Test
    void testGenearateDiscount_Grocerybulk() {
        ProductDetails product = new ProductDetails(10,"groceries", Constants.GROCERY, new BigDecimal("10000"));
        assertEquals(new BigDecimal(5000), discountSerice.generateDiscount(product));
    }
}
