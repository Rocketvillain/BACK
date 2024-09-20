package com.rocket.healingpets.users.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rocket.healingpets.common.ResponseMessage;

import com.rocket.healingpets.users.model.dto.UserDTO;
import com.rocket.healingpets.users.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // 회원가입 요청
    @Operation(summary ="회원가입")
    @PostMapping("/signup")
    public ResponseEntity<ResponseMessage> signup(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        UserDTO savedUserDTO = authService.signup(userDTO);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> userMap = objectMapper.convertValue(savedUserDTO, Map.class);

        return ResponseEntity
                .ok()
                .body(new ResponseMessage(HttpStatus.CREATED, "회원가입 성공", userMap));
    }

}
