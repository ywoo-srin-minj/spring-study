package com.second.spring_study.service;

import com.second.spring_study.dto.request.ywoo.UserRequestDto;
import com.second.spring_study.entity.user_ywoo.UserYwoo;
import com.second.spring_study.entity.user_ywoo.repository.UserYwooRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserYwooService {
    private final UserYwooRepository userRepository;

    @Transactional
    public void createUser(UserRequestDto userRequestDto){
        UserYwoo user = UserYwoo.createUser(userRequestDto.getUser_id(),userRequestDto.getUser_name(), userRequestDto.getUser_password());
        userRepository.save(user);
    }
}
