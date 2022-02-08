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
    private String user_id;
    private String user_password;
    private String user_name;

    public static UserResponseDto of(UserSrin userSrin) {
        return UserResponseDto.builder()
                .id(userSrin.getId())
                .user_id(userSrin.getUser_id())
                .user_name(userSrin.getUser_name())
                .user_password(userSrin.getUser_password())
                .build();
    }

}

