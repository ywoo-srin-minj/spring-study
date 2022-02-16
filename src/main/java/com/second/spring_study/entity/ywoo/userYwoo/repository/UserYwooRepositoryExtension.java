package com.second.spring_study.entity.ywoo.userYwoo.repository;

import com.second.spring_study.dto.request.ywoo.UserRequestUpdateDto;
import com.second.spring_study.dto.response.ywoo.PostFindResponseDto;

import java.util.List;

public interface UserYwooRepositoryExtension {
    void updateUser(long id, UserRequestUpdateDto userUpdateDto);
    List<PostFindResponseDto> findAllPosts(Long userpk);
}
