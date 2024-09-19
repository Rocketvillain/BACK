package com.rocket.healingpets.hospitals.model.dto.OffTime;

import lombok.*;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
public class OffTimeDTO {
    private int offTimeId;
    private LocalTime startTime;
    private LocalTime endTime;
}
