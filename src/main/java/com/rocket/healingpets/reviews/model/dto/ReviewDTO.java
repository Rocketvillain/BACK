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

    // 유저 엔티티
    private String userId; // 유저 아이디
    private String userName; // 유저 이름

    // 병원 엔티티
    private String clinicName; //진료 유형
    private String hosName; // 예약 대상 병원
    private String address; // 병원 주소
    private int hosId; // 병원 아이디

}
