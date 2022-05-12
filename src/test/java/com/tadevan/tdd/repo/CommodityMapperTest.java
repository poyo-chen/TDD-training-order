package com.tadevan.tdd.repo;

import com.tadevan.tdd.controller.CommodityDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@MybatisTest
public class CommodityMapperTest {

    @Autowired CommodityMapper commodityMapper;

    @Test
    public void test_select_all_commodities(){
        //act
        List<CommodityDto> resultList=commodityMapper.selectAllCommodities();

        //assert
        Assertions.assertSame(2,resultList.size());
    }
}
