package com.rocket.healingpets.users.model.dto;

import com.rocket.healingpets.hospitals.model.entity.ClinicType;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateHospitalDTO2 {

    private int hosId;
    private String hospitalName;
    private String address;
    private String businessNo;
    private String ownerName;
    private List<ClinicType> clinicType;
}
