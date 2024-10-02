package com.rocket.healingpets.users.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rocket.healingpets.common.ResponseMessage;
import com.rocket.healingpets.hospitals.model.entity.ClinicType;
import com.rocket.healingpets.hospitals.model.entity.Hospital;
import com.rocket.healingpets.hospitals.repository.ClinicTypeRepository;
import com.rocket.healingpets.users.model.dto.*;
import com.rocket.healingpets.users.model.entitiy.Pet;
import com.rocket.healingpets.users.model.entitiy.User;
import com.rocket.healingpets.users.repository.UserRepository;
import com.rocket.healingpets.users.service.AuthService;
import com.rocket.healingpets.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final ClinicTypeRepository clinicTypeRepository;
    private UserRepository userRepository;


    @Autowired
    public AuthController(AuthService authService, UserRepository userRepository, ClinicTypeRepository clinicTypeRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
        this.clinicTypeRepository = clinicTypeRepository;
    }

    // 회원가입 요청
    @Operation(summary = "회원가입 (회원 등록)")
    @PostMapping("/signup")
    public ResponseEntity<ResponseMessage> signup(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);

        // 사용자 정보 저장
        UserDTO savedUserDTO = authService.signup(userDTO);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> userMap = objectMapper.convertValue(savedUserDTO, Map.class);

        if(userDTO.getPetInfo() != null ){
            CreatePetDTO2 petDTO2 = userDTO.getPetInfo(); // userDTO에서 펫 정보를 가져옴

            // User 객체 생성하고 userId 설정
            User user = new User();
            user.setUserId(savedUserDTO.getUserId()); // 저장된 사용자 ID 설정

            // Pet 엔티티를 생성하고, 로그인한 사용자의 ID를 설정
            Pet pet = Pet.builder()
                    .user(user)
                    .petName(petDTO2.getPetName())
                    .gender(petDTO2.getGender())
                    .weight(petDTO2.getWeight())
                    .age(petDTO2.getAge())
                    .species(petDTO2.getSpecies())
                    .kind(petDTO2.getKind())
                    .build();

            // 펫 등록
            PetDTO2 registeredPet = authService.registerPet2(pet);

            // 펫 등록 성공
            Map<String, Object> petResponseMap = new HashMap<>();
            petResponseMap.put("pet",registeredPet);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseMessage(HttpStatus.CREATED,"회원 가입성공 및 펫 등록 성공",petResponseMap));
        }

        return ResponseEntity
                .ok()
                .body(new ResponseMessage(HttpStatus.CREATED, "회원가입 성공", userMap));
    }

    // 회원가입 요청2
    @Operation(summary = "회원가입 (병원 관리자 등록)")
    @PostMapping("/signup2")
    public ResponseEntity<ResponseMessage> signup2(@RequestBody UserDTO2 userDTO2) {
        System.out.println(userDTO2);

        // 사용자 정보 저장
        UserDTO2 savedUserDTO = authService.signup2(userDTO2);

        CreateHospitalDTO2 hosDTO2 = userDTO2.getHosInfo(); // userDTO에서 병원 정보를 가져옴

        // User 객체 생성하고 userId 설정
        User user = new User();
        user.setUserId(savedUserDTO.getUserId()); // 저장된 사용자 ID 설정
        user.setEmail(userDTO2.getEmail()); // 이메일 설정 (필요한 경우)

        // 병원 엔티티를 생성하고, 로그인한 사용자의 ID를 설정
        Hospital hospital = Hospital.builder()
                .user(user)
                .name(hosDTO2.getHospitalName())
                .address(hosDTO2.getAddress())
                .businessNo(hosDTO2.getBusinessNo())
                .ownerName(hosDTO2.getOwnerName())
                .clinicType(hosDTO2.getClinicType())
                .build();

            // 병원 등록
            HospitalDTO2 registeredHospital = authService.registHospital(hospital);

            // 병원 등록 후 hosId를 user와 clinicType에 설정
            user.setHosId(registeredHospital.getHosId());

            // ClinicType에 hosId를 설정
            for(ClinicType clinicType : hospital.getClinicType()){
                clinicType.setHosId(registeredHospital.getHosId());
            }

            // 유저 정보 업데이트
            authService.updateUser(user);

            //클리닉 타입 저장
            clinicTypeRepository.saveAll(hospital.getClinicType());


            // 병원 등록 성공
            Map<String, Object> hospitalResponseMap = new HashMap<>();
            hospitalResponseMap.put("hospital",registeredHospital);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseMessage(HttpStatus.CREATED," 병원 등록 성공",hospitalResponseMap));

    }

    @Operation(summary = "인증 코드 보내기")
    @PostMapping("/send-code")
    public ResponseEntity<String> sendAuthCode(@RequestBody EmailDTO emailDTO) {
        String email = emailDTO.getEmail();
        authService.sendAuthCode(email);
        return ResponseEntity.ok("인증 코드가 이메일로 전송되었습니다.");
    }

    @Operation(summary = "코드 인증하기")
    @PostMapping("/verify-code")
    public ResponseEntity<String> verifyCode(@RequestBody EmailCheckDTO emailCheckDTO) {
        boolean isValid = authService.verifyAuthCode(emailCheckDTO.getEmail(), emailCheckDTO.getCode());
        return isValid ? ResponseEntity.ok("인증 성공") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("인증 실패");
    }

    // 중복확인
    @Operation(summary = "중복확인")
    @GetMapping("/check-duplicate")
    public ResponseEntity<Boolean> checkDuplicate(@RequestParam String userId) {
        boolean exists = userRepository.existsByUserId(userId);
        return ResponseEntity.ok(exists);
    }

    // ID찾기
    @Operation(summary = "ID찾기")
    @GetMapping("/find-id")
    public ResponseEntity<ResponseMessage> findId(@RequestParam String name, @RequestParam String phone) {
        String userId = authService.findUserId(name, phone);

        if (userId != null) {
            // ID 찾기 성공
            Map<String, Object> results = new HashMap<>();
            results.put("userId", userId); // 사용자 ID를 결과에 추가

            return ResponseEntity.ok(new ResponseMessage(HttpStatus.OK, "ID 찾기 성공", results));
        } else {
            // 사용자 찾기 실패
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseMessage(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다.", null));
        }
    }

    // 비밀번호 변경 요청
    @Operation(summary = "비밀번호 변경 요청")
    @PostMapping("/request-reset-password")
    public ResponseEntity<ResponseMessage> requestResetPassword(@RequestBody RequestResetPWDDTO request) {

        try {
            // 사용자 정보 확인
            User user = userRepository.findByUserIdAndUserNameAndEmail(request.getUserId(), request.getName(), request.getEmail());

            if (user == null) {
                return ResponseEntity.badRequest()
                        .body(new ResponseMessage(HttpStatus.BAD_REQUEST, "사용자를 찾을 수 없습니다."));
            }

            // 인증 코드 전송 밎 저장
            authService.sendAuthCode(request.getEmail());

            return ResponseEntity.ok(new ResponseMessage(HttpStatus.OK, "인증코드가 전송되었습니다."));

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ResponseMessage(HttpStatus.BAD_REQUEST, "오류 발생" + e.getMessage()));
        }

    }

    // 비밀번호 변경
    @Operation(summary = "비밀번호 변경")
    @PutMapping("/reset-password")
    public ResponseEntity<ResponseMessage> changePwd(@RequestBody ChangePWDDTO request) {

        try {

            boolean isChanged = authService.changePassword(request.getUserId(), request.getName(), request.getEmail(), request.getNewPassword(), request.getCode());
            if (isChanged) {
                return ResponseEntity.ok(new ResponseMessage(HttpStatus.OK, "비밀번호가 변경되었습니다."));
            }
            return ResponseEntity.badRequest().body(new ResponseMessage(HttpStatus.BAD_REQUEST, "비밀번호 변경 실패."));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ResponseMessage(HttpStatus.BAD_REQUEST, "인증 실패"));
        }
    }

}
