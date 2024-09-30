package com.rocket.healingpets.hospitals.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "clinic_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class ClinicType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    // 진료 유형 고유 아이디
    private int typeId;

    @JoinColumn(name = "hos_id")
    // 병원 아이디
    private int hosId;

    @Column(name = "clinic_name")
    // 진료 유형
    private String clinicName;
}
