package com.second.spring_study.dto.request.minj;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateUserRequestDto {

    @NotNull
    String userPassword;
    @NotNull
    String userName;

}
