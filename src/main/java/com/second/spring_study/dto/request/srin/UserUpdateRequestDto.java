package com.second.spring_study.dto.request.srin;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class UserUpdateRequestDto {
    private String user_password = null;
    private String user_name = null;
}
