package com.rocket.healingpets.users.model.dto;

import com.rocket.healingpets.users.model.entitiy.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreatePetDTO2 {

    private int petId;
    private String petName;
    private String gender;
    private String weight;
    private int age;
    private String species;
    private String kind;

}
