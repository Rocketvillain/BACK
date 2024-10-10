package com.rocket.healingpets.users.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rocket.healingpets.common.ResponseMessage;
import com.rocket.healingpets.users.model.dto.*;
import com.rocket.healingpets.users.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @Operation(summary = "로그인 회원의 펫 전체 조회")
    @GetMapping("/myPet")
    public ResponseEntity<ResponseMessage> findAllPetsByUser() {
        List<PetDTO> pets = petService.findAllPetsByLoggedInUser();
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("pets", pets);
        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK, "펫 전체 조회 성공", responseMap));
    }

    @Operation(summary = "회원의 펫 등록")
    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> registerPet(
            @RequestParam("petInfo") String petInfoJson, // JSON 문자열로 받기
            @RequestParam(value = "image", required = false) MultipartFile image) {
        try {
            // JSON 문자열을 CreatePetDTO로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            CreatePetDTO createPetDTO = objectMapper.readValue(petInfoJson, CreatePetDTO.class);

            // 펫 등록 서비스 호출
            PetDTO registerPet = petService.registerPet(createPetDTO, image);
            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("pet", registerPet);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseMessage(HttpStatus.CREATED, "펫 등록 성공", responseMap));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseMessage(HttpStatus.BAD_REQUEST, "펫 등록 중 오류 발생: " + e.getMessage()));
        }
    }


    @Operation(summary = "회원의 펫 정보 수정")
    @PutMapping("/update/{petId}")
    public ResponseEntity<ResponseMessage> modifyPet(
            @PathVariable int petId,
            @RequestPart("petInfo") UpdatePetDTO updatePetDTO,
            @RequestPart(value = "image", required = false) MultipartFile image) {

        PetDTO modifyPet = petService.modifyPet(petId, updatePetDTO, image);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("pet", modifyPet);
        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK, "펫 수정 성공", responseMap));
    }


    @Operation(summary = "회원의 펫 삭제")
    @DeleteMapping("/delete/{petId}")
    public ResponseEntity<ResponseMessage> deletePet(@PathVariable int petId) {
        petService.deletePet(petId);
        return ResponseEntity.ok().body(new ResponseMessage(HttpStatus.OK, "펫 삭제 성공"));
    }

}
