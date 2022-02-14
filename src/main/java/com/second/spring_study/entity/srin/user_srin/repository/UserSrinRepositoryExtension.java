package com.second.spring_study.entity.srin.user_srin.repository;

import com.second.spring_study.dto.request.srin.UserUpdateRequestDto;

public interface UserSrinRepositoryExtension {
    void updateUser(long id, UserUpdateRequestDto userUpdateRequestDto);
}