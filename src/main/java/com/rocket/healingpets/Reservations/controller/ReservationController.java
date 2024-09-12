package com.rocket.healingpets.Reservations.controller;

import com.rocket.healingpets.common.ResponseMessage;
import com.rocket.healingpets.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@Slf4j
@RequiredArgsConstructor
public class ReservationController {

//    private UserService userService;
//
//    // 예약 전체 조회
//    @GetMapping
//    @Operation(summary = "예약 전체 조회")
//    public ResponseEntity<ResponseMessage> findAllReservations(){
//
//    }
}
