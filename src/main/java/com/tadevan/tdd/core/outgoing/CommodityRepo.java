package com.tadevan.tdd.core.outgoing;

import com.tadevan.tdd.controller.OrderDto;

public interface CommodityRepo {

    void save(OrderDto data);
}
