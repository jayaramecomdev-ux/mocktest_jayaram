package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductDetails {

    public ProductDetails(int quantity, String name, String category, BigDecimal price) {
        this.quantity = quantity;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    private int id;
    private String name;
    private String category;
    private BigDecimal price;
    private int quantity;

}
