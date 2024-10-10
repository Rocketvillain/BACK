package com.rocket.healingpets.users.controller;

import com.rocket.healingpets.common.ResponseMessage;
import com.rocket.healingpets.users.model.dto.CreateUserDTO;
import com.rocket.healingpets.users.model.dto.ReadUserDTO;
import com.rocket.healingpets.users.model.dto.UpdateUserDTO;
import com.rocket.healingpets.users.model.dto.UserDTO;
import com.rocket.healingpets.users.model.entitiy.User;
import com.rocket.healingpets.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    //유저 전체 조회
    @Operation(summary = "유저 전체 조회")
    @GetMapping("")
    public ResponseEntity<ResponseMessage> findAllUsers(){

        List<UserDTO> users = userService.findAllUsers();

        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("users",users);

        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK,"유저 전체 조회 성공",responseMap));
    }

    //유저 단일 조회
    @Operation(summary ="유저 단일 조회")
    @GetMapping("/{user_Id}")
    public ResponseEntity<ResponseMessage> findUserById(@PathVariable String user_Id){

        User user = userService.findUserById(user_Id);

        ReadUserDTO foundUser = modelMapper.map(user, ReadUserDTO.class);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user",foundUser);

        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK,"유저 단일 조회 성공",responseMap));
    }

    // 유저 등록
    @PostMapping("")
    @Operation(summary = "유저 등록")
    public ResponseEntity<ResponseMessage> registUser(@RequestBody CreateUserDTO createUserDTO){

        User user = userService.registUser(createUserDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user",user);

        return ResponseEntity
                .created(URI.create("/users/"+user.getUserId()))
                .body(new ResponseMessage(HttpStatus.CREATED,"유저 등록 성공",responseMap));

    }

    // 유저 정보 수정
    @Operation(summary = "유저 수정")
    @PutMapping("/{user_Id}")
    public ResponseEntity<ResponseMessage> modifyUser(@PathVariable String user_Id, @RequestBody UpdateUserDTO updateUserDTO) {

        User user1 = userService.updateUserInfo(user_Id, updateUserDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user1",user1);

        return ResponseEntity.created(URI.create("/api/v1/user/" + user_Id))
                .body(new ResponseMessage(HttpStatus.OK, "유저 수정 성공", responseMap));
    }

    // 유저 이미지 수정
    @Operation(summary = "유저 수정")
    @PutMapping("/image/{user_Id}")
    public ResponseEntity<ResponseMessage> modifyUser(@PathVariable String user_Id, @RequestBody MultipartFile image) {

        User user2 = userService.updateUserImage(user_Id,image);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user2",user2);

        return ResponseEntity.created(URI.create("/api/v1/user/" + user_Id))
                .body(new ResponseMessage(HttpStatus.OK, "유저 수정 성공", responseMap));
    }

    // 유저 상태 수정
    @Operation(summary = "유저 상태 수정")
    @PutMapping("/{user_Id}/userState")
    public ResponseEntity<ResponseMessage> modifyUserState(@PathVariable String user_Id) {

        User user = userService.modifyUserState(user_Id);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user",user);

        return ResponseEntity.created(URI.create("/api/v1/user/" + user_Id))
                .body(new ResponseMessage(HttpStatus.OK, "유저 수정 성공", responseMap));
    }

    // 유저 삭제
    @Operation(summary = "유저 삭제")
    @DeleteMapping("/{user_Id}")
    public ResponseEntity<ResponseMessage> deletePost(@PathVariable String user_Id) {

        userService.deleteUserById(user_Id);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("message", "유저 삭제 성공");

        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK, "유저 삭제 성공", responseMap));

    }
}
