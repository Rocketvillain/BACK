package com.rocket.healingpets.hospitals.controller;

import com.rocket.healingpets.common.ResponseMessage;
import com.rocket.healingpets.hospitals.model.dto.HospitalSchedule.HospitalScheduleDTO;
import com.rocket.healingpets.hospitals.model.dto.OffTime.OffTimeDTO;
import com.rocket.healingpets.hospitals.service.HospitalScheduleService;
import com.rocket.healingpets.hospitals.service.OffTimeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/hospital/offTime")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "OffTime",description = "병원 미진료시간")
public class OffTimeController {

    private final OffTimeService offTimeService;
    private final HospitalScheduleService hospitalScheduleService;

//    @Operation(summary = "전체 병원 미진료시간 조회")
//    @GetMapping("")
//    public ResponseEntity<ResponseMessage> findAllOffTime() {
//
//        List<OffTimeDTO> allOffTimes = offTimeService.findAllOffTime();
//
//        log.info("조회된 전체 병원 미진료시간 정보 : {}", allOffTimes);
//
//        Map<String, Object> responseMap = new HashMap<>();
//
//        responseMap.put("offTime", allOffTimes);
//
//        log.info(responseMap.toString());
//
//        return ResponseEntity.ok()
//                .body
//                        (new ResponseMessage(
//                                HttpStatus.OK,
//                                "전체 병원 미진료시간 목록을 불러옵니다.",
//                                responseMap
//                        ));
//    }

    @Operation(summary = "병원 아이디로 해당 병원 미진료시간 전체 조회")
    @GetMapping("/{hosId}")
    public ResponseEntity<ResponseMessage> findOffTimesByHospitalId(@PathVariable int hosId) {

        List<HospitalScheduleDTO> foundHospitalSchedule = hospitalScheduleService.findHospitalSchedulesByHospitalId(hosId);

        List<OffTimeDTO> offTimeDTOs = foundHospitalSchedule.stream()
                .flatMap(schedule -> schedule.getOffTime().stream()
                        .map(offTime -> new OffTimeDTO(
                                offTime.getOffTimeId(), // OffTime ID
                                schedule.getDate(), // 일정 날짜
                                offTime.getStartTime(), // 미진료 시작 시간
                                offTime.getEndTime() // 미진료 종료 시간
                        )))
                .toList(); // List로 변환

        log.info("조회된 병원 미진료시간 정보 : {}", offTimeDTOs);

        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("offTime", offTimeDTOs);

        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK, hosId+"번 병원의 미진료시간을 불러옵니다...", responseMap));
    }

//    @Operation(summary = "병원 미진료시간 등록")
//    @PostMapping("")
//    public ResponseEntity<ResponseMessage> registOffTime(@RequestBody CreateOffTimeDTO hospitalScheduleDTO) {
//
//        OffTimeDTO savedOffTime = offTimeService.registOffTime(hospitalScheduleDTO);
//
//        log.info("등록된 병원 미진료시간 정보 : {}", savedOffTime);
//
//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.put("offTime", savedOffTime);
//
//        return ResponseEntity
//                .created(URI.create("/offTime/" + savedOffTime.getHosId()))
//                .body(new ResponseMessage(HttpStatus.CREATED, savedOffTime.getHosId()+"번 병원 미진료시간 등록 성공", responseMap));
//    }
//
//    @Operation(summary = "병원 미진료시간 정보 수정")
//    @PutMapping("/{scheduleId}")
//    public ResponseEntity<ResponseMessage> modifyOffTime(@PathVariable int scheduleId, @RequestBody UpdateOffTimeDTO hospitalScheduleDTO) {
//
//        OffTimeDTO modifiedOffTime = offTimeService.modifyOffTime(scheduleId, hospitalScheduleDTO);
//
//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.put("offTime", modifiedOffTime);
//
//        return ResponseEntity.created(URI.create("/offTime/" + scheduleId))
//                .body(new ResponseMessage(HttpStatus.OK, "병원 미진료시간 수정 성공", responseMap));
//    }
//
//    @DeleteMapping("/{scheduleId}")
//    @Operation(summary = "병원 미진료시간 삭제")
//    public ResponseEntity<ResponseMessage> deleteOffTime(@PathVariable int scheduleId) {
//        offTimeService.deleteOffTime(scheduleId);
//
//        return ResponseEntity
//                .ok()
//                .body(new ResponseMessage(HttpStatus.NO_CONTENT, "병원 미진료시간 삭제 성공"));
//    }

}
