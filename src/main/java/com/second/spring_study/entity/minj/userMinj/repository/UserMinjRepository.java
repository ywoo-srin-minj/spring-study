package com.second.spring_study.entity.minj.userMinj.repository;

import com.second.spring_study.entity.minj.userMinj.UserMinj;
import org.springframework.data.repository.CrudRepository;

public interface UserMinjRepository extends CrudRepository<UserMinj, Long>, UserMinjRepositoryExtension {
    UserMinj save(UserMinj userMinj);
    Boolean existsByUserId(String userId);
}
