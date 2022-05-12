package com.tadevan.tdd.core.usecase;

import com.tadevan.tdd.controller.OrderDto;
import com.tadevan.tdd.core.outgoing.CommodityRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CreateOrderUsecaseTest {

    @Mock
    CommodityRepo commodityRepo;

    @InjectMocks
    CreateOrderUsecase usecase;


    @Test
    public void test_status_receivable() {
        //given
        OrderDto data = new OrderDto();
        data.setAmount(0);

        //when
        usecase.execute(data);

        //then
        Assertions.assertEquals("receivable", data.getStatus());

    }

    @Test
    public void test_total_less_499() {
        //given
        int totalPrice = 480;
        int targetPrice = totalPrice + 50;
        OrderDto data = new OrderDto();
        data.setAmount(totalPrice);

        //when
        usecase.execute(data);

        //then
        assertEquals(targetPrice, data.getAmount());
    }

    @Test
    public void test_total_over_499() {
        //given
        int totalPrice = 530;
        OrderDto data = new OrderDto();
        data.setAmount(totalPrice);

        //when
        usecase.execute(data);

        //then
        assertEquals(totalPrice, data.getAmount());

    }

    @Test
    public void test_no_amount_should_throw_exception() {
        //given
        final OrderDto data = new OrderDto();

        //when
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> usecase.execute(data));

        //then
        assertEquals("No amount", exception.getMessage());
    }

    @Test
    public void test_should_save() {
        //given
        int totalPrice = 530;
        OrderDto data = new OrderDto();
        data.setAmount(totalPrice);

        //when
        usecase.execute(data);

        //then
    }

}
