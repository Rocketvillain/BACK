package com.rocket.healingpets.Reservations.service;

import com.rocket.healingpets.Reservations.model.dto.CreateReservationDTO;
import com.rocket.healingpets.Reservations.model.dto.ReservationDTO;
import com.rocket.healingpets.hospitals.model.entity.ClinicType;
import com.rocket.healingpets.hospitals.model.entity.Hospital;
import com.rocket.healingpets.hospitals.repository.HospitalRepository;
import com.rocket.healingpets.users.model.entitiy.User;

import com.rocket.healingpets.Reservations.model.dto.UpdateReservationDTO;
import com.rocket.healingpets.Reservations.model.entity.Reservation;
import com.rocket.healingpets.Reservations.repository.ReservationsRepository;
import com.rocket.healingpets.common.ResponseMessage;
import com.rocket.healingpets.users.repository.UserRepository;
import com.rocket.healingpets.users.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ReservationService {

    private final ReservationsRepository reservationsRepository;
    private final UserRepository userRepository;
    private final HospitalRepository hospitalRepository;
    private final ModelMapper modelMapper;

    // 예약 전체 조회
    public List<ReservationDTO> findAllReservations() {
        List<Reservation> allReservation = reservationsRepository.findAll();

        return allReservation.stream()
                .map(reservation -> modelMapper.map(reservation, ReservationDTO.class))
                .collect(Collectors.toList());

    }

    // 예약 단일 조회
    public ReservationDTO findReservationById(String reservation_id) {
        Reservation reservation = reservationsRepository.findById(Integer.valueOf(reservation_id))
                .orElseThrow(() -> new EntityNotFoundException("예약을 조회할 수 없습니다."));

        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setReservationId(reservation.getReservationId());
        reservationDTO.setUserid(reservation.getUserId().getUserId());
        reservationDTO.setUserName(reservation.getUserId().getUserName());
        reservationDTO.setUserEmail(reservation.getUserId().getEmail());
        reservationDTO.setUserPhone(reservation.getUserId().getPhone());
        reservationDTO.setHosName(reservation.getHosId().getName());
        reservationDTO.setClinicName(reservation.getClinicType().getClinicName());
        reservationDTO.setDescription(reservation.getDescription());
        reservationDTO.setSpecificDescription(reservation.getSpecificDescription());
        reservationDTO.setState(reservation.getState());
        reservationDTO.setReservationDate(reservation.getReservationDate());

         return reservationDTO;
    }

    // 예약 등록
    public ReservationDTO registReservation(CreateReservationDTO createReservationDTO) {

        // User 객체를 조회
        User user = userRepository.findById(createReservationDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("사용자를 찾을 수 없습니다."));

        // 병원 객체를 조회
        Hospital hospital = hospitalRepository.findByid(createReservationDTO.getHosId())
                .orElseThrow(() -> new EntityNotFoundException("병원을 찾을 수 없습니다."));



        Reservation reservation = Reservation.builder()
                .userId(user)
                .hosId(hospital)
                .clinicType()
                .description(createReservationDTO.getDescription()) // DTO에서 description 가져오기
                .specificDescription(createReservationDTO.getSpecificDescription()) // DTO에서 specificDescription 가져오기
                .reservationDate(createReservationDTO.getReservationDate()) // 예약 날짜 추가
                .build();

        Reservation savedReservation = reservationsRepository.save(reservation);

        return ReservationDTO.builder()  // ReservationDTO로 반환
                .userid(savedReservation.getUserId().getUserId())
                .userName(savedReservation.getUserId().getUserName())
                .userEmail(savedReservation.getUserId().getEmail())
                .userPhone(savedReservation.getUserId().getPhone())
                .hosName(savedReservation.getHosId().getName())
                .clinicName(savedReservation.getClinicType().getClinicName())
                .description(savedReservation.getDescription())
                .specificDescription(savedReservation.getSpecificDescription())
                .reservationDate(savedReservation.getReservationDate()) // 예약 날짜 추가
                .build();
    }

//    // 예약 수정
//    public ReservationDTO updateReservations(int reservation_id, UpdateReservationDTO updateReservationDTO){
//
//        Reservation reservation = reservationsRepository.findById(reservation_id)
//                .orElseThrow(()-> new EntityNotFoundException("예약 정보를 찾을수 없습니다." + reservation_id));
//
//        reservation  = reservation.toBuilder()
////                .clinicType(updateReservationDTO.getClinicType())
//                .description(updateReservationDTO.getDescription())
//                .specificDescription(updateReservationDTO.getSpecificDescription())
////                .state(updateReservationDTO.getState())
////                .lastModifiedDate(updateReservationDTO.getLastModifiedDate())
//                .build();
//
//
//
//        return reservationsRepository.save(reservation);
//    }

    // 예약 삭제
    public void deleteReservationById(int reservation_id){

        reservationsRepository.deleteById(reservation_id);
    }
}
