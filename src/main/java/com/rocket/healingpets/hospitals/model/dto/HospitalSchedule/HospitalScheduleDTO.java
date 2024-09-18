package com.rocket.healingpets.hospitals.model.dto.HospitalSchedule;

import com.rocket.healingpets.hospitals.model.entity.OffTime;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
public class HospitalScheduleDTO {

    private int scheduleId;
    private int hosId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Boolean isOkay;
    private String clinicName;
    private List<OffTime> offTime;

}
