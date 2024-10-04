package com.rocket.healingpets.reviews.model.entity;

import com.rocket.healingpets.Reservations.model.entity.Reservation;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Entity
@Table(name = "review")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    // 예약 아이디(원투원 매핑했기 때문에 동일하게 ID로 쓰인다.)
    private int reviewId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "report_state")
    // 신고 접수 상태(미접수, 대기, 승인, 취소)
    private String reportState;

    @Column(name = "created_date")
    @CreatedDate
    // 생성일
    private LocalDate createdDate;

    @Column(name = "last_modified_date")
    @LastModifiedDate
    // 마지막 수정일
    private LocalDate lastModifiedDate;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId // 부모의 ID를 자식의 ID로 매핑
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

}
