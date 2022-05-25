package com.tadevan.tdd.product;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateProductUsecase {

    private final ProductRepo productRepo;

    public ProductCommand create(ProductDto productDto) {
        ProductCommand productCommand = new ProductCommand();
        productCommand.setStatus("onSale");
        productRepo.save(productCommand);
        return productCommand;
    }

}
