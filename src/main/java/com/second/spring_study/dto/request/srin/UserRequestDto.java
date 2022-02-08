package com.second.spring_study.dto.request.srin;


//request 값을 받는거고
//response 값을 보내는거

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequestDto {
    //DB에서 처리하므로 작성하지 않아도 됨
    //Long id;

    @NotNull
    String user_id;
    @NotNull
    String user_password;
    @NotNull
    String user_name;

    /*
    {
    "id" : 1,
	"user_id" : "id",
	"user_password" : "password",
	"user_name" : "name"
    }
    */
}
