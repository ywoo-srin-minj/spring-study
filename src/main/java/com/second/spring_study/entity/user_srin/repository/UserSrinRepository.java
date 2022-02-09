package com.second.spring_study.entity.user_srin.repository;

import com.second.spring_study.dto.request.srin.UserRequestDto;
import com.second.spring_study.entity.user_srin.UserSrin;
import org.springframework.data.repository.CrudRepository;

//왜 UserSrinRepositoryExtension을 상속받으면 error가 나지?
public interface UserSrinRepository extends CrudRepository<UserSrin, Long> {
    UserSrin save(UserRequestDto userRequestDto);
}
