package com.rocket.healingpets.hospitals.model.dto.Hospital;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UpdateHospitalDTO {

    private String name;
    private String address;
    private String ownerName;
    private String businessNo;
    private String info;
    private String ownerImage;
    private String infoImage;

}
