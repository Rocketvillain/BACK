package com.rocket.healingpets.auth.filter;

import com.rocket.healingpets.auth.service.CustomUserDetails;
import com.rocket.healingpets.common.AuthConstants;
import com.rocket.healingpets.users.model.entitiy.User;
import com.rocket.healingpets.users.model.entitiy.RoleType;
import com.rocket.healingpets.util.TokenUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;


public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        List<String> roleLeessList = Arrays.asList(
                // 토큰 사용하지 않아도 기능 수행할 수 있게 설정 ( 로그인해서 사용하는 기능은 안 써도 됨)
                "/auth/signup",             // 일반 사용자 회원가입
                "/auth/signup2",            // 병원 관리자 회원가입
                "/swagger-ui/(.*)",        //swagger 설정
                "/swagger-ui/index.html",  //swagger 설정
                "/v3/api-docs",              //swagger 설정
                "/v3/api-docs/(.*)",         //swagger 설정
                "/swagger-resources",        //swagger 설정
                "/swagger-resources/(.*)",    //swagger 설정
                "/auth/send-code",                 // email 보내기
                "/auth/verify-code",                 // email 인증하기
                "/api/v1/reservation",               // 병원 진료 예약
                "/api/v1/reservation/.*", // 에약 하위 경로
                "/api/v1/user/.*",
                "/api/v1/hospital",
                "/auth/check-duplicate", // 중복 확인
                "/auth/find-id", // ID찾기
                "/auth/reset-password",  //비밀번호 변경
                "/auth/request-reset-password", // 비밀번호 변경 요청
                "/uploads/(.*)"

        );

        if(roleLeessList.stream().anyMatch(uri -> roleLeessList.stream().anyMatch(pattern -> Pattern.matches(pattern, request.getRequestURI())))){
            chain.doFilter(request,response);
            return;
        }

        // 헤더에서 토큰 꺼내기
        String header = request.getHeader(AuthConstants.AUTH_HEADER);
        System.out.println(header);

        // 유효한 토큰 확인
        try {

            // 토큰 꺼냈는데 비어있나?
            if(header != null && !header.equalsIgnoreCase("")){

                // 토큰 분리(Bearer 분리시켜서 토큰만 반환받기)
                String token = TokenUtils.splitHeader(header);

                // 조건식 안에 들어있는 코드를 통해 토큰을 검증한
                // 검증 결과가 True(유효한토큰) 이면 이후 처리를 진행한다.
                if(TokenUtils.isValidToken(token)){

                    // payload에 담긴 (토큰에 담겨있는 정보들)
                    Claims claims = TokenUtils.getClaimsFromToken(token);

                    // 토큰에 담긴 정보로 Member 객체를 만든다.
                    // (security context에 등록된 인증 객체를 (UserDetail)를 만들기 위해
                    User user = User.builder()
                            .userName(claims.get("userName").toString())
                            .email(claims.get("Email").toString())
                            .userRole(RoleType.valueOf(claims.get("userRole").toString()))
                            .build();

                    // 토큰에 담겨있던 정보로 인증 객체를 만든다.
                    CustomUserDetails userDetails = new CustomUserDetails();
                    userDetails.setUser(user);

                    // 인증된 사용자 토큰
                    AbstractAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    // authenticationToken에 추가 정보 설정( IP, 세션 정보)
                    authenticationToken.setDetails(new WebAuthenticationDetails(request));

                    // SecurityContextHolder에 인증 객체 등록
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                    // 다음 필터로 이동하세요
                    chain.doFilter(request, response);
                }else{
                    throw new RuntimeException("토큰이 유효하지 않습니다.");
                }
            }else{
                throw new RuntimeException("토큰이 존재하지 않습니다.");
            }
        }catch (Exception e){

            // Exception 발생시 Exception 내용을 응답해준다.
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            PrintWriter printWriter = response.getWriter();

            JSONObject jsonObject = jsonresponseWrapper(e);

            printWriter.print(jsonObject);
            printWriter.flush();
            printWriter.close();
        }
    }

    private JSONObject jsonresponseWrapper(Exception e) {
        String resultMsg = "";
        if (e instanceof ExpiredJwtException) {
            // 토큰 만료 exception
            resultMsg = "Token Expired";
        } else if (e instanceof SignatureException) {

            // 토큰 서명 exception
            resultMsg = "TOKEN SignatureException Login";
        }
        // JWT 토큰내에서 오류 발생 시
        else if (e instanceof JwtException) {
            resultMsg = "TOKEN Parsing JwtException";
        }
        // 이외 JTW 토큰내에서 오류 발생
        else {
            System.out.println(e.getMessage());
            resultMsg = "OTHER TOKEN ERROR";
        }

        HashMap<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("status", 401);
        jsonMap.put("message", resultMsg);
        jsonMap.put("reason", e.getMessage());
        JSONObject jsonObject = new JSONObject(jsonMap);
        return jsonObject;
    }
}
