package com.rocket.healingpets.users.model.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class User {

    @Id
    @Column(name = "user_id")
    // 사용자 아이디
    private String userId;

    @Column(name = "hos_id")
    // 병원 고유번호(병원 관라지에게만 부여)
    private Integer hosId; //null값

    @Column(name = "pwd", nullable = false)
    // 비밀번호
    private String userPwd;

    @Column(name = "name", nullable = false)
    // 유저 이름
    private String userName;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role",nullable = false)

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
    // 로그인 기능을 사용하기 위해 임시로 fetch = FetchType.EAGER 설정함
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    // 유저 펫 리스트
    private List<Pet> pets = new ArrayList<>();

    @Column(name = "user_state",nullable = false)
    // 유저 상태 -> 디폴트: 활성화 상태(activated)
    private String userState = "activated";

    @Column(name = "created_date")
    @CreatedDate
    // 생성일
    private LocalDate createdDate;

    @Column(name = "last_modified_date")
    @LastModifiedDate
    // 최근 수정일
    private LocalDate lastModifiedDate;

    // 유저가 가진 펫 목록에 특정 petId가 있는지 확인하는 헬퍼 메소드
    public boolean ownsPet(int petId) {
        return pets.stream().anyMatch(pet -> pet.getPetId() == petId);
    }
}
