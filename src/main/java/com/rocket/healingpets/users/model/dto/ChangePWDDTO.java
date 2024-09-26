package com.rocket.healingpets.users.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ChangePWDDTO {

    private String userId;
    private String name;
    private String email;
    private String newPassword;
}
