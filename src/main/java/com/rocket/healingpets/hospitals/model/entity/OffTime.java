package com.rocket.healingpets.hospitals.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "off_time")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class OffTime {

    @Id
    @Column(name = "offTime_id")
    private int offTimeId;

    @ManyToOne
    private HospitalSchedule hospitalSchedule;

    @Column(name = "start_time")
    // 미진료시간 시작 범위
    private LocalTime startTime;

    @Column(name = "end_time")
    // 미진료시간 끝 범위
    private LocalTime endTime;

}
