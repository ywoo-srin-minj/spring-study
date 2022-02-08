package com.second.spring_study.dto.response.ywoo;

import com.second.spring_study.entity.user_ywoo.UserYwoo;
import lombok.*;


@Builder
@Getter
public class UserResponseDto {
    private Long id;
    private String user_id;
    private String user_name;
    private String user_password;

    //of를 사용해 entity to of
    public static UserResponseDto of(UserYwoo userYwoo){
        return UserResponseDto.builder()
                .id(userYwoo.getId())
                .user_id(userYwoo.getUser_id())
                .user_name(userYwoo.getUser_name())
                .user_password(userYwoo.getUser_password())
                .build();
    }
}
