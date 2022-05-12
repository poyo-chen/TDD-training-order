package com.tadevan.tdd.controller;

import com.tadevan.tdd.repo.CommodityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommodityController {

    private final CommodityMapper commodityMapper;

    @GetMapping("commodities")
    public List<CommodityDto> getAllCommodities() {
        return commodityMapper.selectAllCommodities();
    }

    @PostMapping("order")
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto) {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
