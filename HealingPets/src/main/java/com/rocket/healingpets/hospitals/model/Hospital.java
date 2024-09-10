package com.rocket.healingpets.hospitals.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hospital")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;

    @Column(name = "pwd")
    private String userPwd;

    @Column(name = "name")
    private String userName;
}
