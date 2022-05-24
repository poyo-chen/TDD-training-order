package com.tadevan.tdd.product;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateProductUsecaseTest {


    private CreateProductUsecase createProductUsecase=new CreateProductUsecase();

    /**
     *  []1. product info has been created
     *  []2. product status should be onSale
     */
    @Test
    public void testCreateProductInfo(){




        Assertions.assertTrue(createProductUsecase.create(productInfo));
    }
}
