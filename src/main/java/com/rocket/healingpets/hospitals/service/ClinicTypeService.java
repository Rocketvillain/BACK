package com.rocket.healingpets.hospitals.service;

import com.rocket.healingpets.hospitals.model.dto.ClinicType.CreateClinicTypeDTO;
import com.rocket.healingpets.hospitals.model.dto.ClinicType.UpdateClinicTypeDTO;
import com.rocket.healingpets.hospitals.model.entity.ClinicType;
import com.rocket.healingpets.hospitals.repository.ClinicTypeRepository;
import com.rocket.healingpets.hospitals.repository.HospitalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ClinicTypeService {

    private final ClinicTypeRepository clinicTypeRepository;
    private final HospitalRepository hospitalRepository;

    // 전체 진료 유형 조회
    public List<ClinicType> findAllClinicType() {
        return clinicTypeRepository.findAll();
    }

    // 병원 아이디로 해당 진료 유형 조회
    public List<ClinicType> findClinicTypesByHosId(int hosId) {

        return clinicTypeRepository.findClinicTypesByHosId(hosId);
    }

    // 진료 유형 등록
    public ClinicType registClinicType(CreateClinicTypeDTO clinicTypeDTO) {

//        Hospital foundHospital = hospitalRepository.findById(clinicTypeDTO.getHosId())
//                .orElseThrow(() -> new EntityNotFoundException("해당 병원을 찾을 수 없습니다."));;

        ClinicType clinicType = ClinicType.builder()
                .clinicName(clinicTypeDTO.getClinicName())
                .hosId(clinicTypeDTO.getHosId())
                .build();

        return clinicTypeRepository.save(clinicType);
    }

    // 진료 유형 정보 수정
    public ClinicType modifyClinicType(int typeId, UpdateClinicTypeDTO clinicTypeDTO) {

        ClinicType clinicType = clinicTypeRepository.findById(typeId)
                .orElseThrow(() -> new EntityNotFoundException("해당 진료 유형을 찾을 수 없습니다."));

        clinicType = clinicType.toBuilder()
                .clinicName(clinicTypeDTO.getClinicName())
                .build();

        return clinicTypeRepository.save(clinicType);
    }

    public void deleteClinicType(int typeId) {
        clinicTypeRepository.deleteById(typeId);
    }
}
