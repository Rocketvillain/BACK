package com.rocket.healingpets.Reservations.model.dto;

import com.rocket.healingpets.hospitals.model.entity.ClinicType;
import com.rocket.healingpets.hospitals.model.entity.Hospital;
import com.rocket.healingpets.users.model.entitiy.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateReservationDTO {

    private ClinicType clinicType;
    private User userId;
    private Hospital hosId;
    private String description;

}
