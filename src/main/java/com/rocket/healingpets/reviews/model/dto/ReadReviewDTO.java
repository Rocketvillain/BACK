package com.rocket.healingpets.reviews.model.dto;

import com.rocket.healingpets.Reservations.model.entity.Reservation;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReadReviewDTO {
    // 리뷰 엔티티
    private String content;
    private String reportState;
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;
    private int reviewId;

    // 예약
    private String userId;
    private String userName;
    private String hosName;
    private String clinicName;
}
