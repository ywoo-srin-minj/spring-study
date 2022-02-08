package com.second.spring_study.service;

import com.second.spring_study.dto.reponse.ywoo.UserResponseDto;
import com.second.spring_study.dto.request.ywoo.UserRequestDto;
import com.second.spring_study.entity.user_ywoo.UserYwoo;
import com.second.spring_study.entity.user_ywoo.repository.UserYwooRepository;
import com.second.spring_study.exception.ywoo.DataNoFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.*;

@RequiredArgsConstructor
@Service
public class UserYwooService {
    private final UserYwooRepository userRepository;


    @Transactional
    public void createUser(UserRequestDto userRequestDto) {
        UserYwoo user = UserYwoo.createUser(userRequestDto.getUser_id(), userRequestDto.getUser_name(), userRequestDto.getUser_password());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(long id) {
        userRepository.findById(id).orElseThrow(() -> {
            throw new DataNoFoundException();
        });
        userRepository.deleteById(id);
    }

    @Transactional
    public List<UserResponseDto> findAllUser(){
        List<UserYwoo> users = (List<UserYwoo>)userRepository.findAll();

        return users.stream()
                .map(UserResponseDto::of)
                .collect(Collectors.toList());
        //useres의 타입은 <List>UserYwoo
        //stream을 통해 UserResponseDto로 형변환? - Mapping?
        //Colleactors를 통해 List로 변환
    }
}
