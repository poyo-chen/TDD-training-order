package com.tadevan.tdd.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CommodityControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    CommodityController commodityController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void test_get_all_commodities() {
        //act
        List<CommodityDto> response = restTemplate.getForObject(
                "http://localhost:" + port + "/commodities", List.class
        );

        //assert
        assertSame(2, response.size());
    }

    @Test
    void test_create_order() {
        //arrange
        OrderDto orderDto = new OrderDto();
        HttpEntity<OrderDto> params = new HttpEntity<OrderDto>(orderDto);

        //act
        ResponseEntity<Void> response = restTemplate.exchange(
                "http://localhost:" + port + "/order",
                HttpMethod.POST,
                params,
                Void.class
        );

        //assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
