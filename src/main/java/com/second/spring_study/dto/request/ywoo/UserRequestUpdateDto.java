package com.second.spring_study.dto.request.ywoo;

import com.sun.istack.NotNull;
import lombok.*;

@Getter
@AllArgsConstructor //생성자 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequestUpdateDto {
    @NotNull
    String userPassword;
    @NotNull
    String userName;
}
