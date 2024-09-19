package com.rocket.healingpets.hospitals.model.dto.ClinicType;

import com.rocket.healingpets.hospitals.model.entity.Hospital;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ClinicTypeDTO {

    private int typeId;
    private Hospital hospital;
    private String clinicName;

}
