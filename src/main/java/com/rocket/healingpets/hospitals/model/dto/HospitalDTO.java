package com.rocket.healingpets.hospitals.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class HospitalDTO {

    private int hosId;
    private String name;
    private String ownerName;
    private String ownerImage;
    private String address;
    private String businessNo;
    private String info;
    private String infoImage;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
