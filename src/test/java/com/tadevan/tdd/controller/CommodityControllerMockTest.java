package com.tadevan.tdd.controller;

import com.tadevan.tdd.repo.CommodityMapper;
import org.assertj.core.util.Lists;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ExtendWith({SpringExtension.class})
@WebMvcTest(controllers = CommodityController.class)
public class CommodityControllerMockTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    CommodityMapper commodityRepo;

    @Test
    void test_get_all_commodities() throws Exception {
        //arrange
        when(commodityRepo.selectAllCommodities())
                .thenReturn(Lists.newArrayList(new CommodityDto(), new CommodityDto()));
        //
        mockMvc.perform(MockMvcRequestBuilders.get(
                        "/commodities", List.class))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", Matchers.hasSize(2)));
    }

    @Test
    void test_create_order() throws Exception {
        //arrange
        OrderDto orderDto = new OrderDto(3, 499, "receivable");
        //act
        mockMvc.perform(MockMvcRequestBuilders.post(
                        "/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

}
