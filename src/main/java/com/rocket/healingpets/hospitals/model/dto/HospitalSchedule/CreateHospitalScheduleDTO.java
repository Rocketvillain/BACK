package com.rocket.healingpets.hospitals.model.dto.HospitalSchedule;

import com.rocket.healingpets.hospitals.model.entity.Hospital;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateHospitalScheduleDTO {

    private int hosId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Boolean isOkay = Boolean.TRUE;
    private String clinicName;

}
