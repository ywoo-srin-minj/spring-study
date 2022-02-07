package com.second.spring_study.controller;

import com.second.spring_study.dto.request.ywoo.UserRequestDto;
import com.second.spring_study.service.UserYwooService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users-ywoo")
public class UserYwooController {

    private final UserYwooService userYwooService;
    @PostMapping()
    public void createUser(@RequestBody UserRequestDto userRequestDto){
        userYwooService.createUser(userRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        userYwooService.deleteUser(id);
    }
}
