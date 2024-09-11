package com.rocket.healingpets.users.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    private String user_id;
    private String user_role;
    private String name;
    private String email;
    private String phone;
}
