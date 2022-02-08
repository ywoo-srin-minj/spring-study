package com.second.spring_study.dto.response.minj;

import com.second.spring_study.entity.user_minj.UserMinj;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private long id;
    private String user_id;
    private String user_password;
    private String user_name;

    public static UserResponseDto of(UserMinj userMinj) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.id = userMinj.getId();
        userResponseDto.user_id = userMinj.getUser_id();
        userResponseDto.user_password = userMinj.getUser_password();
        userResponseDto.user_name = userMinj.getUser_name();
        return userResponseDto;
    }
}
