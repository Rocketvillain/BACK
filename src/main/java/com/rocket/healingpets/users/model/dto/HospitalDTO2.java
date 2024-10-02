package com.rocket.healingpets.users.model.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class HospitalDTO2 {

    private int hosId;
    private String name;
    private String address;
    private String businessNo;
    private String ownerName;
    private List<String> clinicName;
    private String userId;

}
