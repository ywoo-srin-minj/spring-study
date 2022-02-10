package com.second.spring_study.dto.request.ywoo;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// requestDto

@Getter
@AllArgsConstructor //생성자 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequestDto {

    @NotNull
    String userId;
    @NotNull
    String userPassword;
    @NotNull
    String userName;

}
