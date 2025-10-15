package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class DiscountedProduct {
    private int id;
    private String name;
    private BigDecimal finalPrice;
    private BigDecimal savings;

    public DiscountedProduct(int id, String name, BigDecimal finalPrice, BigDecimal savings) {
        this.id = id;
        this.name = name;
        this.finalPrice = finalPrice;
        this.savings = savings;
    }
}
