package com.rocket.healingpets.users.service;

import com.rocket.healingpets.users.model.dto.CreateUserDTO;
import com.rocket.healingpets.users.model.dto.UpdateUserDTO;
import com.rocket.healingpets.users.model.dto.UserDTO;
import com.rocket.healingpets.users.model.entitiy.User;
import com.rocket.healingpets.users.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

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
        User user =  User.builder()
                .userId(createUserDTO.getUserId())
                .hosId(createUserDTO.getHosId())
                .userPwd(createUserDTO.getUserPwd())
                .userRole(createUserDTO.getUserRole())
                .userState(createUserDTO.getUserState())
                .email(createUserDTO.getEmail())
                .userName(createUserDTO.getName())
                .phone(createUserDTO.getPhone())
                .build();


        return userRepository.save(user);
    }

    // 유저 수정
    public User updateUser(String user_id, UpdateUserDTO modifyInfo) {

        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new EntityNotFoundException("유저 정보를 찾을 수 없습니다.user_id:" + user_id));

        user = user.toBuilder()
                .userId(modifyInfo.getUserId())
                .hosId(modifyInfo.getHosId())
                .userRole(modifyInfo.getUserRole())
                .userName(modifyInfo.getName())
                .email(modifyInfo.getEmail())
                .phone(modifyInfo.getPhone())
                .lastModifiedDate(modifyInfo.getLastModifiedDate())
                .build();

        return userRepository.save(user);
    }

    // 유저 삭제
    public void deleteUserById(String user_id) {

        userRepository.deleteById(user_id);
    }

}
