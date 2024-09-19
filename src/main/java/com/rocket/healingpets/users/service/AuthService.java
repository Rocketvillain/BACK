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

@Service
public class AuthService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public AuthService(ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDTO signup(UserDTO userDTO) {

        // 중복체크..(선택적)


        // 비밀번호 암호화
        userDTO.setUserPwd(passwordEncoder.encode(userDTO.getUserPwd()));
        userDTO.setUserRole(RoleType.ROLE_USER);

        // 데이터베이스에 저장하기 위해 DTO에 담긴 값을 Entity로 변경
        User registUser = modelMapper.map(userDTO, User.class);

        // 저장
        User savedUser = userRepository.save(registUser);

        UserDTO responseUserDTO = modelMapper.map(savedUser, UserDTO.class);

        return responseUserDTO;
    }
}
