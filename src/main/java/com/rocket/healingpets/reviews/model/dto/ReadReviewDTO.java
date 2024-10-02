package com.rocket.healingpets.reviews.model.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReadReviewDTO {
    // 리뷰 엔티티
    private int reviewId;
    private String content;
    private String reportState;
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;
}
