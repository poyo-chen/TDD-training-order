package com.tadevan.tdd.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @PostMapping("/createProduct")
    public ResponseEntity createProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.ok().build();
    }
}
