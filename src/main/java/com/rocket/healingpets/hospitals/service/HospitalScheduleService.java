package com.rocket.healingpets.hospitals.service;

import com.rocket.healingpets.hospitals.model.dto.HospitalSchedule.CreateHospitalScheduleDTO;
import com.rocket.healingpets.hospitals.model.dto.HospitalSchedule.HospitalScheduleDTO;
import com.rocket.healingpets.hospitals.model.dto.HospitalSchedule.UpdateHospitalScheduleDTO;
import com.rocket.healingpets.hospitals.model.entity.ClinicType;
import com.rocket.healingpets.hospitals.model.entity.Hospital;
import com.rocket.healingpets.hospitals.model.entity.HospitalSchedule;
import com.rocket.healingpets.hospitals.repository.ClinicTypeRepository;
import com.rocket.healingpets.hospitals.repository.HospitalRepository;
import com.rocket.healingpets.hospitals.repository.HospitalScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class HospitalScheduleService {

    private final HospitalRepository hospitalRepository;
    private final HospitalScheduleRepository hospitalScheduleRepository;
    private final ClinicTypeRepository clinicTypeRepository;

    // 전체 병원 일정 조회
    public List<HospitalScheduleDTO> findAllHospitalSchedule() {

        List<HospitalSchedule> Schedules = hospitalScheduleRepository.findAll();



        return Schedules.stream()
                .map(schedule -> new HospitalScheduleDTO(
                        schedule.getScheduleId(),
                        schedule.getHosId().getHosId(),
                        schedule.getDate(),
                        schedule.getStartTime(),
                        schedule.getEndTime(),
                        schedule.getIsOkay(),
                        schedule.getClinicType().getClinicName()
                        )
                )
                .collect(Collectors.toList());
    }

    // 병원 아이디로 병원 일정 조회
    public List<HospitalScheduleDTO> findHospitalSchedulesByHospitalId(int hosId) {

        Hospital foundHospital = hospitalRepository.findById(hosId).get();

        List<HospitalSchedule> schedules = hospitalScheduleRepository.findHospitalSchedulesByHosId(foundHospital);

        return schedules.stream()
                .map(schedule -> new HospitalScheduleDTO(
                                schedule.getScheduleId(),
                                schedule.getHosId().getHosId(),
                                schedule.getDate(),
                                schedule.getStartTime(),
                                schedule.getEndTime(),
                                schedule.getIsOkay(),
                                schedule.getClinicType().getClinicName()
                        )
                )
                .collect(Collectors.toList());
    }

    // 병원 일정 등록
    public HospitalScheduleDTO registHospitalSchedule(CreateHospitalScheduleDTO hospitalScheduleDTO) {

        Hospital foundHospital = hospitalRepository.findById(hospitalScheduleDTO.getHosId()).get();
        ClinicType foundClinicType = clinicTypeRepository.findClinicTypeByHosIdAndClinicName(hospitalScheduleDTO.getHosId(),hospitalScheduleDTO.getClinicName());

        HospitalSchedule hospitalSchedule = HospitalSchedule.builder()
                .hosId(foundHospital)
                .date(hospitalScheduleDTO.getDate())
                .startTime(hospitalScheduleDTO.getStartTime())
                .endTime(hospitalScheduleDTO.getEndTime())
                .isOkay(hospitalScheduleDTO.getIsOkay())
                .clinicType(foundClinicType)
                .build();

        HospitalSchedule savedHospitalSchedule = hospitalScheduleRepository.save(hospitalSchedule);

        return HospitalScheduleDTO.builder()
                .hosId(savedHospitalSchedule.getHosId().getHosId())
                .date(savedHospitalSchedule.getDate())
                .startTime(savedHospitalSchedule.getStartTime())
                .endTime(savedHospitalSchedule.getEndTime())
                .isOkay(savedHospitalSchedule.getIsOkay())
                .clinicName(savedHospitalSchedule.getClinicType().getClinicName())
                .build();
    }

    // 병원 일정 수정
    public HospitalScheduleDTO modifyHospitalSchedule(int scheduleId, UpdateHospitalScheduleDTO hospitalScheduleDTO) {

        HospitalSchedule hospitalSchedule = hospitalScheduleRepository.findById(scheduleId).get();

        hospitalSchedule = hospitalSchedule
                .toBuilder()
                .date(hospitalScheduleDTO.getDate())
                .startTime(hospitalScheduleDTO.getStartTime())
                .endTime(hospitalScheduleDTO.getEndTime())
                .isOkay(hospitalScheduleDTO.getIsOkay())
                .build();

        HospitalSchedule modifiedHospitalSchedule = hospitalScheduleRepository.save(hospitalSchedule);
        return HospitalScheduleDTO.builder()
                .hosId(modifiedHospitalSchedule.getHosId().getHosId())
                .date(modifiedHospitalSchedule.getDate())
                .startTime(modifiedHospitalSchedule.getStartTime())
                .endTime(modifiedHospitalSchedule.getEndTime())
                .isOkay(modifiedHospitalSchedule.getIsOkay())
                .clinicName(modifiedHospitalSchedule.getClinicType().getClinicName())
                .build();
    }

    // 병원 일정 삭제
    public void deleteHospitalSchedule(int scheduleId) {
        hospitalScheduleRepository.deleteById(scheduleId);
    }
}
