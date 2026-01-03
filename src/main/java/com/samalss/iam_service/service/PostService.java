package com.samalss.iam_service.service;

import com.samalss.iam_service.model.dto.Post.PostDTO;
import com.samalss.iam_service.model.response.IamResponse;
import jakarta.validation.constraints.NotNull;

public interface PostService {
    IamResponse<PostDTO> getById(@NotNull Integer postId);
}
