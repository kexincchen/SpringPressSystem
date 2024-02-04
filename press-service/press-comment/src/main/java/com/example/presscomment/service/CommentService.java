package com.example.presscomment.service;

import com.example.pressresource.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComments();

    Comment insertNewComment(String content, Long newsID, Long userID);

    void deleteCommentByID(Long cid);

    void likeCommentByID(Long cid);

    void dislikeCommentByID(Long cid);

    Comment replyToComment(Long cid, String content, Long newsID, Long userID);
}
