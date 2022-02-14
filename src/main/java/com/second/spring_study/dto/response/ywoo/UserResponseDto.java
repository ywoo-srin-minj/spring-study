package com.second.spring_study.dto.response.ywoo;

import com.second.spring_study.entity.ywoo.userYwoo.UserYwoo;
import lombok.*;


@Builder
@Getter
public class UserResponseDto {
    private Long id;
    private String userId;
    private String userName;
    private String userPassword;

    //of를 사용해 entity to of
    public static UserResponseDto of(UserYwoo userYwoo){
        return UserResponseDto.builder()
                .id(userYwoo.getId())
                .userId(userYwoo.getUserId())
                .userName(userYwoo.getUserName())
                .userPassword(userYwoo.getUserPassword())
                .build();
    }
}
