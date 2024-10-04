package com.rocket.healingpets.Reservations.model.dto;

import com.rocket.healingpets.users.model.entitiy.Pet;
import com.rocket.healingpets.users.model.entitiy.User;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ReservationDTO {
    // 예약
    private int reservationId; // 예약 아이디

    // 유저 파트
    private String userid; // 유저 아이디
    private String userName; // 유저 이름
    private String userEmail; // 이메일
    private String userPhone; // 전화번호
    private int petId;
    private String petName;

    // 병원 파트
    private String hosName; // 예약 대상 병원
    private String clinicName; //진료 유형
    private String description; // 설명
    private String specificDescription; // 상세 설명
    private String state; // 예약 상태 (승인/취소/설명)
    private LocalDateTime reservationTime; // 예약 시작 시간
    private LocalDate lastModifiedDate; // 최근 수정일

}
