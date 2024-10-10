package com.rocket.healingpets.hospitals.service;

import com.rocket.healingpets.hospitals.model.dto.Hospital.CreateHospitalDTO;
import com.rocket.healingpets.hospitals.model.dto.Hospital.HospitalDTO;
import com.rocket.healingpets.hospitals.model.dto.Hospital.UpdateHospitalDTO;
import com.rocket.healingpets.hospitals.model.entity.Hospital;
import com.rocket.healingpets.hospitals.repository.HospitalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final ModelMapper modelMapper;

    @Value("${file.upload-dir}")
    private String uploadDir;

    // 전체 병원 조회
    public List<HospitalDTO> findAllHospital() {
        List<Hospital> allHospital = hospitalRepository.findAll();

        return allHospital.stream()
                .map(hospital -> modelMapper.map(hospital, HospitalDTO.class))
                .collect(Collectors.toList()); // List로 변환
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

    // 병원 이미지 수정


    // 병원 삭제
    public void deleteHospital(int hosId) {
        hospitalRepository.deleteById(hosId);
    }

    // 이미지 저장 메소드
    private String saveImage(MultipartFile image) {
        try{
            String fileName = System.currentTimeMillis() + ".png"; //파일 이름 생성
            File uploadDorFile = new File(uploadDir);

            // 디렉토리가 없으면 생성
            if (!uploadDorFile.exists()) {
                uploadDorFile.mkdirs();
            }

            File file = new File(uploadDir + fileName);
            image.transferTo(file); //파일 저장

            System.out.println("새 이미지 저장 완료" + file.getAbsolutePath());
            return fileName;

        } catch (IOException e) {
            throw new RuntimeException("이미지 저장 중 오류 발생", e);
        }
    }

    // 기존 이미지를 삭제하는 메소드
    private void deleteImage(String imagePath) {
        try {
            File file = new File(uploadDir + imagePath); // 이미지 경로
            if (file.exists()) {
                boolean deleted = file.delete();
                if (!deleted) {
                    System.err.println("기존 이미지 삭제 실패: " + imagePath);
                }else{
                    System.out.println("기존 이미지 삭제 성공: " + imagePath);
                }
            } else {
                System.out.println("삭제할 이미지가 존재하지 않음 : " + imagePath);
            }
        } catch (Exception e) {
            System.err.println("이미지 삭제 중 오류 발생: " + e.getMessage());
        }
    }
}
