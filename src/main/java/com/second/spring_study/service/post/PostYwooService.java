package com.second.spring_study.service.post;

import com.second.spring_study.dto.request.ywoo.PostRequestDto;
import com.second.spring_study.dto.response.ywoo.PostFindResponseDto;
import com.second.spring_study.entity.ywoo.postYwoo.PostYwoo;
import com.second.spring_study.entity.ywoo.postYwoo.repository.PostYwooRepository;
import com.second.spring_study.entity.ywoo.userYwoo.UserYwoo;
import com.second.spring_study.entity.ywoo.userYwoo.repository.UserYwooRepository;
import com.second.spring_study.exception.ywoo.ApiExceptionYwoo;
import com.second.spring_study.exception.ywoo.ErrorCodeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostYwooService {
     final PostYwooRepository postYwooRepository;
     final UserYwooRepository userYwooRepository;

    @Transactional
    public void createPost(PostRequestDto postRequestDto, long userpk){
        //user의 id가 없을 경우 에러 발생
        UserYwoo userYwoo = userYwooRepository.findById(userpk).orElseThrow(()->{
            throw new ApiExceptionYwoo(ErrorCodeEnum.USER_NOT_FOUND);
        });

        PostYwoo postYwoo = PostYwoo.createPost(userYwoo, postRequestDto.getTitle(), postRequestDto.getContent());

        postYwooRepository.save(postYwoo);
    }

    @Transactional
    public List<PostFindResponseDto> findAllPosts(Long userpk){
        return userYwooRepository.findAllPosts(userpk);
    }

    @Transactional
    public PostFindResponseDto findPost(long postId){
        PostYwoo postYwoo = postYwooRepository.findById(postId).orElseThrow(()->{
            throw new ApiExceptionYwoo(ErrorCodeEnum.POST_NOT_FOUND);
        });

        return PostFindResponseDto.of(postYwoo);
    }

    @Transactional
    public void updatePost(long id, PostRequestDto postRequestDto){
       PostYwoo postYwoo=postYwooRepository.findById(id).orElseThrow(()->{
            throw new ApiExceptionYwoo(ErrorCodeEnum.POST_NOT_FOUND);
        });
        postYwoo.updatePost(postRequestDto.getTitle(), postRequestDto.getContent());
    }

    @Transactional
    public void deletePost(long id){
        postYwooRepository.findById(id).orElseThrow(()->{
            throw new ApiExceptionYwoo(ErrorCodeEnum.POST_NOT_FOUND);
        });
        postYwooRepository.deleteById(id);
    }
}
