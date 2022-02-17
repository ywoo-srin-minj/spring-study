package com.second.spring_study.service.post;

import com.second.spring_study.dto.request.minj.PostRequestDto;
import com.second.spring_study.dto.response.minj.PostResponseDto;
import com.second.spring_study.entity.minj.postMinj.PostMinj;
import com.second.spring_study.entity.minj.postMinj.repository.PostRepository;
import com.second.spring_study.entity.minj.userMinj.UserMinj;
import com.second.spring_study.entity.minj.userMinj.repository.UserMinjRepository;
import com.second.spring_study.exception.minj.ApiExceptionMinJ;
import com.second.spring_study.exception.minj.ErrorCodeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostMinjService {
    private final UserMinjRepository userMinjRepository;
    private final PostRepository postRepository;

    @Transactional
    public void createPost(long userPk, PostRequestDto postRequestDto) {
        UserMinj userMinj = userMinjRepository.findById(userPk).orElseThrow(() -> {
            throw new ApiExceptionMinJ(ErrorCodeEnum.USER_NOT_FOUND);
        });
        PostMinj postMinj = PostMinj.createPost(postRequestDto, userMinj);
        postRepository.save(postMinj);
    }

    public List<PostResponseDto> getPosts(Long userPk) {
        return userMinjRepository.getPosts(userPk);
    }

    @Transactional
    public PostResponseDto getPost(long postId){
        PostMinj postMinj = postRepository.findById(postId).orElseThrow(() -> {
            throw new ApiExceptionMinJ(ErrorCodeEnum.POST_NOT_FOUND);
        });
        return PostResponseDto.of(postMinj);
    }

    @Transactional
    public void updatePost(long postId, PostRequestDto postRequestDto){
        PostMinj postMinj = postRepository.findById(postId).orElseThrow(() -> {
            throw new ApiExceptionMinJ(ErrorCodeEnum.POST_NOT_FOUND);
        });
        postRepository.save(postMinj.updatePost(postRequestDto));
    }
}
