package com.rocket.healingpets.users.service;

import com.rocket.healingpets.auth.service.CustomUserDetails;
import com.rocket.healingpets.users.model.dto.*;
import com.rocket.healingpets.users.model.entitiy.Pet;
import com.rocket.healingpets.users.model.entitiy.User;
import com.rocket.healingpets.users.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetService {

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
                pet.getImage()
        )).collect(Collectors.toList());
    }



    // 회원의 펫 등록 (로그인한 회원 기준)
    public PetDTO registerPet(CreatePetDTO createPetDTO) {
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

        // Pet 엔티티를 생성하고, 로그인한 사용자의 ID를 설정
        Pet pet = Pet.builder()
                .user(loggedInUser) // 사용자 정보 설정, 사용자가 직접 입력할 필요 없음
                .petName(createPetDTO.getPetName())
                .gender(createPetDTO.getGender())
                .weight(createPetDTO.getWeight())
                .age(createPetDTO.getAge())
                .species(createPetDTO.getSpecies())
                .kind(createPetDTO.getKind())
                .build();

        // 펫 저장
        Pet savedPet = petRepository.save(pet);

        // 저장된 펫 정보를 PetDTO로 반환
        return new PetDTO(savedPet.getPetId(),savedPet.getUser().getUserId(),
                savedPet.getPetName(), savedPet.getGender(),
                savedPet.getWeight(), savedPet.getAge(),
                savedPet.getSpecies(), savedPet.getKind(),
                savedPet.getImage());
    }


    // 회원의 펫 정보 수정
    public PetDTO modifyPet(int petId, UpdatePetDTO updatePetDTO) {
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

        // 사용자가 소유한 펫 목록에서 petId에 해당하는 펫이 있는지 확인
        if (!loggedInUser.ownsPet(petId)) {
            throw new AccessDeniedException("You are not authorized to modify this pet");
        }

        // 펫 정보 조회
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet not found"));

        // 펫 정보 수정
        pet.setPetName(updatePetDTO.getName());
        pet.setGender(updatePetDTO.getGender());
        pet.setWeight(updatePetDTO.getWeight());
        pet.setAge(updatePetDTO.getAge());
        pet.setSpecies(updatePetDTO.getSpecies());
        pet.setKind(updatePetDTO.getKind());

        // 수정된 펫 저장
        Pet modifyPet = petRepository.save(pet);

        return new PetDTO(modifyPet.getPetId(),modifyPet.getUser().getUserId(),
                modifyPet.getPetName(), modifyPet.getGender(),
                modifyPet.getWeight(), modifyPet.getAge(),
                modifyPet.getSpecies(), modifyPet.getKind(),
                modifyPet.getImage());
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

