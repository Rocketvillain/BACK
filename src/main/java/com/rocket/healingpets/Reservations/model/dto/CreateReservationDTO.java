package com.rocket.healingpets.Reservations.model.dto;

import com.rocket.healingpets.hospitals.model.entity.ClinicType;
import com.rocket.healingpets.hospitals.model.entity.Hospital;
import com.rocket.healingpets.users.model.entitiy.User;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateReservationDTO {

    private int reservationId;
    private ClinicType clinicType;
    private User userId;
    private Hospital hosId;
    private LocalDateTime reservationDate;
    private String description;
    private String specificDescription;



}