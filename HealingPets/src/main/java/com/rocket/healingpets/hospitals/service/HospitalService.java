package com.rocket.healingpets.hospitals.service;

import com.rocket.healingpets.hospitals.model.dto.CreateHospitalDTO;
import com.rocket.healingpets.hospitals.model.dto.UpdateHospitalDTO;
import com.rocket.healingpets.hospitals.model.entity.Hospital;
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
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    // 전체 병원 조회
    public List<Hospital> findAllHospital() {
        return hospitalRepository.findAll();
    }


    // 병원 아이디로 조회
    public Hospital findHospitalById(int hosId) {

        Hospital foundHospital = hospitalRepository.findById(hosId)
                .orElseThrow(() -> new EntityNotFoundException("해당 병원을 찾을 수 없습니다."));

        return foundHospital;
    }

    // 병원 등록
    public Hospital registHospital(CreateHospitalDTO hospitalDTO) {

        Hospital hospital = Hospital.builder()
                .name(hospitalDTO.getName())
                .address(hospitalDTO.getAddress())
                .businessNo(hospitalDTO.getBusinessNo())
                .ownerName(hospitalDTO.getOwnerName())
                .build();

        return hospitalRepository.save(hospital);
    }

    // 병원 정보 수정
    public Hospital modifyHospital(int hosId, UpdateHospitalDTO hospitalDTO) {

        Hospital hospital = hospitalRepository.findById(hosId)
                .orElseThrow(() -> new EntityNotFoundException("해당 병원을 찾을 수 없습니다."));

        hospital = hospital.toBuilder()
                .name(hospitalDTO.getName())
                .address(hospitalDTO.getAddress())
                .ownerName(hospitalDTO.getOwnerName())
                .businessNo(hospitalDTO.getBusinessNo())
                .info(hospitalDTO.getInfo())
                .ownerImage(hospitalDTO.getOwnerImage())
                .infoImage(hospitalDTO.getInfoImage())
                .build();

        return hospitalRepository.save(hospital);
    }

    public void deleteHospital(int hosId) {
        hospitalRepository.deleteById(hosId);
    }
}
