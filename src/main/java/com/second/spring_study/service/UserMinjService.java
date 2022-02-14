package com.second.spring_study.service;

import com.second.spring_study.dto.request.minj.UpdateUserRequestDto;
import com.second.spring_study.dto.request.minj.UserRequestDto;
import com.second.spring_study.dto.response.minj.UserResponseDto;
import com.second.spring_study.entity.minj.userMinj.UserMinj;
import com.second.spring_study.entity.minj.userMinj.repository.UserMinjRepository;
import com.second.spring_study.exception.minj.ApiExceptionMinJ;
import com.second.spring_study.exception.minj.ErrorCodeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserMinjService {
    private final UserMinjRepository userRepository;

    @Transactional
    public void createUser(UserRequestDto userRequestDto) {
        if(userRepository.existsByUserId(userRequestDto.getUserId())){
            throw new ApiExceptionMinJ(ErrorCodeEnum.USER_ALREADY_EXIST);
        }

        UserMinj user = UserMinj.createUser(userRequestDto.getUserId(), userRequestDto.getUserName(), userRequestDto.getUserPassword());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(long id) {
        // 없는 아이디일 경우 추후에 예외처리 진행
        userRepository.findById(id).orElseThrow(() -> {
            throw new ApiExceptionMinJ(ErrorCodeEnum.USER_NOT_FOUND);
        });
        userRepository.deleteById(id);
    }

    @Transactional
    public List<UserResponseDto> selectUser() {
        List<UserMinj> user = (List<UserMinj>) userRepository.findAll();

//        return user.stream()
//                .map(
//                        e -> new UserResponseDto(e.getId(), e.getUserId(), e.getUserPassword(), e.getUserName())
//                )
//                .collect(Collectors.toList());

        return user.stream().map(UserResponseDto::of).collect(Collectors.toList());
    }

    @Transactional
    public UserResponseDto detailsUser(long id) {
        UserMinj userMinj = userRepository.findById(id).orElseThrow(() ->{
            throw new ApiExceptionMinJ(ErrorCodeEnum.USER_NOT_FOUND);
        });
        return UserResponseDto.of(userMinj);
    }

    @Transactional
    public void updateUser(long id, UpdateUserRequestDto updateUserRequestDto){
        userRepository.findById(id).orElseThrow(() ->{
            throw new ApiExceptionMinJ(ErrorCodeEnum.USER_NOT_FOUND);
        });
        userRepository.updateUser(id, updateUserRequestDto);
    }
}
