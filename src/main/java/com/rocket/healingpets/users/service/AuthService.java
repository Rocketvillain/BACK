package com.rocket.healingpets.users.service;

import com.rocket.healingpets.users.model.dto.UserDTO;
import com.rocket.healingpets.users.model.entitiy.RoleType;
import com.rocket.healingpets.users.model.entitiy.User;
import com.rocket.healingpets.users.repository.UserRepository;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;


@Service
public class AuthService {

    private static final String AUTH_CODE_PREFIX = "AuthCode";
    private final Map<String, String> authCodeStore = new HashMap<>(); // 메모리에 인증 코드 저장
    private static final int CODE_LENGTH = 6;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final MailService mailService;

    @Autowired
    public AuthService(ModelMapper modelMapper,
                       PasswordEncoder passwordEncoder,
                       UserRepository userRepository,
                       MailService mailService) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.mailService = mailService;

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

//    // 비밀번호 변경
//    public boolean changePassword(String userId,String name, String email, String newPassword) {
//
//        User user = userRepository.findByUserIdAndUserNameAndEmail(userId, name, email);
//        System.out.println("AuthService ======================> user : " + user);
//
//        // 인증 코드 검증
//        if(user == null){
//            throw new RuntimeException("사용자를 찾을 수 없습니다.");
//        }
//
//        // 비밀번호를 인코딩
//        String encodedPassword = passwordEncoder.encode(newPassword);
//
//        // 비밀번호 변경 시도
//        int updateRows = userRepository.resetPasswordByUserAndUserNameAndEmail(encodedPassword, userId, name, email);
//
//        System.out.println("Updated Rows: " + updateRows);
//
//        // 업데이트 된 행의 수가 1인 경우 성공
//        return updateRows == 1;
//    }
}
