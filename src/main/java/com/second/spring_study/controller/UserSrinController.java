package com.second.spring_study.controller;

import com.second.spring_study.dto.request.srin.UserRequestDto;
import com.second.spring_study.dto.response.srin.UserResponseDto;
import com.second.spring_study.dto.request.srin.UserUpdateRequestDto;
import com.second.spring_study.service.UserSrinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users-srin")
public class UserSrinController {
    private final UserSrinService userSrinService;

    @PostMapping("/")
    public void createUser(@RequestBody UserRequestDto userRequestDto) {
        userSrinService.createUser(userRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userSrinService.deleteUser(id);
    }

    @ResponseBody
    @GetMapping()
    public List<UserResponseDto> findAllUser(){
        /*
        List<UserSrin> allUser = userSrinService.findAllUser();
        List<UserResponseDto> userList = new ArrayList<UserResponseDto>();
        for(UserSrin us:allUser){
            userList.add(new UserResponseDto(us.getId(), us.getUser_id(), us.getUser_password(), us.getUser_name()));
        }
        return userList;
        */
        List<UserResponseDto> userList = userSrinService.findAllUser();
        return userList;
    }

    @ResponseBody
    @GetMapping("/{id}")
    public UserResponseDto findByIdUser(@PathVariable long id){
        return userSrinService.findByIdUser(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable long id, @RequestBody UserUpdateRequestDto userUpdateRequestDto){
        userSrinService.updateUser(id, userUpdateRequestDto);
    }
}
