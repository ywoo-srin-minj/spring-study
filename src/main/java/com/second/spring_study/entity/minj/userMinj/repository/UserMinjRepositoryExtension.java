package com.second.spring_study.entity.minj.userMinj.repository;

import com.second.spring_study.dto.request.minj.UpdateUserRequestDto;

public interface UserMinjRepositoryExtension {
    void updateUser(long id, UpdateUserRequestDto updateUserRequestDto);
}
