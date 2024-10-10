package com.rocket.healingpets.users.service;

import com.rocket.healingpets.hospitals.model.entity.Hospital;
import com.rocket.healingpets.hospitals.service.HospitalService;
import com.rocket.healingpets.users.model.dto.CreateUserDTO;
import com.rocket.healingpets.users.model.dto.UpdateUserDTO;
import com.rocket.healingpets.users.model.dto.UserDTO;
import com.rocket.healingpets.users.model.entitiy.User;
import com.rocket.healingpets.users.repository.UserRepository;
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
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final HospitalService hospitalService;

    @Value("${file.upload-dir}")
    private String uploadDir;

    // 유저 전체 조회
    public List<UserDTO> findAllUsers() {
        List<User> allUser = userRepository.findAll();

        return allUser.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList()); //List 변환
    }

    // 유저 단일 조회
    public User findUserById(String user_id) {
         User user = userRepository.findById(user_id)
                .orElseThrow(() -> new EntityNotFoundException("유저를 찾을 수 없습니다."));
        return user;
    }

    // 유저 등록
    public User registUser(CreateUserDTO createUserDTO) {
        Hospital foundHospital = hospitalService.findHospitalById(createUserDTO.getHosId());
        User user =  User.builder()
                .userId(createUserDTO.getUserId())
                .hosId(foundHospital)
                .userPwd(createUserDTO.getUserPwd())
                .userRole(createUserDTO.getUserRole())
                .userState(createUserDTO.getUserState())
                .email(createUserDTO.getEmail())
                .userName(createUserDTO.getName())
                .phone(createUserDTO.getPhone())
                .build();


        return userRepository.save(user);
    }

    // 유저 정보 수정
    public User updateUserInfo(String user_id, UpdateUserDTO modifyInfo) {

        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new EntityNotFoundException("유저 정보를 찾을 수 없습니다.user_id:" + user_id));

        user = user.toBuilder()
                .userName(modifyInfo.getName())
                .email(modifyInfo.getEmail())
                .phone(modifyInfo.getPhone())
                .lastModifiedDate(LocalDate.now())
                .userState(modifyInfo.getUserState())
                .build();

        return userRepository.save(user);
    }

    // 유저 이미지 수정
    public User updateUserImage(String user_id, MultipartFile image ) {

        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new EntityNotFoundException("유저 정보를 찾을 수 없습니다.user_id:" + user_id));

        // 이미지가 있는 경우 처리
        if (image != null && !image.isEmpty()) {

            // 기존 이미지 삭제
            if (user.getImage() != null) {
                deleteImage(user.getImage());
            }

            // 이미지 저장 로직 추가 (예: 로컬 파일 시스템이나 클라우드 저장소에 저장)
            String imagePath = saveImage(image); // saveImage 메소드는 이미지를 저장하고 경로를 반환하는 메소드입니다.
            user.setImage(imagePath);
        }

        return userRepository.save(user);
    }


    // 유저 상태 수정
    public User modifyUserState(String userId) {

        User user = userRepository.findById(userId).get();

        user = user.toBuilder()
                .userState("secession")
                .lastModifiedDate(LocalDate.now())
                .build();

        System.out.println("UserService ===================> Update user Info : " + user);

        return userRepository.save(user);
    }

    // 유저 삭제
    public void deleteUserById(String user_id) {

        userRepository.deleteById(user_id);
    }

    public User findByEmail(String loggedInUserEmail) {
        return userRepository.findByEmail(loggedInUserEmail)
                .orElseThrow(() -> new RuntimeException("User with email " + loggedInUserEmail + " not found"));
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
