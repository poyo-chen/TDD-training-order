package com.tadevan.tdd.product;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateProductUsecase {

    private final ProductRepo productRepo;

    public Product create(ProductCommand productCommand) {
        Product product = new Product();
        product.setProductName(productCommand.getProductName());
        product.setPrice(productCommand.getPrice());
        product.setUnit(productCommand.getUnit());
        product.setDesc(productCommand.getDesc());
        product.setStatus("onSale");
        productRepo.save(product);
        return product;
    }

}
