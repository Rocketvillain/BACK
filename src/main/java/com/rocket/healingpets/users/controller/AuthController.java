package com.rocket.healingpets.users.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rocket.healingpets.common.ResponseMessage;
import com.rocket.healingpets.users.model.dto.*;
import com.rocket.healingpets.users.repository.UserRepository;
import com.rocket.healingpets.users.service.AuthService;
import com.rocket.healingpets.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private UserRepository userRepository;

    @Autowired
    public AuthController(AuthService authService, UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;

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

    // 중복확인
    @Operation(summary ="중복확인")
    @GetMapping("/check-duplicate")
    public ResponseEntity<Boolean> checkDuplicate(@RequestParam String userId){
        boolean exists = userRepository.existsByUserId(userId);
        return ResponseEntity.ok(exists);
    }

    // ID찾기
    @Operation(summary ="ID찾기")
    @GetMapping("/find-id")
    public ResponseEntity<ResponseMessage> findId(@RequestParam String name, @RequestParam String phone ) {
        String userId = authService.findUserId(name,phone);

        if (userId != null) {
            // ID 찾기 성공
            Map<String, Object> results = new HashMap<>();
            results.put("userId", userId); // 사용자 ID를 결과에 추가

            return ResponseEntity.ok(new ResponseMessage(HttpStatus.OK, "ID 찾기 성공", results));
        } else {
            // 사용자 찾기 실패
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseMessage(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다.", null));
        }
    }

//    // 비밀번호 변경
//    @Operation(summary = "비밀번호 변경")
//    @PutMapping("/reset-password")
//    public ResponseEntity<ResponseMessage> changePwd (@RequestBody ChangePWDDTO request){
//
//    try{
//        boolean isChanged = authService.changePassword(request.getUserId(),request.getName(),request.getEmail(),request.getNewPassword());
//        if(isChanged){
//            // 비밀번호 변경
//            return ResponseEntity.ok(new ResponseMessage(HttpStatus.OK,"비밀번호가 변경되었습니다."));
//        }else{
//            return ResponseEntity.badRequest()
//                    .body(new ResponseMessage(HttpStatus.BAD_REQUEST,"비밀번호 변경 실패 : 유효하지 않는 인증번호 입니다."));
//        }
//    } catch (RuntimeException e){
//        return ResponseEntity.badRequest().body(new ResponseMessage(HttpStatus.BAD_REQUEST,"오류 발생"));
//        }
//
//    }

}
