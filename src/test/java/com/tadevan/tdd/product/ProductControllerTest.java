package com.tadevan.tdd.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateProductInfo() throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setProductName("草莓冰淇淋");
        productDto.setDesc("100ML");
        productDto.setPrice(new BigDecimal(98.25));
        productDto.setUnit("CUP");


        mockMvc.perform(MockMvcRequestBuilders.post("/createProduct")
                        .content(objectMapper.writeValueAsString(productDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}
