package com.second.spring_study.entity.ywoo.userYwoo.repository;

import com.second.spring_study.entity.ywoo.userYwoo.UserYwoo;
import org.springframework.data.repository.CrudRepository;

public interface UserYwooRepository extends CrudRepository<UserYwoo, Long>, UserYwooRepositoryExtension {
    UserYwoo save(UserYwoo userYwoo);
    Boolean existsByUserId(String userId);
}
