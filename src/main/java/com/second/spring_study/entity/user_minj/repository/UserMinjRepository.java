package com.second.spring_study.entity.user_minj.repository;

import com.second.spring_study.dto.request.minj.UserRequestDto;
import com.second.spring_study.entity.user_minj.UserMinj;
import org.springframework.data.repository.CrudRepository;

public interface UserMinjRepository extends CrudRepository<UserMinj, Long> {
    UserMinj save(UserMinj userMinj);
}
