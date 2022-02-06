package com.second.spring_study.controller;

import com.second.spring_study.dto.request.minj.UserRequestDto;
import com.second.spring_study.service.UserMinjService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users-minj")
public class UserMinjController {

    private final UserMinjService userMinjService;

    @PostMapping()
    public void createUser(@RequestBody UserRequestDto userRequestDto){
        userMinjService.createUser(userRequestDto);
    }
}
