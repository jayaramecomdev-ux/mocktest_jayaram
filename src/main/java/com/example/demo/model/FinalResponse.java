package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class FinalResponse {
    private List<DiscountedProduct> discountedProducts;
    private BigDecimal totalSavings;
    private BigDecimal finalBill;
}
