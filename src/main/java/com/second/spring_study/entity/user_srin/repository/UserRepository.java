package com.second.spring_study.entity.user_srin.repository;

import com.second.spring_study.entity.user_srin.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
