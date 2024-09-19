package com.rocket.healingpets.hospitals.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "schedule")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class HospitalSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    // 일정 아이디
    private int scheduleId;

    @ManyToOne()
    @JoinColumn(name = "hos_id", nullable = false)
    // 병원 아이디
    private Hospital hosId;

    @Column(name = "date", nullable = false)
    // 진료 날짜
    private LocalDate date;

    @Column(name = "start_time", nullable = false)
    // 진료 시작시간
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    // 진료 마감시간
    private LocalTime endTime;

    @Column(name = "is_okay", nullable = false)
    @ColumnDefault("1") // 기본값을 TRUE로 설정 (1은 TRUE에 해당)
    // 예약 가능 여부
    private Boolean isOkay;

    @Column(name = "clinic_name", nullable = false)
    // 진료 유형
    private String clinicName;

    @OneToMany(mappedBy = "hospitalSchedule", cascade = CascadeType.ALL, orphanRemoval = true)
    // 미진료 시간
    private List<OffTime> offTime;

}
