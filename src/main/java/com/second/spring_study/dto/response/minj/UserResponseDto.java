package com.second.spring_study.dto.response.minj;

import com.second.spring_study.entity.user_minj.UserMinj;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private long id;
    private String userId;
    private String userPassword;
    private String userName;

    public static UserResponseDto of(UserMinj userMinj) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.id = userMinj.getId();
        userResponseDto.userId = userMinj.getUserId();
        userResponseDto.userPassword = userMinj.getUserPassword();
        userResponseDto.userName = userMinj.getUserName();
        return userResponseDto;
    }
}
