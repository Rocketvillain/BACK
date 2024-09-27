package com.rocket.healingpets.users.repository;

import com.rocket.healingpets.users.model.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUserId(String id);

    boolean existsByUserId(String userId);

    @Query("SELECT u.userId from User u WHERE u.userName = :userName AND u.phone = :phone")
    String findUserIdByNameAndPhone(@Param("userName")String name, @Param("phone")String phone);

    Optional<User> findByEmail(String email);

//    @Modifying
//    @Query("UPDATE User u SET u.userPwd = ?1 WHERE u.userId = ?2 AND u.userName = ?3 AND u.email = ?4")
//    int resetPasswordByUserAndUserNameAndEmail(String newPassword, String userId, String name, String email);
//
//    User findByUserIdAndUserNameAndEmail(String userId, String name, String email);
}

