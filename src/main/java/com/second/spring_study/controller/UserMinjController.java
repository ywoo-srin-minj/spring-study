package com.second.spring_study.controller;

import com.second.spring_study.dto.request.minj.UpdateUserRequestDto;
import com.second.spring_study.dto.request.minj.UserRequestDto;
import com.second.spring_study.dto.response.minj.UserResponseDto;
import com.second.spring_study.service.UserMinjService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users-minj")
public class UserMinjController {

    private final UserMinjService userMinjService;

    @PostMapping()
    public void createUser(@RequestBody @Valid UserRequestDto userRequestDto) {
        userMinjService.createUser(userRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable @Valid long id) {
        userMinjService.deleteUser(id);
    }

    @GetMapping()
    public List<UserResponseDto> selectUser() {
        return userMinjService.selectUser();
    }

    @PostMapping("{id}")
    public UserResponseDto detailsUser(@PathVariable @Valid long id) {
        return userMinjService.detailsUser(id);
    }

    @PutMapping("{id}")
    public void updateUser(@PathVariable @Valid long id, @RequestBody UpdateUserRequestDto updateUserRequestDto){
        userMinjService.updateUser(id, updateUserRequestDto);
    }
}
