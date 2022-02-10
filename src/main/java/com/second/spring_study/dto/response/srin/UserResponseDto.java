package com.second.spring_study.dto.response.srin;

import com.second.spring_study.entity.user_srin.UserSrin;
import lombok.*;

/*
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserResponseDto {
    private Long id;
    private String user_id;
    private String user_password;
    private String user_name;
}
*/
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class UserResponseDto {

    private Long id;
    private String userId;
    private String userPassword;
    private String userName;

    public static UserResponseDto of(UserSrin userSrin) {
        return UserResponseDto.builder()
                .id(userSrin.getId())
                .userId(userSrin.getUserId())
                .userName(userSrin.getUserName())
                .userPassword(userSrin.getUserPassword())
                .build();
    }

}

