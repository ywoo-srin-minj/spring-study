package com.second.spring_study.dto.request.srin;

import com.second.spring_study.entity.user_srin.UserSrin;
import lombok.*;


@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserResponseDto {
    private Long id;
    private String user_id;
    private String user_password;
    private String user_name;
}

/*
public class UserResponseDto {

    @Builder
    @Data
    public static class UserDto{
        private Long id;
        private String user_id;
        private String user_password;
        private String user_name;

        public static UserDto of(UserSrin userSrin){
            return UserDto.builder()
                    .id(userSrin.getId())
                    .user_id(userSrin.getUser_id())
                    .user_name(userSrin.getUser_name())
                    .user_password(userSrin.getUser_password())
                    .build();
        }
    }

}
*/
