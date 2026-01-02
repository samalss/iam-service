package com.samalss.iam_service.service.Impl;

import com.samalss.iam_service.service.CommentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service("advancedCommentService")
public class SecondCommentServiceImpl implements CommentService {
    private final List<String> comments = new ArrayList<>();

    @Override
    public void createComment(String commentContent){
        String advancesComment = "[" + LocalDate.now().toString() + "] " + commentContent.toUpperCase();
        comments.add(commentContent);
    }
}
