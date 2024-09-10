package com.rocket.healingpets.Reservations.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;

    @Column(name = "pwd")
    private String userPwd;

    @Column(name = "name")
    private String userName;
}
