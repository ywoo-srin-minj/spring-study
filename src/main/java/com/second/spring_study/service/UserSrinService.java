package com.second.spring_study.service;

import com.second.spring_study.dto.request.srin.UserRequestDto;
import com.second.spring_study.dto.response.srin.UserResponseDto;
import com.second.spring_study.dto.request.srin.UserUpdateRequestDto;
import com.second.spring_study.entity.user_srin.UserSrin;
import com.second.spring_study.entity.user_srin.repository.UserSrinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    public UserResponseDto findByIdUser(long id){
        UserSrin userSrin = userRepository.findById(id).orElseThrow();  //UserSrin의 형식이 아닌건 예외처리 하므로, UserSrin 형식만 return된다.
        return UserResponseDto.of(userSrin);
    }

    @Transactional
    public void updateUser(long id, UserUpdateRequestDto userUpdateRequestDto){
        UserSrin userSrin = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다. id" + id));
        userSrin.updateUser(userSrin, userUpdateRequestDto);
    }

}
