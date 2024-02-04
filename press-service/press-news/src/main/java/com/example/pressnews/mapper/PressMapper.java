package com.example.pressnews.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pressresource.entity.Advertisement;
import com.example.pressresource.entity.Press;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PressMapper extends BaseMapper<Press> {
    @Select("SELECT * FROM News WHERE newsid = #{newsid}")
    @Results({
            @Result(property = "newsid", column = "newsid", id = true),
            @Result(property = "title", column = "title"),
            @Result(property = "body", column = "body"),
            @Result(property = "advertisements", column = "newsid",
                    many = @Many(select = "selectAdvertisementsForPress"))
    })
    Press selectPressWithAdvertisements(Long newsid);

    @Select("SELECT * FROM News")
    @Results({
            @Result(property = "newsid", column = "newsid", id = true),
            @Result(property = "title", column = "title"),
            @Result(property = "body", column = "body"),
            @Result(property = "advertisements", column = "newsid",
                    many = @Many(select = "selectAdvertisementsForPress"))
    })
    List<Press> selectAllPressWithAdvertisements();

    @Select("SELECT * FROM Advertisements WHERE newsid = #{newsid}")
    List<Advertisement> selectAdvertisementsForPress(Long newsid);


}
