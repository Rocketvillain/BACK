package com.rocket.healingpets.Reservations.controller;

import com.rocket.healingpets.Reservations.model.dto.CreateReservationDTO;
import com.rocket.healingpets.Reservations.model.dto.ReservationDTO;
import com.rocket.healingpets.Reservations.model.dto.UpdateReservationDTO;
import com.rocket.healingpets.Reservations.model.entity.Reservation;
import com.rocket.healingpets.Reservations.service.ReservationService;
import com.rocket.healingpets.common.ResponseMessage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/reservation")
@Slf4j
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final ModelMapper modelMapper;

    // 예약 전체 조회
    @GetMapping("")
    @Operation(summary = "예약 전체 조회")
    public ResponseEntity<ResponseMessage> findAllReservations() {
        List<ReservationDTO> reservations = reservationService.findAllReservations()
                .stream()
                .map(reservation -> {
                    ReservationDTO dto = new ReservationDTO();
                    dto.setReservationId(reservation.getReservationId());

                    // 유저 파트
                    dto.setUserid(reservation.getUserid()); // 유저 아이디
                    dto.setUserName(reservation.getUserName()); // 유저 이름
                    dto.setUserEmail(reservation.getUserEmail()); // 이메일
                    dto.setUserPhone(reservation.getUserPhone()); // 전화번호
                    dto.setPetId(reservation.getPetId()); // 펫 id (추가)

                    // 병원 파트
                    dto.setHosName(reservation.getHosName()); // 병원 이름
                    dto.setClinicName(reservation.getClinicName()); // 진료 유형
                    dto.setDescription(reservation.getDescription()); // 설명
                    dto.setSpecificDescription(reservation.getSpecificDescription()); // 상세 설명
                    dto.setState(reservation.getState());
                    dto.setReservationTime(reservation.getReservationTime());
                    dto.setLastModifiedDate(reservation.getLastModifiedDate());
                    return dto;
                })
                .collect(Collectors.toList());

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("reservations", reservations);

        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK, "예약 전체 조회", responseMap));
    }

    //예약 단일 조회
    @GetMapping("/{reservation_id}")
    @Operation(summary = "예약 단일 조회")
    public ResponseEntity<ResponseMessage> findReservationById(@PathVariable int reservation_id){

        ReservationDTO reservationDTO = reservationService.findReservationById(String.valueOf(reservation_id));

        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("reservation", reservationDTO);

        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK,"예약 단일 조회",responseMap));

    }

    // 예약 등록
    @PostMapping("")
    @Operation(summary = "예약 등록")

    public ResponseEntity<ResponseMessage> registReservations (@RequestBody CreateReservationDTO createReservationDTO){

        ReservationDTO saveReservation = reservationService.registReservation(createReservationDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("reservation", saveReservation);

        return ResponseEntity
                .created(URI.create("/reservation/" + saveReservation.getReservationId()))
                .body(new ResponseMessage(HttpStatus.CREATED,"예약 등록 성공",responseMap));
    }

    //예약 수정
    @PostMapping("{reservation_id}")
    @Operation(summary = "예약 수정")
    public ResponseEntity<ResponseMessage> modifyReservation (@PathVariable int reservation_id, @RequestBody UpdateReservationDTO updateReservationDTO){

        ReservationDTO modifiedReservation = reservationService.updateReservations(reservation_id, updateReservationDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("reservation", modifiedReservation);

        return ResponseEntity.created(URI.create("/entity/Reservation/" + reservation_id))
                .body(new ResponseMessage(HttpStatus.OK,"예약 수정 성공",responseMap));
    }

    @Operation(summary = "예약 삭제")
    @DeleteMapping("/{reservation_id}")
    public ResponseEntity<ResponseMessage> deleteReservationById(@PathVariable int reservation_id){

        reservationService.deleteReservationById(reservation_id);

        Map<String,Object> responseMap = new HashMap<>();
        responseMap.put("message","유저 삭제 성공");

        return ResponseEntity.ok()
                .body(new ResponseMessage(HttpStatus.OK,("유저 삭제 성공")));
    }
}
