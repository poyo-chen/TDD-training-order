package com.tadevan.tdd.product;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class CreateProductUsecaseTest {

    private ProductRepo productRepo = Mockito.mock(ProductRepo.class);
    private CreateProductUsecase createProductUsecase = new CreateProductUsecase(productRepo);

    /**
     * [V]1. product info has been created
     * [V]2. product status should be onSale
     */
    @Test
    public void testCreateProductInfo() {

        ProductDto productDto = new ProductDto();
        productDto.setProductName("草莓冰淇淋");
        productDto.setDesc("100ML");
        productDto.setPrice(new BigDecimal(98.25));
        productDto.setUnit("CUP");

        ProductCommand productCommand = createProductUsecase.create(productDto);
        Mockito.verify(productRepo).save(productCommand);
        Assertions.assertEquals(productCommand.getStatus(), "onSale");
    }
}
