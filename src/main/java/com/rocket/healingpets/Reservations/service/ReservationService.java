package com.rocket.healingpets.Reservations.service;

import com.rocket.healingpets.Reservations.repository.ReservationsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ReservationService {

    private final ReservationsRepository reservationsRepository;

    // 예약 등록
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

}
