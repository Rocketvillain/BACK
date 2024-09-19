package com.rocket.healingpets.hospitals.controller;

import com.rocket.healingpets.common.ResponseMessage;
import com.rocket.healingpets.hospitals.model.dto.ClinicType.CreateClinicTypeDTO;
import com.rocket.healingpets.hospitals.model.dto.ClinicType.UpdateClinicTypeDTO;
import com.rocket.healingpets.hospitals.model.entity.ClinicType;
import com.rocket.healingpets.hospitals.service.ClinicTypeService;
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
@RequestMapping("/api/v1/hospital/clinicType")
@Slf4j
@RequiredArgsConstructor
public class ClinicTypeController {

    private final ClinicTypeService clinicTypeService;

    @Operation(summary = "전체 진료 유형 조회")
    @GetMapping("")
    public ResponseEntity<ResponseMessage> findAllClinicType() {

        List<ClinicType> allClinicType = clinicTypeService.findAllClinicType();

        log.info("조회된 전체 진료 유형 정보 : {}", allClinicType);

        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("clinicType", allClinicType);

        return ResponseEntity.ok()
                .body
                        (new ResponseMessage(
                                HttpStatus.OK,
                                "전체 진료 유형 목록을 불러옵니다.",
                                responseMap
                        ));
    }

    @Operation(summary = "병원 아이디로 해당 진료 유형 조회")
    @GetMapping("/{hosId}")
    public ResponseEntity<ResponseMessage> findClinicTypesByHosId(@PathVariable int hosId) {

        List<ClinicType> foundClinicTypes = clinicTypeService.findClinicTypesByHosId(hosId);

        log.info("조회된 진료 유형 정보 : {}", foundClinicTypes);

        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("hospital", foundClinicTypes);

        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK, hosId+"번 병원의 진료 유형을 불러옵니다...", responseMap));
    }

    @Operation(summary = "진료 유형 등록")
    @PostMapping("")
    public ResponseEntity<ResponseMessage> registClinicType(@RequestBody CreateClinicTypeDTO clinicTypeDTO) {

        ClinicType savedClinicType = clinicTypeService.registClinicType(clinicTypeDTO);

        log.info("등록된 진료 유형 정보 : {}", savedClinicType);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("clinicType", savedClinicType);

        return ResponseEntity
                .created(URI.create("/clinicType/" + savedClinicType.getHosId()))
                .body(new ResponseMessage(HttpStatus.CREATED, savedClinicType.getHosId()+"번 진료 유형 등록 성공", responseMap));
    }

    @Operation(summary = "진료 유형 정보 수정")
    @PutMapping("/{typeId}")
    public ResponseEntity<ResponseMessage> modifyClinicType(@PathVariable int typeId, @RequestBody UpdateClinicTypeDTO clinicTypeDTO) {

        ClinicType modifiedClinicType = clinicTypeService.modifyClinicType(typeId, clinicTypeDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("clinicType", modifiedClinicType);

        return ResponseEntity.created(URI.create("/hospital/" + typeId))
                .body(new ResponseMessage(HttpStatus.OK, "진료 유형 수정 성공", responseMap));
    }

    @DeleteMapping("/{typeId}")
    @Operation(summary = "진료 유형 삭제")
    public ResponseEntity<ResponseMessage> deleteClinicType(@PathVariable int typeId) {
        clinicTypeService.deleteClinicType(typeId);

        return ResponseEntity
                .ok()
                .body(new ResponseMessage(HttpStatus.NO_CONTENT, "진료 유형 삭제 성공"));
    }


}

