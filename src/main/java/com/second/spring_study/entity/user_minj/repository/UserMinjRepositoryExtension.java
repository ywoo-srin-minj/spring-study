package com.second.spring_study.entity.user_minj.repository;

import com.second.spring_study.dto.request.minj.UpdateUserRequestDto;

public interface UserMinjRepositoryExtension {
    void updateUser(long id, UpdateUserRequestDto updateUserRequestDto);
}
