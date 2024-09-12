package com.rocket.healingpets.reviews.model;

import com.rocket.healingpets.users.model.entitiy.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "review-report")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReviewReport {

    @Id
    @Column(name = "reservation_id")
    // 예약 아이디
    private int reservationId;

    @Column(name = "report_state", nullable = false)
    // 신고 접수 상태(대기, 승인, 취소)
    private String reportState = "대기";

}
