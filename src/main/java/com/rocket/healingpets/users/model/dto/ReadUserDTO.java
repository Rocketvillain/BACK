package com.rocket.healingpets.users.model.dto;

import com.rocket.healingpets.hospitals.model.entity.Hospital;
import com.rocket.healingpets.users.model.entitiy.Pet;
import com.rocket.healingpets.users.model.entitiy.RoleType;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReadUserDTO {

    private String userId;
    private int hosId;
    private String userPwd;
    private String userName;
    private RoleType userRole;
    private String email;
    private String phone;
    private List<Pet> pets;
    private String userState;
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;

}
