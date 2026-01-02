package com.samalss.iam_service.controller;

import com.samalss.iam_service.service.CommentService;
import com.samalss.iam_service.service.Impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private final CommentService defualtCommentService;
    private final CommentService advancedCommentService;

    public CommentController(CommentService defualtCommentService, @Qualifier("advancedCommentService") CommentService advancedCommentService) {
        this.defualtCommentService = defualtCommentService;
        this.advancedCommentService = advancedCommentService;
    }


    @PostMapping("/createDefault")
    public ResponseEntity<String> createDefaultComment(@RequestBody Map<String, Object> requestBody){
        String content = (String)  requestBody.get("content");
        defualtCommentService.createComment(content);

        return new ResponseEntity<>("Default comment added " + content, HttpStatus.OK);
    }

    @PostMapping("/createAdvanced")
    public ResponseEntity<String> createAdvancedComment(@RequestBody Map<String, Object> requestBody){
        String content = (String)  requestBody.get("content");
        advancedCommentService.createComment(content);
        return new ResponseEntity<>("Advanced Comment added " + content, HttpStatus.OK);
    }

}
