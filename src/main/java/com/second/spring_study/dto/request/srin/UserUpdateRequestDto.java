package com.second.spring_study.dto.request.srin;

import com.sun.istack.NotNull;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserUpdateRequestDto {
    @NotNull
    String user_password;

    @NotNull
    String user_name;
}
