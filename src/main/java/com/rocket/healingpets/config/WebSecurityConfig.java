package com.rocket.healingpets.config;

import com.rocket.healingpets.auth.filter.CustomAuthenticationFilter;
import com.rocket.healingpets.auth.filter.JwtAuthorizationFilter;
import com.rocket.healingpets.auth.handler.CustomAuthFailUserHandler;
import com.rocket.healingpets.auth.handler.CustomAuthSuccessHandler;
import com.rocket.healingpets.auth.handler.CustomAuthenticationProvider;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class WebSecurityConfig {


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){

        // 특정 요청에대해 spring security filter chain을 건너뛰도록 하는 역할

        // webConfig에 설정한 addResourceHandler는 정적 자원에 대해 요청을 할 수 있게 해주는 역할
        // webSecurityCustomizer 는 특정 요청에 대해 filterChain 을 건너뛰도록 설정하는 역할
        return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // csrf (Cross-Site-Request-Forgery)
                // RESTAPI 혹은 JWT 기반 인증에서는 세션을 사용하지 않아서 보호를 하지 않아도 됨
                .csrf(AbstractHttpConfigurer::disable)
                // 어플리케이션의 session 상태를 비저장 모드로 동작하게함
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 기존 formlogin 을 사용하지 않으므로 비활성화
                .formLogin(AbstractHttpConfigurer::disable)
                // http 기본인증 (JWT를 사용한 것이므로 ) 비활성화
                .httpBasic(AbstractHttpConfigurer::disable)

                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                // 사용자가 입력한 아이디 패스워드를 전달받아 로그인 직접적으로 수행하는 필터
                // 인증시(successHandler를 통해) 토큰을 생성해서 header 로 전달하고
                // 실패시(failureHandler를 통해) 이유를 담아서 응답한다.

                .addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)

                // header에 token이 담겨져 왔을 경우 인가처리를 해주는 필터
                .addFilterBefore(jwtAuthorizationFilter(), BasicAuthenticationFilter.class)

                .authorizeHttpRequests(auth -> auth
                        // Swagger 관련 리소스와 회원가입 경로 허용 ( 여기서 경로 지정)
                        .requestMatchers("/auth/signup", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**").permitAll()
                        .anyRequest()
                        .authenticated() // 나머지 요청은 인증 필요
                );

        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(){
        return new ProviderManager(customAuthenticationProvider());
    }


    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider(){
        return new CustomAuthenticationProvider();
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter(){

        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager());

        // 로그인 요청을 할 url
        // login 으로 post 요청이 들어오면 필터가 동작한다.
        customAuthenticationFilter.setFilterProcessesUrl("/login");

        // 인증 성공시 동작할 핸들러 설정
        customAuthenticationFilter.setAuthenticationSuccessHandler(customAuthLoginSuccessHandler());

        // 인증 실패시 동작할 핸들러 설정
        customAuthenticationFilter.setAuthenticationFailureHandler(customAuthFailUserHandler());

        // 필터의 모든 설정 속성을 완료했을 떄
        // 올바르게 서절되어있는지 확인하는 역할의 메서드
        customAuthenticationFilter.afterPropertiesSet();

        // 완성된 CustomAuthenticationFilter 를 반환한다.
        return customAuthenticationFilter;
    }


    @Bean
    public CustomAuthSuccessHandler customAuthLoginSuccessHandler(){
        return new CustomAuthSuccessHandler();
    }



    @Bean
    public CustomAuthFailUserHandler customAuthFailUserHandler(){
        return new CustomAuthFailUserHandler();
    }


    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter(){
        return new JwtAuthorizationFilter(authenticationManager());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);
        return source;
    }

}
