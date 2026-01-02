package com.samalss.iam_service.controller;

import com.samalss.iam_service.service.CommentService;
import com.samalss.iam_service.service.Impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private CommentService commentService;

    @Autowired
    public void setCommentService(CommentServiceImpl commentService) {
        this.commentService=commentService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createComment(@RequestBody Map<String, Object> requestBody){
        String content = (String)  requestBody.get("content");
        commentService.createComment(content);

        return new ResponseEntity<>("Comment added " + content, HttpStatus.OK);
    }

}
