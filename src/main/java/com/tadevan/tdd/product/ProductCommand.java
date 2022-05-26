package com.tadevan.tdd.product;

import java.math.BigDecimal;

public interface ProductCommand {

    String getProductName();

    BigDecimal getPrice();

    String getUnit();

    String getDesc();
}
