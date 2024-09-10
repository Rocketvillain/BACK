package com.rocket.healingpets.users.model.entitiy;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    // 사용자 아이디
    private int userId;

    @Column(name = "hos_id")
    // 병원 고유번호(병원 관라지에게만 부여)
    private int hosId;

    @Column(name = "pwd", nullable = false)
    // 비밀번호
    private String userPwd;

    @Column(name = "name", nullable = false)
    // 유저 이름
    private String userName;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    // 유저 권한
    private RoleType userRole = RoleType.ROLE_USER;

    @Column(name = "email", nullable = false)
    // 유저 이메일
    private String email;

    @Column(name = "phone", nullable = false)
    // 유저 폰 번호
    private String phone;

    // cascade = CascadeType.ALL : 회원이 삭제되면 자식 엔티티도 같이 삭제
    // orphanRemoval = true : 부모 엔티티에서 자식 엔티티를 제거하면, 해당 자식 엔티티가 데이터베이스에서 삭제됩니다.
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    // 유저 펫 리스트
    private List<Pet> pet;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId // 부모의 ID를 자식의 ID로 매핑
    // 유저 상태(activated, deActivated)
    private UserState userState;

    @Column(name = "created_date")
    @CreatedDate
    // 생성일
    private LocalDateTime createdDate;

    @Column(name = "last_modified_date")
    @LastModifiedDate
    // 최근 수정일
    private LocalDateTime lastModifiedDate;
}
