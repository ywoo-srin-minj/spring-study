package com.second.spring_study.service;

import com.second.spring_study.dto.request.srin.UserRequestDto;
import com.second.spring_study.dto.request.srin.UserResponseDto;
import com.second.spring_study.entity.user_srin.UserSrin;
import com.second.spring_study.entity.user_srin.repository.UserSrinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.expression.Lists;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Transactional
    public List<UserResponseDto> findAllUser(){
        List<UserSrin> allUser = (List<UserSrin>) userRepository.findAll();


        List<UserResponseDto> stream = (List<UserResponseDto>) allUser.stream()
                .map(userSrin -> new UserResponseDto(userSrin.getId(), userSrin.getUser_id(), userSrin.getUser_password(), userSrin.getUser_name()))
                .collect(Collectors.toList());

        return stream;
    }

}
