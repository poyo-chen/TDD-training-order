package com.tadevan.tdd.controller;

import lombok.Data;

@Data
public class CommodityDto {

    private int id;
    private String name;
    private String description;
    private int qty;
    private int price;

}
