package com.samalss.iam_service.controller;

import com.samalss.iam_service.model.constants.ApiErrorMessage;
import com.samalss.iam_service.model.constants.ApiLogMessage;
import com.samalss.iam_service.model.dto.Post.PostDTO;
import com.samalss.iam_service.model.entities.Post;
import com.samalss.iam_service.model.response.IamResponse;
import com.samalss.iam_service.repositories.PostRepository;
import com.samalss.iam_service.service.PostService;
import com.samalss.iam_service.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("${end.point.posts}")
public class PostController {
    private final PostService postService;

    @GetMapping("${end.point.id}")
    public ResponseEntity<IamResponse<PostDTO>> getPostById(@PathVariable(name = "id") Integer postId){
        log.trace(ApiLogMessage.NAME_OF_CURRENT_METHOD.getValue(), ApiUtils.getMethodName());
        IamResponse<PostDTO> iamResponse = postService.getById(postId);
        return ResponseEntity.ok(iamResponse);
    }
}
