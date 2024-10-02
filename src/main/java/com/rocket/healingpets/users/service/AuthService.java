package com.rocket.healingpets.users.service;

import com.rocket.healingpets.hospitals.model.entity.ClinicType;
import com.rocket.healingpets.hospitals.repository.ClinicTypeRepository;
import com.rocket.healingpets.users.model.dto.HospitalDTO2;
import com.rocket.healingpets.hospitals.model.entity.Hospital;
import com.rocket.healingpets.users.model.dto.PetDTO2;
import com.rocket.healingpets.users.model.dto.UserDTO;
import com.rocket.healingpets.users.model.dto.UserDTO2;
import com.rocket.healingpets.users.model.entitiy.Pet;
import com.rocket.healingpets.users.model.entitiy.RoleType;
import com.rocket.healingpets.users.model.entitiy.User;
import com.rocket.healingpets.users.repository.PetRepository;
import com.rocket.healingpets.users.repository.UserRepository;
import com.rocket.healingpets.hospitals.repository.HospitalRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AuthService {

    private static final String AUTH_CODE_PREFIX = "AuthCode";
    private final Map<String, String> authCodeStore = new HashMap<>(); // 메모리에 인증 코드 저장
    private static final int CODE_LENGTH = 6;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final MailService mailService;
    private final PetRepository petRepository;
    private final HospitalRepository hospitalRepository;

    @Autowired
    public AuthService(ModelMapper modelMapper,
                       PasswordEncoder passwordEncoder,
                       UserRepository userRepository,
                       MailService mailService,
                       PetRepository petRepository,
                       HospitalRepository hospitalRepository
                       ) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.mailService = mailService;
        this.petRepository = petRepository;
        this.hospitalRepository = hospitalRepository;

    }

    @Transactional
    public UserDTO signup(UserDTO userDTO) {

        // 비밀번호 암호화
        userDTO.setUserPwd(passwordEncoder.encode(userDTO.getUserPwd()));

        // 유저 역할
        userDTO.setUserRole(RoleType.ROLE_USER);

        // 데이터베이스에 저장하기 위해 DTO에 담긴 값을 Entity로 변경
        User registUser = modelMapper.map(userDTO, User.class);

        // 저장
        User savedUser = userRepository.save(registUser);

        UserDTO responseUserDTO = modelMapper.map(savedUser, UserDTO.class);
        return responseUserDTO;
    }

    @Transactional
    public UserDTO2 signup2(UserDTO2 userDTO2) {

        // 비밀번호 암호화
        userDTO2.setUserPwd(passwordEncoder.encode(userDTO2.getUserPwd()));

        // 유저 역할
        userDTO2.setUserRole(RoleType.ROLE_USER);

        // 데이터베이스에 저장하기 위해 DTO에 담긴 값을 Entity로 변경
        User registUser2 = modelMapper.map(userDTO2, User.class);

        // 저장
        User savedUser2 = userRepository.save(registUser2);

        UserDTO2 responseUserDTO2 = modelMapper.map(savedUser2, UserDTO2.class);
        return responseUserDTO2;
    }

    // 인증번호 랜덤 설정
    public String generateAuthCode(){
        SecureRandom random = new SecureRandom();
        StringBuilder codeBuilder = new StringBuilder(CODE_LENGTH);
        for(int i=0; i<CODE_LENGTH; i++){
            codeBuilder.append(random.nextInt(10));
        }

        return codeBuilder.toString();
    }


    // 인증번호 전송
    public void sendAuthCode(String email){
        String authCode = generateAuthCode();
        String subject = "이메일 인증 코드";
        String body = "인증 코드" + authCode;

        mailService.sendEmail(email,subject,body);

        // 인증 코드를 메모리에 저장
        authCodeStore.put(AUTH_CODE_PREFIX + email, authCode);
    }

    // 인증번호 검증
    public boolean verifyAuthCode(String email, String code){
        // 메모리에서 인증 코드 조회
        String storedCode = authCodeStore.get(AUTH_CODE_PREFIX + email);

        // 코드 비교
        return storedCode != null && storedCode.equals(code);
    }

    //id 찾기
    public String findUserId(String name, String phone){
        // 이름과 전화번호로 사용자 ID조회
        return userRepository.findUserIdByNameAndPhone(name,phone);
    }


    // 비밀번호 변경
    @Transactional
    public boolean changePassword(String userId,String name, String email, String newPassword,String code) {

        // 인증 코드 검증
        boolean isCodeVaild = verifyAuthCode(email, code);
        if(!isCodeVaild){
            throw new RuntimeException("유효하지 않은 인증 코드 입니다.");
        }

        // 사용자 정보 확인
        User user = userRepository.findByUserIdAndUserNameAndEmail(userId, name, email);
        if(user == null){
            throw new RuntimeException("사용자를 찾을 수 없습니다.");
        }

        // 비밀번호를 인코딩(update)
        String encodedPassword = passwordEncoder.encode(newPassword);

        // 비밀번호 변경
        user.setUserPwd(encodedPassword); // 비밀번호 설정

        // 비밀번호 변경 시도
        userRepository.save(user);

        return true;

    }

    // 회원가입 펫 등록
    public PetDTO2 registerPet2(Pet pet){

        // 펫 저장
        Pet savedPet = petRepository.save(pet);

        // 저장된 펫 정보를 PetDTO2로 반환
        return new PetDTO2(savedPet.getPetId(),
                savedPet.getPetName(), savedPet.getGender(),
                savedPet.getWeight(), savedPet.getAge(),
                savedPet.getSpecies(), savedPet.getKind(),savedPet.getUser().getUserId()
        );
    }

    // 회원가입 병원 등록
    public HospitalDTO2 registHospital(Hospital hospital) {

        // 병원 저장
        Hospital saveHos = hospitalRepository.save(hospital);

        // clinicType 리스트 가져오기
        List<String> clinicNames = saveHos.getClinicType().stream()
                .map(ClinicType::getClinicName)
                .collect(Collectors.toList());

        return new HospitalDTO2(
                saveHos.getHosId(),
                saveHos.getName(),
                saveHos.getAddress(),
                saveHos.getOwnerName(),
                saveHos.getBusinessNo(),
                clinicNames,
                saveHos.getUser().getUserId()
                );
    }

    public User updateUser(User user) {
        // 기존 유저를 데이터베이스에서 찾기
        Optional<User> existingUserOpt = userRepository.findById(user.getUserId());

        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            // 필요한 필드 업데이트
            existingUser.setEmail(user.getEmail());
            existingUser.setHosId(user.getHosId());
            // 추가적인 필드들 업데이트...

            // 변경된 유저 정보 저장
            return userRepository.save(existingUser);
        } else {
            throw new EntityNotFoundException("User not found with id: " + user.getUserId());
        }
    }
}
