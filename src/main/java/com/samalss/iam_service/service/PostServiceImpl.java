package com.samalss.iam_service.service;

import com.samalss.iam_service.model.constants.ApiErrorMessage;
import com.samalss.iam_service.model.dto.Post.PostDTO;
import com.samalss.iam_service.model.entities.Post;
import com.samalss.iam_service.model.exception.NotFoundException;
import com.samalss.iam_service.model.response.IamResponse;
import com.samalss.iam_service.repositories.PostRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public IamResponse<PostDTO> getById(@NotNull Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(()->
            new NotFoundException(ApiErrorMessage.POST_NOT_FOUND_BY_ID.getMessage(postId)));
        PostDTO postDTO = PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .likes(post.getLikes())
                .created(post.getCreated())
        .build();

        return IamResponse.createdSuccessful(postDTO);
    }
}
