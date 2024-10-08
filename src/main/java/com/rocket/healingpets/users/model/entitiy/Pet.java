package com.rocket.healingpets.users.model.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rocket.healingpets.Reservations.model.entity.Reservation;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "pet")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    // 펫 고유 번호
    private int petId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    // 사용자 아이디
    private User user;

    @Column(name = "pet_name",nullable = false)
    // 펫 이름
    private String petName;

    @Column(name = "gender",nullable = false)
    // 성별
    private String gender;

    @Column(name = "weight",nullable = false)
    // 몸무게
    private String weight;

    @Column(name = "age",nullable = false)
    // 나이
    private int age;

    @Column(name = "species",nullable = false)
    // 종
    private String species;

    @Column(name = "kind",nullable = false)
    // 종 유형
    private String kind;

    @Column(name = "image")
    // 펫 이미지(이미지 파일 폴더 경로로 기입)
    private String image;


}
