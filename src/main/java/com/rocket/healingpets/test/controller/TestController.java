package com.rocket.healingpets.test.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    // USER일 때만 사용가능함
    @Operation(summary ="유저")
    @PreAuthorize("hasAnyAuthority('USER')")
    @GetMapping("/user")
    public String testUser() {
        return "user 권한만 접근 가능한 test success";
    }

    // ADMIN일 때만 사용가능함
    @Operation(summary ="관리자")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/admin")
    public String testAdmin() {
        return "Admin 권한만 접근 가능한 test success";
    }
}
