package com.tadevan.tdd.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto implements ProductCommand{

    private String productName;
    private String desc;
    private BigDecimal price;
    private String unit;

}
