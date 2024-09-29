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

public class CreateReservationDTO {

    // 유저 파트
    private String userId; // 예약자 아이디
    private String userName; // 예약자 이름
    private String email; // 이메일
    private String phone; // 유저
    private int petId; // 고유 펫 id

    // 병원 파트
    private int hosId; // 예약 대상 병원
    private int typeId; //진료 유형
    private String description; // 설명
    private String specificDescription; // 상세 설명
    private LocalDateTime reservationTime; // 예약 시작 시간



}