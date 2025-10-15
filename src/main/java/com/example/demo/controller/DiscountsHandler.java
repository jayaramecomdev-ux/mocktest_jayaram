package com.example.demo.controller;

import com.example.demo.model.DiscountedProduct;
import com.example.demo.model.FinalResponse;
import com.example.demo.model.ProductDetails;
import com.example.demo.model.ProductList;
import com.example.demo.service.DiscountSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DiscountsHandler {

    @Autowired
    DiscountSerice discountService;

    @PostMapping("/products/discount")
    public ResponseEntity<FinalResponse> handleDiscount(@RequestBody ProductList productList) {

             List<DiscountedProduct> discountedProductList = productList.getProducts().stream()
                .map(productItem -> new DiscountedProduct(
                        productItem.getId(),
                        productItem.getName(),
                        discountService.generateFinalPrice(productItem),
                        discountService.generateDiscount(productItem))).collect(Collectors.toList());
              FinalResponse finalResponse = new FinalResponse();
              finalResponse.setDiscountedProducts(discountedProductList);

              BigDecimal totalPrice =  discountedProductList.stream()
                .map(DiscountedProduct::getFinalPrice)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
              finalResponse.setFinalBill(totalPrice);

              BigDecimal totalSavings =  discountedProductList.stream()
                .map(DiscountedProduct::getSavings)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
              finalResponse.setTotalSavings(totalSavings);

               return new ResponseEntity<>(finalResponse, HttpStatus.OK);
    }
}
