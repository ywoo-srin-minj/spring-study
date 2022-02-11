package com.second.spring_study.service;

import com.second.spring_study.dto.request.ywoo.UserRequestUpdateDto;
import com.second.spring_study.dto.response.ywoo.UserResponseDto;
import com.second.spring_study.dto.request.ywoo.UserRequestDto;
import com.second.spring_study.entity.user_ywoo.UserYwoo;
import com.second.spring_study.entity.user_ywoo.repository.UserYwooRepository;
import com.second.spring_study.exception.ywoo.ApiException;
import com.second.spring_study.exception.ywoo.ErrorCodeEnum;
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
        if(userRepository.existsByUserId(userRequestDto.getUserId())){
            throw new ApiException(ErrorCodeEnum.USER_ALREADY_EXIST);
        }
        UserYwoo user = UserYwoo.createUser(userRequestDto.getUserId(), userRequestDto.getUserName(), userRequestDto.getUserPassword());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(long id) {
        userRepository.findById(id).orElseThrow(() -> {
            throw new ApiException(ErrorCodeEnum.USER_NOT_FOUND);
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

    @Transactional
    public UserResponseDto findUser(long id){
        UserYwoo userYwoo = userRepository.findById(id).orElseThrow(()->{
            throw new ApiException(ErrorCodeEnum.USER_NOT_FOUND);
        });
        //orElseThrow()를 통해 UserYwoo이 아닐 경우 에러를 발생시킴
        //orElseThrow()가 없을 경우 findById의 타입이 맞지 않아 에러 발생
        return UserResponseDto.of(userYwoo);
        //of를 통해 entity to dto
    }

    @Transactional
    public void updateUser(long id, UserRequestUpdateDto userRequestUpdateDto){
        userRepository.findById(id).orElseThrow(()->{
            throw new ApiException(ErrorCodeEnum.USER_NOT_FOUND);
        });
        userRepository.updateUser(id,userRequestUpdateDto);
    }
}
