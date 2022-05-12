package com.tadevan.tdd.core.usecase;

import com.tadevan.tdd.controller.OrderDto;
import com.tadevan.tdd.core.outgoing.CommodityRepo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateOrderUsecase {

    private final CommodityRepo commodityRepo;

    /**
     * []訂單狀態為代收款
     * []透過restful API通知帳務服務
     * []若訂單超過499免運，否則加收50
     *
     * @param data 訂單資料
     */
    public void execute(OrderDto data) {
        data.setStatus("receivable");

        if (data.getAmount() == null) {
            throw new RuntimeException("No amount");
        }

        if (data.getAmount() < 499) {
            data.setAmount(data.getAmount() + 50);
        }

        commodityRepo.save(data);
    }
}
