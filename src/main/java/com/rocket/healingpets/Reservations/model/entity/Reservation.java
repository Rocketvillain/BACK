package com.rocket.healingpets.Reservations.model.entity;

import com.rocket.healingpets.hospitals.model.entity.ClinicType;
import com.rocket.healingpets.hospitals.model.entity.Hospital;
import com.rocket.healingpets.reviews.model.Review;
import com.rocket.healingpets.users.model.entitiy.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    // 예약 아이디
    private int reservationId;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    // 진료 유형
    private ClinicType clinicType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    // 예약자
    private User userId;

    @ManyToOne
    @JoinColumn(name = "hos_id", nullable = false)
    // 예약 대상 병원
    private Hospital hosId;

    @Column(name = "reservation_date")
    // 예약 시작 시간
    private LocalDateTime reservationDate;

    @Column(name = "description")
    // 설명
    private String description;

    @Column(name = "specific_description")
    // 상세 설명
    private String specificDescription;

    @Column(name = "state")
    // 예약 상태(승인/취소/완료)
    private String state = "activatied";

//    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
//    private Review review;

    @Column(name = "created_date")
    @CreatedDate
    // 생성일
    private LocalDate createdDate;

    @Column(name = "last_modified_date")
    @LastModifiedDate
    // 마지막 수정일
    private LocalDate lastModifiedDate;

}
