package com.rocket.healingpets.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // 현재 사용자 정보를 가져오는 로직을 구현해야 합니다.
        // 예: SecurityContextHolder에서 사용자 이름을 가져오기
        return Optional.of("defaultUser"); // 임시 사용자
    }
}
