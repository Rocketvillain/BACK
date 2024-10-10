package com.rocket.healingpets.users.model.dto;

import com.rocket.healingpets.users.model.entitiy.Pet;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PetDTO {

    private int petId;
    private String userId;
    private String petName;
    private String gender;
    private String weight;
    private int age;
    private String species;
    private String kind;
    private String image; // 이미지 경로 (선택적)

}
