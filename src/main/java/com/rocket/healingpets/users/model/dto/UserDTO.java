package com.rocket.healingpets.users.model.dto;

import com.rocket.healingpets.users.model.entitiy.RoleType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    private String userId;
    private RoleType userRole;
    private String name;
    private String email;
    private String userPwd;
    private String phone;
    private String userState;
}
