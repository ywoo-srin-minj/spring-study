package com.second.spring_study.controller.user;

import com.second.spring_study.dto.request.ywoo.UserRequestUpdateDto;
import com.second.spring_study.dto.response.ywoo.UserResponseDto;
import com.second.spring_study.dto.request.ywoo.UserRequestDto;
import com.second.spring_study.service.user.UserYwooService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users-ywoo")
public class UserYwooController {

    private final UserYwooService userYwooService;

    @PostMapping()
    public void createUser(@RequestBody UserRequestDto userRequestDto) {
        userYwooService.createUser(userRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userYwooService.deleteUser(id);
    }

    @GetMapping()
    public List<UserResponseDto> findAllUser(){

        return userYwooService.findAllUser();
    }
    @PostMapping("/{id}")
    public UserResponseDto findUser(@PathVariable long id){
        return userYwooService.findUser(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable long id, @RequestBody UserRequestUpdateDto userRequestUpdateDto){
        userYwooService.updateUser(id,userRequestUpdateDto);

    }

}
