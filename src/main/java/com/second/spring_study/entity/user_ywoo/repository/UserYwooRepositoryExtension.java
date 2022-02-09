package com.second.spring_study.entity.user_ywoo.repository;

import com.second.spring_study.dto.request.ywoo.UserRequestUpdateDto;

public interface UserYwooRepositoryExtension {
    void updateUser(long id, UserRequestUpdateDto userUpdateDto);
}
