package com.rocket.healingpets.users.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rocket.healingpets.common.ResponseMessage;
import com.rocket.healingpets.users.model.dto.EmailCheckDTO;
import com.rocket.healingpets.users.model.dto.EmailDTO;
import com.rocket.healingpets.users.model.dto.UserDTO;
import com.rocket.healingpets.users.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
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

        // 사용자 정보 저장
        UserDTO savedUserDTO = authService.signup(userDTO);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> userMap = objectMapper.convertValue(savedUserDTO, Map.class);

        return ResponseEntity
                .ok()
                .body(new ResponseMessage(HttpStatus.CREATED, "회원가입 성공", userMap));
    }
    @Operation(summary ="인증 코드 보내기")
    @PostMapping("/send-code")
    public ResponseEntity<String> sendAuthCode(@RequestBody EmailDTO emailDTO) {
        String email = emailDTO.getEmail();
        authService.sendAuthCode(email);
        return ResponseEntity.ok("인증 코드가 이메일로 전송되었습니다.");
    }

    @Operation(summary ="코드 인증하기")
    @PostMapping("/verify-code")
    public ResponseEntity<String> verifyCode(@RequestBody EmailCheckDTO emailCheckDTO) {
        boolean isValid = authService.verifyAuthCode(emailCheckDTO.getEmail(),emailCheckDTO.getCode());
        return isValid ? ResponseEntity.ok("인증 성공") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("인증 실패");
    }

}
