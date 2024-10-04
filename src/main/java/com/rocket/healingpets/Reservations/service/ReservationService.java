package com.rocket.healingpets.Reservations.service;

import com.rocket.healingpets.Reservations.model.dto.CreateReservationDTO;
import com.rocket.healingpets.Reservations.model.dto.ReservationDTO;
import com.rocket.healingpets.hospitals.model.entity.ClinicType;
import com.rocket.healingpets.hospitals.model.entity.Hospital;
import com.rocket.healingpets.hospitals.repository.ClinicTypeRepository;
import com.rocket.healingpets.hospitals.repository.HospitalRepository;
import com.rocket.healingpets.users.model.entitiy.Pet;
import com.rocket.healingpets.users.model.entitiy.User;

import com.rocket.healingpets.Reservations.model.dto.UpdateReservationDTO;
import com.rocket.healingpets.Reservations.model.entity.Reservation;
import com.rocket.healingpets.Reservations.repository.ReservationsRepository;
import com.rocket.healingpets.common.ResponseMessage;
import com.rocket.healingpets.users.repository.PetRepository;
import com.rocket.healingpets.users.repository.UserRepository;
import com.rocket.healingpets.users.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
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
    private final ClinicTypeRepository clinicTypeRepository;
    private final ModelMapper modelMapper;
    private final PetRepository petRepository;


    // 예약 전체 조회
    public List<ReservationDTO> findAllReservations() {
        List<Reservation> allReservation = reservationsRepository.findAll();

        return allReservation.stream()
                .map(reservation -> {
                    ReservationDTO reservationDTO = new ReservationDTO();
                    reservationDTO.setReservationId(reservation.getReservationId());
                    reservationDTO.setUserid(reservation.getUserId().getUserId());
                    reservationDTO.setUserName(reservation.getUserId().getUserName());
                    reservationDTO.setUserEmail(reservation.getUserId().getEmail());
                    reservationDTO.setUserPhone(reservation.getUserId().getPhone());
                    reservationDTO.setPetId(reservation.getPetId().getPetId()); // 추가 petId
                    reservationDTO.setPetName(reservation.getPetId().getPetName());
                    reservationDTO.setHosName(reservation.getHosId().getName());
                    reservationDTO.setClinicName(reservation.getClinicType().getClinicName());
                    reservationDTO.setDescription(reservation.getDescription());
                    reservationDTO.setSpecificDescription(reservation.getSpecificDescription());
                    reservationDTO.setState(reservation.getState());
                    reservationDTO.setReservationTime(reservation.getReservationTime());
                    reservationDTO.setLastModifiedDate(reservation.getLastModifiedDate());

                    return reservationDTO;
                })
                .collect(Collectors.toList());

    }

    // 특정 병원에 대한 예약 전체 조회하기
    public List<ReservationDTO> findReservationsByHosId(int hosId) {
        Hospital foundHospital = hospitalRepository.findById(hosId).get();
        List<Reservation> foundReservations = reservationsRepository.findReservationsByHosId(foundHospital);

        return foundReservations.stream()
                .map(reservation -> {
                    ReservationDTO reservationDTO = new ReservationDTO();
                    reservationDTO.setReservationId(reservation.getReservationId());
                    reservationDTO.setUserid(reservation.getUserId().getUserId());
                    reservationDTO.setUserName(reservation.getUserId().getUserName());
                    reservationDTO.setUserEmail(reservation.getUserId().getEmail());
                    reservationDTO.setUserPhone(reservation.getUserId().getPhone());
                    reservationDTO.setPetId(reservation.getPetId().getPetId()); // 추가 petId
                    reservationDTO.setPetName(reservation.getPetId().getPetName());
                    reservationDTO.setHosName(reservation.getHosId().getName());
                    reservationDTO.setClinicName(reservation.getClinicType().getClinicName());
                    reservationDTO.setDescription(reservation.getDescription());
                    reservationDTO.setSpecificDescription(reservation.getSpecificDescription());
                    reservationDTO.setState(reservation.getState());
                    reservationDTO.setReservationTime(reservation.getReservationTime());
                    reservationDTO.setLastModifiedDate(reservation.getLastModifiedDate());

                    return reservationDTO;
                })
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
        reservationDTO.setPetId(reservation.getPetId().getPetId()); // 추가 petId
        reservationDTO.setPetName(reservation.getPetId().getPetName());
        reservationDTO.setHosName(reservation.getHosId().getName());
        reservationDTO.setClinicName(reservation.getClinicType().getClinicName());
        reservationDTO.setDescription(reservation.getDescription());
        reservationDTO.setSpecificDescription(reservation.getSpecificDescription());
        reservationDTO.setState(reservation.getState());
        reservationDTO.setReservationTime(reservation.getReservationTime());
        reservationDTO.setLastModifiedDate(reservation.getLastModifiedDate());

        return reservationDTO;
    }

    // 예약 등록
    public ReservationDTO registReservation(CreateReservationDTO createReservationDTO) {


        // User 객체를 조회
        User user = userRepository.findById(createReservationDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("사용자를 찾을 수 없습니다."));

        // 병원 객체를 조회
        Hospital hospital = hospitalRepository.findById(createReservationDTO.getHosId())
                .orElseThrow(() -> new EntityNotFoundException("병원을 찾을 수 없습니다."));

        // ClinicType 객체를 조회
        ClinicType clinicType = clinicTypeRepository.findById(createReservationDTO.getTypeId())
                .orElseThrow(() -> new EntityNotFoundException("진료 유형을 찾을 수 없습니다."));

        // Pet 객체를 조회
        Pet pet = petRepository.findById(createReservationDTO.getPetId()).get();

        Reservation reservation = Reservation.builder()
                .userId(user)
                .hosId(hospital)
                .clinicType(clinicType)
                .petId(pet) // 추가 펫ID
                .description(createReservationDTO.getDescription()) // DTO에서 description 가져오기
                .specificDescription(createReservationDTO.getSpecificDescription()) // DTO에서 specificDescription 가져오기
                .reservationTime(createReservationDTO.getReservationTime()) // 예약 날짜 추가
                .build();

        Reservation savedReservation = reservationsRepository.save(reservation);

        return ReservationDTO.builder()  // ReservationDTO로 반환
                .reservationId((savedReservation.getReservationId()))
                .userid(savedReservation.getUserId().getUserId())
                .userName(savedReservation.getUserId().getUserName())
                .userEmail(savedReservation.getUserId().getEmail())
                .userPhone(savedReservation.getUserId().getPhone())
                .petId(savedReservation.getPetId().getPetId())
                .petName(savedReservation.getPetId().getPetName())
                .hosName(savedReservation.getHosId().getName())
                .clinicName(savedReservation.getClinicType().getClinicName())
                .description(savedReservation.getDescription())
                .specificDescription(savedReservation.getSpecificDescription())
                .reservationTime(savedReservation.getReservationTime())
                .build();
    }

    // 예약 수정
    public ReservationDTO updateReservations(int reservation_id, UpdateReservationDTO updateReservationDTO){

        Reservation reservation = reservationsRepository.findById(reservation_id)
                .orElseThrow(()-> new EntityNotFoundException("예약 정보를 찾을수 없습니다." + reservation_id));

        // 병원 객체를 조회
        Hospital hospital = hospitalRepository.findById(updateReservationDTO.getHosId())
                .orElseThrow(() -> new EntityNotFoundException("병원을 찾을 수 없습니다."));

        // ClinicType 객체를 조회
        ClinicType clinicType = clinicTypeRepository.findById(updateReservationDTO.getTypeId())
                .orElseThrow(() -> new EntityNotFoundException("진료 유형을 찾을 수 없습니다."));

        // 예약 시간을 검증
        LocalDateTime reservationTime = updateReservationDTO.getReservationTime();
        LocalDateTime startTime = LocalDateTime.of(reservationTime.toLocalDate(), LocalTime.of(10, 0)); // 오전 10시
        LocalDateTime endTime = LocalDateTime.of(reservationTime.toLocalDate(), LocalTime.of(19, 0)); // 오후 7시

        if (reservationTime.isBefore(startTime) || reservationTime.isAfter(endTime)) {
            throw new IllegalArgumentException("예약 시간은 오전 10시부터 오후 7시 사이여야 합니다.");
        }

        reservation  = reservation.toBuilder()

                .hosId(hospital)
                .clinicType(clinicType)
                .description(updateReservationDTO.getDescription()) // 설명
                .specificDescription(updateReservationDTO.getSpecificDescription()) // 상세 설명
                .reservationTime(updateReservationDTO.getReservationTime()) // 예약 시간
                .lastModifiedDate(updateReservationDTO.getLastModifiedDate()) // 최근 수정일
                .build();


        Reservation modifiedReservation = reservationsRepository.save(reservation);
        return ReservationDTO.builder()
                .hosName(modifiedReservation.getHosId().getName())
                .clinicName(modifiedReservation.getClinicType().getClinicName())
                .description(modifiedReservation.getDescription())
                .specificDescription(modifiedReservation.getSpecificDescription())
                .reservationTime(modifiedReservation.getReservationTime())
                .lastModifiedDate(modifiedReservation.getLastModifiedDate())
                .build();
    }

    // 예약 삭제
    public void deleteReservationById(int reservation_id){

        reservationsRepository.deleteById(reservation_id);
    }

}