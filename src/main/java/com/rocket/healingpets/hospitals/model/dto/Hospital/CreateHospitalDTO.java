package com.rocket.healingpets.hospitals.model.dto.Hospital;

import com.rocket.healingpets.hospitals.model.entity.ClinicType;
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
    private ClinicType clinicType;

}
