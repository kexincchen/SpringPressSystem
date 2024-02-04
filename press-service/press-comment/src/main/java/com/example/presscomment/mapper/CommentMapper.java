package com.example.presscomment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pressresource.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}