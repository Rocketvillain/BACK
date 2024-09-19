package com.rocket.healingpets.Reservations.model.dto;


import com.rocket.healingpets.hospitals.model.entity.ClinicType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UpdateReservationDTO {


    // 병원 파트
    private int hosId; // 예약 대상 병원
    private int typeId; // 진료 유형
    private String description; // 설명
    private String specificDescription; // 상세 설명
    private LocalDateTime reservationDate; // 예약 시작 시간
    private LocalDate lastModifiedDate; // 최근 수정일
}
