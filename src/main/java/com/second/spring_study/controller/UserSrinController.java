package com.second.spring_study.controller;

import com.second.spring_study.dto.request.srin.UserRequestDto;
import com.second.spring_study.service.UserSrinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users-srin")
public class UserSrinController {
    private final UserSrinService userSrinService;

    @PostMapping()
    public void createUser(@RequestBody UserRequestDto userRequestDto) {
        userSrinService.createUser(userRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userSrinService.deleteUser(id);
    }
}
