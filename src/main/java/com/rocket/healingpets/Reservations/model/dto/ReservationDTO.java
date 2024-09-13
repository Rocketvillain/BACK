package com.rocket.healingpets.Reservations.model.dto;

import com.rocket.healingpets.hospitals.model.entity.ClinicType;
import com.rocket.healingpets.hospitals.model.entity.Hospital;
import com.rocket.healingpets.users.model.entitiy.User;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReservationDTO {
    private int reservationId; // 예약 아이디
    private ClinicType clinicType; //진료 유형
    private User userId; // 예약자
    private Hospital hosId; // 예약 대상 병원
    private String description; // 설명
    private String specificDescription; // 상세 설명
    private String state; // 예약 상태 (승인/취소/설명)
    private LocalDateTime reservationDate; // 예약 시작 시간
    private LocalDate createdData; // 생성일
    private LocalDate lastModifiedDate; // 마지막 수정일
}
