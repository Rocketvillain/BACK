package com.rocket.healingpets.users.controller;

import com.rocket.healingpets.users.common.ResponseMessage;
import com.rocket.healingpets.users.model.entitiy.User;
import com.rocket.healingpets.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping()
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //유저 전체 조회
    @Operation(summary = "유저 전체 조회")
    @GetMapping("")
    public ResponseEntity<ResponseMessage> findAllUsers(){

        List<User> users = userService.findAllUsers();

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users",users);

        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK,"회원 전체 조회 성공",responseMap));
    }

    //유저 단일 조회
    @Operation(summary ="유저 단일 조회")
    @GetMapping("{postId}")
    public ResponseEntity<ResponseMessage> findUserByUsername(@PathVariable String username){

        User user = userService.findUserByUsername();

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user",user);

        return ResponseEntity.ok()
                .body(new ResponseMessage(Htt))
    }
}
