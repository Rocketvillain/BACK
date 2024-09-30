package com.rocket.healingpets.hospitals.model.dto.HospitalSchedule;

import com.rocket.healingpets.hospitals.model.entity.ClinicType;
import com.rocket.healingpets.hospitals.model.entity.Hospital;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UpdateHospitalScheduleDTO {

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Boolean isOkay = Boolean.TRUE;
    private LocalTime lunchTime;

}
