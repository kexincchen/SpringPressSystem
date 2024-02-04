package com.example.pressad.mapper;

import com.example.pressresource.entity.Advertisement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdvertisementMapper extends BaseMapper<Advertisement> {

    @Select("SELECT * FROM Advertisements WHERE placement = #{placement}")
    List<Advertisement> selectByPlacement(String placement);
}

