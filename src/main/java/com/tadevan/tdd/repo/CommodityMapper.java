package com.tadevan.tdd.repo;

import com.tadevan.tdd.controller.CommodityDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface CommodityMapper {
    @Select("Select * from commodities")
    List<CommodityDto> selectAllCommodities();
}
