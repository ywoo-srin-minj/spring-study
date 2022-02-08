package com.second.spring_study.service;

import com.second.spring_study.dto.request.srin.UserRequestDto;
import com.second.spring_study.entity.user_srin.UserSrin;
import com.second.spring_study.entity.user_srin.repository.UserSrinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//실제 기능 구현하는곳
@RequiredArgsConstructor
@Service
public class UserSrinService {
    private final UserSrinRepository userRepository;

    @Transactional
    public void createUser(UserRequestDto userRequestDto) {
        UserSrin userSrin = UserSrin.createUser(userRequestDto.getUser_id(), userRequestDto.getUser_name(), userRequestDto.getUser_password());
        userRepository.save(userSrin);
    }

    @Transactional
    public void deleteUser(Long id) {
        /*
        userRepository.findById(id).orElseThrow(() -> {
            throw new DataNotFoundException();}
        );
        */
        userRepository.deleteById(id);
    }
}
