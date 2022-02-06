package com.second.spring_study.service;

import com.second.spring_study.dto.request.minj.UserRequestDto;
import com.second.spring_study.entity.user_minj.UserMinj;
import com.second.spring_study.entity.user_minj.repository.UserMinjRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserMinjService {
    private final UserMinjRepository userRepository;

    @Transactional
    public void createUser(UserRequestDto userRequestDto){
        UserMinj user = UserMinj.createUser(userRequestDto.getUser_id(), userRequestDto.getUser_name(), userRequestDto.getUser_password());
        userRepository.save(user);
    }

}
