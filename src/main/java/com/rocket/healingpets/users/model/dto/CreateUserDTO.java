package com.rocket.healingpets.users.model.dto;

import com.rocket.healingpets.users.model.entitiy.RoleType;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateUserDTO {

    private String userId;
    private int hosId;
    private RoleType userRole;
    private String userPwd;
    private String name;
    private String email;
    private String phone;
    private LocalDate createDate;
    private LocalDate lastModifiedDate;
    private String userState;


}
