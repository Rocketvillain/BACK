package com.rocket.healingpets.Reservations.service;

import com.rocket.healingpets.Reservations.model.dto.CreateReservationDTO;
import com.rocket.healingpets.Reservations.model.dto.ReservationDTO;
import com.rocket.healingpets.Reservations.model.dto.UpdateReservationDTO;
import com.rocket.healingpets.Reservations.model.entity.Reservation;
import com.rocket.healingpets.Reservations.repository.ReservationsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    // 예약 전체 조회
    public List<ReservationDTO> findAllReservations() {
        List<Reservation> allReservation = reservationsRepository.findAll();

        return allReservation.stream()
                .map(reservation -> modelMapper.map(reservation, ReservationDTO.class))
                .collect(Collectors.toList());

    }

    // 예약 단일 조회
    public Reservation findReservationById(String reservation_id) {
        Reservation reservation = reservationsRepository.findById(Integer.valueOf(reservation_id))
                .orElseThrow(() -> new EntityNotFoundException("예약을 조회할 수 없습니다."));

        return reservation;

    }

//    // 예약 등록
//    public Reservation registReservation(CreateReservationDTO reservationDTO) {
//
//        new ReviewReport();
//        new Review();
//        Reservation reservation = Reservation.builder()
//                .clinicType(new ClinicType())
//                .userId(new User())
//                .hosId(new Hospital())
//                .review(Review
//                        .builder()
//                        .title("sss")
//                        .reviewReport(ReviewReport
//                                .builder()
//                                .reportState("deactivated")
//                                .build())
//                        .build())
//                .build();
//
//
//        return reservationsRepository.save(reservation);
//    }

//    // 예약 수정
//    public Reservation updateReservations(int reservation_id, UpdateReservationDTO updateReservationDTO){
//
//        Reservation reservation = reservationsRepository.findById(reservation_id)
//                .orElseThrow(()-> new EntityNotFoundException("예약 정보를 찾을수 없습니다."));
//
//
//    }
//
//    // 예약 삭제
//    public void deleteReservationById(int reservation_id){
//
//        reservationsRepository.deleteById(reservation_id);
//    }
}
