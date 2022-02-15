package com.second.spring_study.service;

import com.second.spring_study.dto.request.minj.CreatePostRequestDto;
import com.second.spring_study.entity.minj.postMinj.PostMinj;
import com.second.spring_study.entity.minj.postMinj.repository.PostRepository;
import com.second.spring_study.entity.minj.userMinj.UserMinj;
import com.second.spring_study.entity.minj.userMinj.repository.UserMinjRepository;
import com.second.spring_study.exception.minj.ApiExceptionMinJ;
import com.second.spring_study.exception.minj.ErrorCodeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostMinjService {
    private final UserMinjRepository userMinjRepository;
    private final PostRepository postRepository;

    public void createPost(long userPk, CreatePostRequestDto createPostRequestDto) {
        UserMinj userMinj = userMinjRepository.findById(userPk).orElseThrow(() -> {
            throw new ApiExceptionMinJ(ErrorCodeEnum.USER_NOT_FOUND);
        });
        PostMinj postMinj = PostMinj.createPost(createPostRequestDto.getTitle(), createPostRequestDto.getContent(), userMinj);
        postRepository.save(postMinj);
    }
}
