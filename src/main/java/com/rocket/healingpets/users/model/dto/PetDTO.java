package com.rocket.healingpets.users.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PetDTO {

    private int petId;
    private String userId;
    private String name;
    private String gender;
    private String weight;
    private int age;
    private String species;
    private String kind;
    private String image;
}
