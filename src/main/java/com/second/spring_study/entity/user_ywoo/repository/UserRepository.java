package com.second.spring_study.entity.user_ywoo.repository;


import com.second.spring_study.entity.user_ywoo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
