package com.rocket.healingpets.auth.handler;

import com.rocket.healingpets.auth.service.CustomUserDetailService;
import com.rocket.healingpets.auth.service.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
* AuthenticationProvider
*
* 커스텀 인증 제공자
* 사용자가 입력한 사용자 이름과 비밀번호를 데이터베이스의 정보와 비교하여 사용자 자격을 증명
* */

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailService detailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        // 로그인 요청 정보를 가지고 있는 token
        UsernamePasswordAuthenticationToken loginToken = (UsernamePasswordAuthenticationToken) authentication;

        // 사용자가 입력한 ID
        String memberId = loginToken.getName();

        // 사용자가 입력한 password
        String password = (String) loginToken.getCredentials();

        CustomUserDetails member = (CustomUserDetails) detailsService.loadUserByUsername(memberId);


        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new BadCredentialsException(password + "는 비밀번호가 아닙니다.");
        }
        return new UsernamePasswordAuthenticationToken(member, password, member.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}
