package com.rocket.healingpets.users.controller;

import com.rocket.healingpets.common.ResponseMessage;
import com.rocket.healingpets.users.model.dto.*;
import com.rocket.healingpets.users.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @Operation(summary = "회원의 펫 전체 조회")
    @GetMapping("/{userId}")
    public ResponseEntity<ResponseMessage> findAllPetsByUser() {
        List<PetDTO> pets = petService.findAllPetsByLoggedInUser();
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("pets", pets);
        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK, "펫 전체 조회 성공", responseMap));
    }

    @Operation(summary = "회원의 펫 등록")
    @PostMapping("")
    public ResponseEntity<ResponseMessage> registerPet(@RequestBody CreatePetDTO createPetDTO) {
        PetDTO registerPet = petService.registerPet(createPetDTO);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("pet", registerPet);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseMessage(HttpStatus.CREATED, "펫 등록 성공", responseMap));
    }

    @Operation(summary = "회원의 펫 정보 수정")
    @PutMapping("/{petId}")
    public ResponseEntity<ResponseMessage> modifyPet(@PathVariable int petId, @RequestBody UpdatePetDTO updatePetDTO) {
        PetDTO modifyPet = petService.modifyPet(petId, updatePetDTO);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("pet", modifyPet);
        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK, "펫 수정 성공", responseMap));
    }

    @Operation(summary = "회원의 펫 삭제")
    @DeleteMapping("/{petId}")
    public ResponseEntity<ResponseMessage> deletePet(@PathVariable int petId) {
        petService.deletePet(petId);
        return ResponseEntity.ok().body(new ResponseMessage(HttpStatus.OK, "펫 삭제 성공"));
    }

}
