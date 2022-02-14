package com.second.spring_study.entity.user_ywoo.repository;

import com.second.spring_study.entity.user_ywoo.UserYwoo;
import org.springframework.data.repository.CrudRepository;

public interface UserYwooRepository extends CrudRepository<UserYwoo, Long>, UserYwooRepositoryExtension {
    UserYwoo save(UserYwoo userYwoo);
    Boolean existsByUserId(String userId);
}