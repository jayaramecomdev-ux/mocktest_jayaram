package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductDetails {

    private int id;
    private String name;
    private String category;
    private BigDecimal price;
    private int quantity;

}
