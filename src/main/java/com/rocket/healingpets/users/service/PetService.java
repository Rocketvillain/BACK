package com.rocket.healingpets.users.service;

import com.rocket.healingpets.auth.service.CustomUserDetails;
import com.rocket.healingpets.users.model.dto.*;
import com.rocket.healingpets.users.model.entitiy.Pet;
import com.rocket.healingpets.users.model.entitiy.User;
import com.rocket.healingpets.users.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final PetRepository petRepository;
    private final UserService userService;

    // 회원의 펫 전체 조회 (로그인한 회원 기준)
    public List<PetDTO> findAllPetsByLoggedInUser() {

        // 현재 로그인한 회원의 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUserEmail = null;

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            // 로그인한 사용자의 이메일을 가져옴
            loggedInUserEmail = ((CustomUserDetails) authentication.getPrincipal()).getEmail();
        }

        // 로그인한 회원의 이메일로 사용자 정보 조회
        User loggedInUser = userService.findByEmail(loggedInUserEmail);
        if (loggedInUser == null) {
            throw new RuntimeException("User not found");
        }

        // 수정된 메소드 호출: 해당 사용자의 펫 목록 조회
        List<Pet> pets = petRepository.findAllByUser_UserId(loggedInUser.getUserId());

        // Pet 목록을 PetDTO로 변환하여 반환
        return pets.stream().map(pet -> new PetDTO(
                pet.getPetId(),
                pet.getUser().getUserId(),
                pet.getPetName(),
                pet.getGender(),
                pet.getWeight(),
                pet.getAge(),
                pet.getSpecies(),
                pet.getKind(),
                pet.getImage() != null ? "http://localhost:8080/uploads/" + pet.getImage() : "" // 이미지 경로

        )).collect(Collectors.toList());
    }

    // 회원의 펫 등록 (로그인한 회원 기준)
    public PetDTO registerPet(CreatePetDTO createPetDTO, MultipartFile image) {
        // 현재 로그인한 회원의 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUserEmail = null;

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            // 로그인한 사용자의 이메일을 가져옴
            loggedInUserEmail = ((CustomUserDetails) authentication.getPrincipal()).getEmail();
        }

        // 로그인한 회원의 이메일로 사용자 정보 조회
        User loggedInUser = userService.findByEmail(loggedInUserEmail);
        if (loggedInUser == null) {
            throw new RuntimeException("User not found");
        }

        Pet pet = new Pet();
        pet.setPetName(createPetDTO.getPetName());
        pet.setGender(createPetDTO.getGender());
        pet.setWeight(createPetDTO.getWeight());
        pet.setAge(createPetDTO.getAge());
        pet.setSpecies(createPetDTO.getSpecies());
        pet.setKind(createPetDTO.getKind());
        pet.setUser(loggedInUser);

        // 이미지 파일 저장 로직
        if (image != null && !image.isEmpty()) {
            try {
                File uploadDirFile = new File(uploadDir);

                // 디렉토리가 없으면 생성
                if (!uploadDirFile.exists()) {
                    uploadDirFile.mkdirs();
                }

                // 파일 이름 생성 (항상 .png 확장자 사용)
                String fileName = System.currentTimeMillis() + ".png"; // 파일명 생성
                File file = new File(uploadDir + fileName);
                image.transferTo(file); // 파일 저장

                pet.setImage("/uploads/" + fileName); // 펫 객체에 이미지 경로 저장
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("파일 저장 실패: " + e.getMessage());
            }
        } else {
            pet.setImage(null);
        }

        // 펫 저장
        Pet savedPet = petRepository.save(pet);

        // 저장된 펫 정보를 PetDTO로 반환
        return new PetDTO(savedPet.getPetId(), savedPet.getUser().getUserId(),
                savedPet.getPetName(), savedPet.getGender(),
                savedPet.getWeight(), savedPet.getAge(),
                savedPet.getSpecies(), savedPet.getKind(),
                savedPet.getImage()); // 저장된 펫 정보를 DTO로 반환
    }


    // 펫 정보 수정
    public PetDTO modifyPet(int petId, UpdatePetDTO updatePetDTO, MultipartFile image) {
        // 현재 로그인한 회원의 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUserEmail = null;

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            loggedInUserEmail = ((CustomUserDetails) authentication.getPrincipal()).getEmail();
        }

        // 로그인한 회원의 이메일로 사용자 정보 조회
        User loggedInUser = userService.findByEmail(loggedInUserEmail);
        if (loggedInUser == null) {
            throw new RuntimeException("User not found");
        }

        // 사용자가 소유한 펫 목록에서 petId에 해당하는 펫이 있는지 확인
        if (!loggedInUser.ownsPet(petId)) {
            throw new AccessDeniedException("You are not authorized to modify this pet");
        }

        // 펫 정보 조회
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet not found"));

        // 펫 정보 수정
        pet.setPetName(updatePetDTO.getPetName());
        pet.setGender(updatePetDTO.getGender());
        pet.setWeight(updatePetDTO.getWeight());
        pet.setAge(updatePetDTO.getAge());
        pet.setSpecies(updatePetDTO.getSpecies());
        pet.setKind(updatePetDTO.getKind());

        // 이미지가 있는 경우 처리
        if (image != null && !image.isEmpty()) {

            // 기존 이미지 삭제
            if (pet.getImage() != null) {
                deleteImage(pet.getImage());
            }

            // 이미지 저장 로직 추가 (예: 로컬 파일 시스템이나 클라우드 저장소에 저장)
            String imagePath = saveImage(image); // saveImage 메소드는 이미지를 저장하고 경로를 반환하는 메소드입니다.
            pet.setImage(imagePath);
        }

        // 수정된 펫 저장
        Pet modifyPet = petRepository.save(pet);

        return new PetDTO(modifyPet.getPetId(), modifyPet.getUser().getUserId(),
                modifyPet.getPetName(), modifyPet.getGender(),
                modifyPet.getWeight(), modifyPet.getAge(),
                modifyPet.getSpecies(), modifyPet.getKind(),
                modifyPet.getImage());
    }

    // 이미지 저장 메소드
    private String saveImage(MultipartFile image) {
        try {
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

    public void deletePet(int petId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUserEmail = null;

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            loggedInUserEmail = ((CustomUserDetails) authentication.getPrincipal()).getEmail();
        }

        User loggedInUser = userService.findByEmail(loggedInUserEmail);
        if (loggedInUser == null) {
            throw new RuntimeException("User not found");
        }

        // 사용자가 소유한 펫 목록에서 petId에 해당하는 펫이 있는지 확인
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet not found"));

        // 로그인한 사용자와 삭제하려는 펫의 소유자를 비교하여 권한을 확인
        if (!pet.getUser().getUserId().equals(loggedInUser.getUserId())) {
            throw new AccessDeniedException("You are not authorized to delete this pet");
        }

        // 펫 삭제
        petRepository.delete(pet);
    }


}

