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
    public void createUser(UserRequestDto userRequestDto) {
        UserMinj user = UserMinj.createUser(userRequestDto.getUser_id(), userRequestDto.getUser_name(), userRequestDto.getUser_password());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(long id) {
        // 없는 아이디일 경우 추후에 예외처리 진행
        //userRepository.findById(id).orElseThrow();
        userRepository.deleteById(id);
    }

}
