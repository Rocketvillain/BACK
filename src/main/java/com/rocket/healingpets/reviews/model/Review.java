package com.rocket.healingpets.reviews.model;

import com.rocket.healingpets.users.model.entitiy.User;
import com.rocket.healingpets.users.model.entitiy.UserState;
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
@Builder
public class Review {

    @Id
    @Column(name = "reservation_id")
    // 예약 아이디(원투원 매핑했기 때문에 동일하게 ID로 쓰인다.)
    private int reservationId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

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
    // 후기 신고
    private ReviewReport reviewReport;
}
