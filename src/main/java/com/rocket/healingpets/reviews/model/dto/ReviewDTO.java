package com.rocket.healingpets.reviews.model.dto;
import com.rocket.healingpets.Reservations.model.entity.Reservation;
import com.rocket.healingpets.users.model.entitiy.User;
import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReviewDTO {

    // 리뷰 엔티티
    private int reviewId;
    private String content;
    private String reportState;
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;

    // 예약 엔티티
    private int reservationId;

    // 병원 엔티티
    private String name;

    // 유저 엔티티
    private String userName;

}
