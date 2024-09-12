package com.rocket.healingpets.users.model.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "userState")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserState {

    @Id
    @Column(name = "user_id")
    // 사용자 아이디(원투원 매핑했기 때문에 동일하게 ID로 쓰인다.)
    private String userId;

    @Column(name = "type",nullable = false)
    // 유저 상태 -> 디폴트: 활성화 상태(activated)
    private String type = "activated";

    @Column(name = "description")
    // 부연 설명(이건 추후에 안쓰이게 되면 삭제해도 됨)
    private String description;
}
