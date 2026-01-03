package com.samalss.iam_service.service;

import com.samalss.iam_service.mapper.PostMapper;
import com.samalss.iam_service.model.constants.ApiErrorMessage;
import com.samalss.iam_service.model.dto.Post.PostDTO;
import com.samalss.iam_service.model.entities.Post;
import com.samalss.iam_service.model.exception.NotFoundException;
import com.samalss.iam_service.model.request.post.PostRequest;
import com.samalss.iam_service.model.response.IamResponse;
import com.samalss.iam_service.repositories.PostRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public IamResponse<PostDTO> getById(@NotNull Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(()->
            new NotFoundException(ApiErrorMessage.POST_NOT_FOUND_BY_ID.getMessage(postId)));
        PostDTO postDTO = postMapper.toPostDTO(post);
        return IamResponse.createdSuccessful(postDTO);
    }

    @Override
    public IamResponse<PostDTO> createPost(@NotNull PostRequest postRequest) {
        Post post = postMapper.createPost(postRequest);
        Post savedPost = postRepository.save(post);
        PostDTO postDTO = postMapper.toPostDTO(savedPost);
        return IamResponse.createdSuccessful(postDTO);
    }
}
