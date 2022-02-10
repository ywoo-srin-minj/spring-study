package com.second.spring_study.service;

import com.second.spring_study.dto.request.minj.UpdateUserRequestDto;
import com.second.spring_study.dto.request.minj.UserRequestDto;
import com.second.spring_study.dto.response.minj.UserResponseDto;
import com.second.spring_study.entity.user_minj.UserMinj;
import com.second.spring_study.entity.user_minj.repository.UserMinjRepository;
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
        UserMinj user = UserMinj.createUser(userRequestDto.getUser_id(), userRequestDto.getUser_name(), userRequestDto.getUser_password());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(long id) {
        // 없는 아이디일 경우 추후에 예외처리 진행
        //userRepository.findById(id).orElseThrow();
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
        UserMinj userMinj = userRepository.findById(id).orElseThrow();
        return UserResponseDto.of(userMinj);
    }

    @Transactional
    public void updateUser(long id, UpdateUserRequestDto updateUserRequestDto){
        userRepository.findById(id).orElseThrow();
        userRepository.updateUser(id, updateUserRequestDto);
    }
}
