package com.second.spring_study.controller;

import com.second.spring_study.dto.request.minj.UserRequestDto;
import com.second.spring_study.service.UserMinjService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users-minj")
public class UserMinjController {

    private final UserMinjService userMinjService;

    @PostMapping()
    public void createUser(@RequestBody UserRequestDto userRequestDto) {
        userMinjService.createUser(userRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable @Valid long id) {
        userMinjService.deleteUser(id);
    }
}
