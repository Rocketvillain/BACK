package com.rocket.healingpets.hospitals.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Table(name = "hospital")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@EntityListeners(AuditingEntityListener.class)
@ToString
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hos_id")
    // 병원 아이디
    private int hosId;

    @Column(name = "name")
    // 병원 이름
    private String name;

    @Column(name = "owner_name")
    // 병원장 이름
    private String ownerName;

    @Column(name = "owner_image")
    // 병원장 사진
    private String ownerImage;

    @Column(name = "info")
    // 병원 소개
    private String info;

    @Column(name = "info_image")
    // 소개 이미지
    private String infoImage;

    @Column(name = "address")
    // 병원 주소
    private String address;

    @Column(name = "business_no")
    // 사업자 등록 번호
    private String businessNo;

    @Column(name = "created_date")
    @CreatedDate
    // 생성일
    private LocalDate createdDate;

    @Column(name = "last_modified_date")
    @LastModifiedDate
    // 마지막 수정일
    private LocalDate lastModifiedDate;
}
