package com.rocket.healingpets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // Auditing 기능 활성화 -> 이걸 적용해야 @CreatedDate 및 @LastModifiedDate가 자동 반영됨.
public class HealingPetsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealingPetsApplication.class, args);
    }

}
