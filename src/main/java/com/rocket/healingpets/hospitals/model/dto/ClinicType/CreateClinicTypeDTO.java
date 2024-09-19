package com.rocket.healingpets.hospitals.model.dto.ClinicType;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateClinicTypeDTO {

    private int hosId;
    private String clinicName;

}
