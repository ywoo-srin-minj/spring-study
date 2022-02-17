package com.second.spring_study.service.post;

import com.second.spring_study.dto.request.srin.PostCreateRequestDto;
import com.second.spring_study.dto.request.srin.PostUpdateRequestDto;
import com.second.spring_study.dto.response.srin.PostInquiryResponseDto;
import com.second.spring_study.entity.srin.post_srin.PostSrin;
import com.second.spring_study.entity.srin.post_srin.repository.PostSrinRepository;
import com.second.spring_study.entity.srin.user_srin.UserSrin;
import com.second.spring_study.entity.srin.user_srin.repository.UserSrinRepository;
import com.second.spring_study.exception.srin.ApiExceptionSrin;
import com.second.spring_study.exception.srin.ErrorCodeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostSrinService {
    private final UserSrinRepository userSrinRepository;
    private final PostSrinRepository postSrinRepository;

    @Transactional
    public void createPost(Long userpk, PostCreateRequestDto postCreateRequestDto){
        //해당 userpk에 맞는 UserSrin 객체 반환
        UserSrin userSrinParam = userSrinRepository.findById(userpk).orElseThrow(() -> new ApiExceptionSrin(ErrorCodeEnum.USER_NOT_FOUND));
        
        //builder 이용
        PostSrin params = PostSrin.builder()
                .postTitle(postCreateRequestDto.getTitle())
                .postContent(postCreateRequestDto.getContent())
                .userSrin(userSrinParam)
                .build();

        //값 저장
        postSrinRepository.save(params);
        
        //저장 값 확인을 위한 출력문 -> Debug모드를 이용하여 확인 가능
    }

    @Transactional
    public List<PostInquiryResponseDto> findAllPosts(Long userpk){
        return userSrinRepository.findAllPosts(userpk);
    }

    @Transactional
    public PostInquiryResponseDto findByIdPost(Long id){
        PostSrin findPost = postSrinRepository.findById(id).orElseThrow((() -> new ApiExceptionSrin(ErrorCodeEnum.POST_NOT_FOUND)));
        return PostInquiryResponseDto.of(findPost);
    }

    @Transactional
    public void updatePost(Long id, PostUpdateRequestDto postUpdateRequestDto){
        PostSrin postSrin = postSrinRepository.findById(id).orElseThrow((() -> new ApiExceptionSrin(ErrorCodeEnum.POST_NOT_FOUND)));
        postSrin.updatePost(postUpdateRequestDto);
    }
  
    @Transactional
    public void deletePost(long id){
        postSrinRepository.findById(id).orElseThrow((() -> new ApiExceptionSrin(ErrorCodeEnum.POST_NOT_FOUND)));
        postSrinRepository.deleteById(id);
    }
  
}
