package com.example.pressuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pressresource.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM Users WHERE nickname = #{nickname}")
    User findByUsername(@Param("nickname") String nickname);
}