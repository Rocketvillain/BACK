package com.rocket.healingpets.auth.filter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rocket.healingpets.users.model.dto.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private ObjectMapper objectMapper;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // 로그인 정보를 추출해서 AuthenticationManager를 통해 로그인 정보를 넘겨준다.
        UsernamePasswordAuthenticationToken authRequest;

        try {
            authRequest = getAuthRequest(request);
            setDetails(request, authRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    private UsernamePasswordAuthenticationToken getAuthRequest(HttpServletRequest request) throws IOException {

        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE,true);
        UserDTO user = objectMapper.readValue(request.getInputStream(), UserDTO.class);

        return new UsernamePasswordAuthenticationToken(user.getUserId(), user.getUserPwd());
    }
}
