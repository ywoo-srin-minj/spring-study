package com.second.spring_study.service;

import com.second.spring_study.dto.request.srin.UserRequestDto;
import com.second.spring_study.entity.user_srin.UserSrin;
import com.second.spring_study.entity.user_srin.repository.UserSrinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//실제 기능 구현하는곳
@RequiredArgsConstructor
@Service
public class UserSrinService {
    private final UserSrinRepository userRepository;

    public void createUser(UserRequestDto userRequestDto) {
        UserSrin userSrin = UserSrin.createUser(userRequestDto.getUser_id(), userRequestDto.getUser_name(), userRequestDto.getUser_password());
        userRepository.save(userSrin);
    }

}
