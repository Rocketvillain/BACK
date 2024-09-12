package com.rocket.healingpets.users.controller;

import com.rocket.healingpets.common.ResponseMessage;
import com.rocket.healingpets.users.model.dto.CreateUserDTO;
import com.rocket.healingpets.users.model.dto.SelectUserDTO;
import com.rocket.healingpets.users.model.dto.UpdateUserDTO;
import com.rocket.healingpets.users.model.dto.UserDTO;
import com.rocket.healingpets.users.model.entitiy.User;
import com.rocket.healingpets.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

        List<UserDTO> users = userService.findAllUsers();

        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("users",users);

        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK,"유저 전체 조회 성공",responseMap));
    }

    //유저 단일 조회
    @Operation(summary ="유저 단일 조회")
    @GetMapping("{user_Id}")
    public ResponseEntity<ResponseMessage> findUserById(@PathVariable String user_Id){

        User user = userService.findUserById(user_Id);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user",user);

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

    // 유저 수정
    @Operation(summary = "유저 수정")
    @PutMapping("/{user_Id}")
    public ResponseEntity<ResponseMessage> modifyUser(@PathVariable String user_Id, @RequestBody UpdateUserDTO modifyInfo) {

        User user = userService.updateUser(user_Id, modifyInfo);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user",user);

        return ResponseEntity.created(URI.create("/entity/PostEntity/" + user_Id))
                .body(new ResponseMessage(HttpStatus.OK, "유저 수정 성공", responseMap));
    }


////    @Operation(summary = "유저 삭제")
////    @ApiResponses({
////            @ApiResponse(responseCode = "200", description = "게시글 삭제 성공!"),
////            //  204 No Content 대신 200 OK를 사용하여 본문에 메시지를 포함할 수 있게 했다.
////            @ApiResponse(responseCode = "400", description = "잘못 입력된 파라미터")
////    })
//
    // 유저 삭제
    @Operation(summary = "유저 삭제")
    @DeleteMapping("/{user_Id}")
    public ResponseEntity<ResponseMessage> deletePost(@PathVariable String user_Id) {

        userService.deleteUserById(user_Id);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("message", "게시글 삭제 성공");

        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK, "유저 삭제 성공", responseMap));

    }
}
