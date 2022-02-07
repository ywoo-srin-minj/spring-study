package com.second.spring_study.entity.user_srin.repository;

import com.second.spring_study.dto.request.srin.UserRequestDto;
import com.second.spring_study.entity.user_srin.UserSrin;
import org.springframework.data.repository.CrudRepository;

public interface UserSrinRepository extends CrudRepository<UserSrin, Long> {
    UserSrin save(UserRequestDto userRequestDto);

    @Override
    void deleteById(Long id);
}
