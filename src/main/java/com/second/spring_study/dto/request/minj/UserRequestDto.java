package com.second.spring_study.dto.request.minj;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequestDto {

    @NotNull
    String userId;
    @NotNull
    String userPassword;
    @NotNull
    String userName;

}
