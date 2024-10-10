package com.rocket.healingpets.users.model.dto;

import com.rocket.healingpets.users.model.entitiy.RoleType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO2 {

    private String userId;
    private RoleType userRole=RoleType.ROLE_HOSPITAL;
    private String name;
    private String email;
    private String userPwd;
    private String phone;
    private CreateHospitalDTO2 hosInfo; // 병원 정보

}
