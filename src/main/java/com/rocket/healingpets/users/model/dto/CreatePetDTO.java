package com.rocket.healingpets.users.model.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreatePetDTO {

    private String petName;
    private String gender;
    private String weight;
    private int age;
    private String species;
    private String kind;
    private String image;

}
