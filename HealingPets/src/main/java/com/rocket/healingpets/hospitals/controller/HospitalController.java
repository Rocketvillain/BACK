package com.rocket.healingpets.hospitals.controller;

import com.rocket.healingpets.common.ResponseMessage;
import com.rocket.healingpets.hospitals.model.dto.CreateHospitalDTO;
import com.rocket.healingpets.hospitals.model.dto.UpdateHospitalDTO;
import com.rocket.healingpets.hospitals.model.entity.Hospital;
import com.rocket.healingpets.hospitals.service.HospitalService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/api/v1/hospital")
@Slf4j
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @Operation(summary = "전체 병원 조회")
    @GetMapping("")
    public ResponseEntity<ResponseMessage> findAllComments() {

        List<Hospital> allHospitals = hospitalService.findAllHospital();

        log.info("조회된 전체 병원 정보 : {}", allHospitals);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("hospital", allHospitals);
        log.info(responseMap.toString());

        return ResponseEntity.ok()
                .body
                        (new ResponseMessage(
                                HttpStatus.OK,
                                "전체 병원 목록을 불러옵니다.",
                                responseMap
                        ));
    }

    @Operation(summary = "병원 아이디로 해당 병원 조회")
    @GetMapping("/{hosId}")
    public ResponseEntity<ResponseMessage> findHospitalById(@PathVariable int hosId) {

        Hospital foundHospital = hospitalService.findHospitalById(hosId);

        log.info("조회된 병원 정보 : {}", foundHospital);

        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("hospital", foundHospital);

        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK, hosId+"번 게시글의 댓글들을 불러옵니다...", responseMap));
    }

    @Operation(summary = "병원 등록")
    @PostMapping("")
    public ResponseEntity<ResponseMessage> registHospital(@RequestBody CreateHospitalDTO hospitalDTO) {

        Hospital savedHospital = hospitalService.registHospital(hospitalDTO);

        log.info("등록된 병원 정보 : {}", savedHospital);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("hospital", savedHospital);

        return ResponseEntity
                .created(URI.create("/hospital/" + savedHospital.getHosId()))
                .body(new ResponseMessage(HttpStatus.CREATED, savedHospital.getHosId()+"번 병원 등록 성공", responseMap));
    }

    @Operation(summary = "병원 정보 수정")
    @PutMapping("/{hosId}")
    public ResponseEntity<ResponseMessage> modifyHospital(@PathVariable int hosId, @RequestBody UpdateHospitalDTO hospitalDTO) {

        Hospital modifiedHospital = hospitalService.modifyHospital(hosId, hospitalDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("hospital", modifiedHospital);

        return ResponseEntity.created(URI.create("/hospital/" + hosId))
                .body(new ResponseMessage(HttpStatus.OK, "댓글 수정 성공", responseMap));
    }

    @DeleteMapping("/{hosId}")
    @Operation(summary = "병원 삭제")
    public ResponseEntity<ResponseMessage> deleteHospital(@PathVariable int hosId) {
        hospitalService.deleteHospital(hosId);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT) // 204 상태 코드 반환
                .body(new ResponseMessage(HttpStatus.NO_CONTENT, "병원 삭제 성공"));
    }


}
