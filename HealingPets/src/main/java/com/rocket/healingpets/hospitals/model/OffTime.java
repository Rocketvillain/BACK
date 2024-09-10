package com.rocket.healingpets.hospitals.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "off_time")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OffTime {

    @Id
    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    // 진료 유형 고유 아이디
    private Schedule schedule;

    @Column(name = "start_time")
    // 미진료시간 시작 범위
    private LocalDateTime startTime;

    @Column(name = "end_time")
    // 미진료시간 끝 범위
    private LocalDateTime endTime;

}
