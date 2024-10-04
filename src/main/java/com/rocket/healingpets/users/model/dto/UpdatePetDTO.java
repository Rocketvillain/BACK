package com.rocket.healingpets.users.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class UpdatePetDTO {

    private int petId;
    private String name;
    private String gender;
    private String weight;
    private int age;
    private String species;
    private String kind;

}
