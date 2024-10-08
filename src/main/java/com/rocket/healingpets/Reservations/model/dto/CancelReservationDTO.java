package com.rocket.healingpets.Reservations.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CancelReservationDTO {

    private String description; // 설명
    private String state; // 예약 상태 (승인/취소/설명)

}
