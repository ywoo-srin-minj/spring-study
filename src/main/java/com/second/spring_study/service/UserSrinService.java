package com.second.spring_study.service;

import com.second.spring_study.dto.request.srin.UserRequestDto;
import com.second.spring_study.dto.response.srin.UserResponseDto;
import com.second.spring_study.dto.request.srin.UserUpdateRequestDto;
import com.second.spring_study.entity.user_srin.UserSrin;
import com.second.spring_study.entity.user_srin.repository.UserSrinRepository;
import com.second.spring_study.exception.srin.ApiExceptionSrin;
import com.second.spring_study.exception.srin.ErrorCodeEnum;
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
 /*       if(userRequestDto.getUserId()==null||userRequestDto.getUserName()==null||userRequestDto.getUserPassword()==null){
            throw new NullPointerException();
        }
  */
        if(userRepository.existsByUserId(userRequestDto.getUserId())){
            throw new ApiExceptionSrin(ErrorCodeEnum.USER_ALREADY_EXIST);
        }
        UserSrin userSrin = UserSrin.createUser(userRequestDto.getUserId(), userRequestDto.getUserName(), userRequestDto.getUserPassword());
        userRepository.save(userSrin);
    }

    @Transactional
    public void deleteUser(Long id) {
        userNotFoundException(id);
        userRepository.deleteById(id);
    }

    @Transactional
    public List<UserResponseDto> findAllUser(){
        List<UserSrin> allUser = (List<UserSrin>) userRepository.findAll();

        List<UserResponseDto> stream = (List<UserResponseDto>) allUser.stream()
                .map(userSrin -> new UserResponseDto(userSrin.getId(), userSrin.getUserId(), userSrin.getUserPassword(), userSrin.getUserName()))
                .collect(Collectors.toList());

        return stream;
    }

    @Transactional
    public UserResponseDto findByIdUser(long id){
        UserSrin userSrin = userNotFoundException(id);
        return UserResponseDto.of(userSrin);
    }

    @Transactional
    public void updateUser(long id, UserUpdateRequestDto userUpdateRequestDto){
        UserSrin userSrin = userNotFoundException(id);
        userSrin.updateUser(userSrin, userUpdateRequestDto);
    }

    private UserSrin userNotFoundException(long id){
        return userRepository.findById(id).orElseThrow(() -> new ApiExceptionSrin(ErrorCodeEnum.USER_NOT_FOUND));
    }
}
