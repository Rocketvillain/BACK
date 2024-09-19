package com.rocket.healingpets.hospitals.controller;

import com.rocket.healingpets.common.ResponseMessage;
import com.rocket.healingpets.hospitals.model.dto.HospitalSchedule.CreateHospitalScheduleDTO;
import com.rocket.healingpets.hospitals.model.dto.HospitalSchedule.HospitalScheduleDTO;
import com.rocket.healingpets.hospitals.model.dto.HospitalSchedule.UpdateHospitalScheduleDTO;
import com.rocket.healingpets.hospitals.model.entity.HospitalSchedule;
import com.rocket.healingpets.hospitals.service.HospitalScheduleService;
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

@RestController
@RequestMapping("/api/v1/hospital/schedule")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "HospitalSchedule",description = "병원 일정")
public class HospitalScheduleController {

    private final HospitalScheduleService hospitalScheduleService;

    @Operation(summary = "전체 병원 일정 조회")
    @GetMapping("")
    public ResponseEntity<ResponseMessage> findAllHospitalSchedule() {

        List<HospitalScheduleDTO> allHospitalSchedules = hospitalScheduleService.findAllHospitalSchedule();

        log.info("조회된 전체 병원 일정 정보 : {}", allHospitalSchedules);

        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("hospitalSchedule", allHospitalSchedules);

        log.info(responseMap.toString());

        return ResponseEntity.ok()
                .body
                        (new ResponseMessage(
                                HttpStatus.OK,
                                "전체 병원 일정 목록을 불러옵니다.",
                                responseMap
                        ));
    }

    @Operation(summary = "병원 아이디로 해당 병원 일정 조회")
    @GetMapping("/{hosId}")
    public ResponseEntity<ResponseMessage> findHospitalSchedulesByHospitalId(@PathVariable int hosId) {

        List<HospitalScheduleDTO> foundHospitalSchedule = hospitalScheduleService.findHospitalSchedulesByHospitalId(hosId);

        log.info("조회된 병원 일정 정보 : {}", foundHospitalSchedule);

        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("hospitalSchedule", foundHospitalSchedule);

        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK, hosId+"번 병원의 일정을 불러옵니다...", responseMap));
    }

    @Operation(summary = "병원 일정 등록")
    @PostMapping("")
    public ResponseEntity<ResponseMessage> registHospitalSchedule(@RequestBody CreateHospitalScheduleDTO hospitalScheduleDTO) {

        HospitalScheduleDTO savedHospitalSchedule = hospitalScheduleService.registHospitalSchedule(hospitalScheduleDTO);

        log.info("등록된 병원 일정 정보 : {}", savedHospitalSchedule);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("hospitalSchedule", savedHospitalSchedule);

        return ResponseEntity
                .created(URI.create("/hospitalSchedule/" + savedHospitalSchedule.getHosId()))
                .body(new ResponseMessage(HttpStatus.CREATED, savedHospitalSchedule.getHosId()+"번 병원 일정 등록 성공", responseMap));
    }

    @Operation(summary = "병원 일정 정보 수정")
    @PutMapping("/{scheduleId}")
    public ResponseEntity<ResponseMessage> modifyHospitalSchedule(@PathVariable int scheduleId, @RequestBody UpdateHospitalScheduleDTO hospitalScheduleDTO) {

        HospitalScheduleDTO modifiedHospitalSchedule = hospitalScheduleService.modifyHospitalSchedule(scheduleId, hospitalScheduleDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("hospitalSchedule", modifiedHospitalSchedule);

        return ResponseEntity.created(URI.create("/hospitalSchedule/" + scheduleId))
                .body(new ResponseMessage(HttpStatus.OK, "병원 일정 수정 성공", responseMap));
    }

    @DeleteMapping("/{scheduleId}")
    @Operation(summary = "병원 일정 삭제")
    public ResponseEntity<ResponseMessage> deleteHospitalSchedule(@PathVariable int scheduleId) {
        hospitalScheduleService.deleteHospitalSchedule(scheduleId);

        return ResponseEntity
                .ok()
                .body(new ResponseMessage(HttpStatus.NO_CONTENT, "병원 일정 삭제 성공"));
    }
}
