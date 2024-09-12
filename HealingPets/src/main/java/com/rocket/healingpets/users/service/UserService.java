package com.rocket.healingpets.users.service;

import com.rocket.healingpets.users.model.dto.UserDTO;
import com.rocket.healingpets.users.model.entitiy.RoleType;
import com.rocket.healingpets.users.model.entitiy.User;
import com.rocket.healingpets.users.repository.UserRepository;
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
public class UserService {

    private final UserRepository userRepository;

    // 유저 전체 조회
    public List<User> findAllUsers() {

        return userRepository.findAll();
    }
//
//    // 유저 단일 조회
//    public User findUserByUsername(String user_id) {
//
//        return userRepository.findById(user_id)
//                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));
//    }
//
//    // 유저 등록
//    public User registUser(UserDTO userDTO) {
//        User user =  new User();
//
//        user.setUserName(userDTO.getName());
//        user.setUserRole(RoleType.valueOf(userDTO.getUser_role()));
//        user.setEmail(userDTO.getEmail());
//        user.setPhone(userDTO.getPhone());
//
//        return userRepository.save(user);
//    }
//
//    // 유저 수정
//    public User updateUser(String user_id, UserDTO modifyInfo) {
//
//        User user = userRepository.findById(user_id)
//                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다.user_id:" + user_id));
//
//        user = user.toBuilder()
//                .userName(modifyInfo.getName())
//                .email(modifyInfo.getEmail())
//                .phone(modifyInfo.getPhone())
//                .build();
//
//        return userRepository.save(user);
//    }
//
//    // 유저 삭제
//    public void deleteUserById(String user_id) {
//
//        userRepository.deleteById(user_id);
//    }

}
