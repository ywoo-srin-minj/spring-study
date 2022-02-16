package com.second.spring_study.entity.srin.user_srin.repository;

import com.second.spring_study.dto.request.srin.UserUpdateRequestDto;
import com.second.spring_study.dto.response.srin.PostInquiryResponseDto;

import java.util.List;

public interface UserSrinRepositoryExtension {
    void updateUser(long id, UserUpdateRequestDto userUpdateRequestDto);

    public List<PostInquiryResponseDto> findAllPosts(Long userpk);
}