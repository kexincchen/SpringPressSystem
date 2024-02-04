package com.example.presscomment.controller;

import com.example.presscomment.service.CommentService;
import com.example.pressresource.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/all")
    public ResponseEntity<String> getAllComments() {
        List<Comment> comments = commentService.getAllComments();
        System.out.println(comments);
        return ResponseEntity.ok(comments.toString());
    }

    @PostMapping("/add")
    public ResponseEntity<String> insertNewComment(@RequestParam String content, @RequestParam Long newsID, @RequestParam Long userID) {
        Comment comment = commentService.insertNewComment(content, newsID, userID);
        return ResponseEntity.status(HttpStatus.CREATED).body("Comment added successfully. \nID: " + comment.getCommentid());
    }

    @PostMapping("/reply/{cid}")
    public ResponseEntity<String> replyToComment(@PathVariable Long cid, @RequestParam String content, @RequestParam Long newsID, @RequestParam Long userID) {
        Comment comment = commentService.replyToComment(cid, content, newsID, userID);
        return ResponseEntity.status(HttpStatus.CREATED).body("Comment replied successfully. \nID: " + comment.getCommentid());
    }

    @DeleteMapping("/{cid}")
    public ResponseEntity<String> deleteCommentByID(@PathVariable Long cid) {
        commentService.deleteCommentByID(cid);
        return ResponseEntity.ok("Comment deleted successfully");
    }

    @PutMapping("/{cid}/like")
    public ResponseEntity<String> likeCommentByID(@PathVariable Long cid){
        commentService.likeCommentByID(cid);
        return ResponseEntity.ok("Comment liked successfully");
    }

    @PutMapping("/{cid}/dislike")
    public ResponseEntity<String> dislikeCommentByID(@PathVariable Long cid){
        commentService.dislikeCommentByID(cid);
        return ResponseEntity.ok("Comment liked successfully");
    }
}

