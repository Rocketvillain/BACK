package com.rocket.healingpets.hospitals.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateHospitalDTO {

    private String name;
    private String address;
    private String businessNo;
    private String ownerName;

}
