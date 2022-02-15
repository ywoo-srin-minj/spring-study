package com.second.spring_study.entity.minj.userMinj.repository;

import com.second.spring_study.dto.request.minj.UpdateUserRequestDto;
import com.second.spring_study.dto.response.minj.PostResponseDto;

import java.util.List;

public interface UserMinjRepositoryExtension {
    void updateUser(long id, UpdateUserRequestDto updateUserRequestDto);

    List<PostResponseDto> getPosts(Long userPk);

}
