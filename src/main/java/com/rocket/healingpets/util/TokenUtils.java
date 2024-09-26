package com.rocket.healingpets.util;

import com.rocket.healingpets.users.model.entitiy.User;
import io.jsonwebtoken.*;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtils {

    private static String rocketSecretKey; // 토큰 키
    private static Long tokenValidateTime; //만료시간

    @Value("${rocket.key}")
    public void setRocketSecretKey(String rocketSecretKey) {
        TokenUtils.rocketSecretKey = rocketSecretKey;
    }

    @Value("${rocket.time}")
    public void setTokenValidateTime(Long tokenValidateTime) {
        TokenUtils.tokenValidateTime = tokenValidateTime;
    }

    /**
     * header의 token을 분리하는 메서드
     * @param header: Authrization의 header값을 가져온다.
     * @return token: Authrization의 token 부분을 반환한다.
     * */
    public static String splitHeader(String header){
        if(!header.equals("")){
            return header.split(" ")[1];
        }else{
            return null;
        }
    }

    /**
     * 유효한 토큰인지 확인하는 메서드
     * @param token : 토큰
     * @return boolean : 유효 여부
     * @throws ExpiredJwtException, {@link JwtException} {@link NullPointerException}
     * */
    public static boolean isValidToken(String token){

        try{
            Claims claims = getClaimsFromToken(token);
            return true;
        }catch (ExpiredJwtException e){
            e.printStackTrace();
            return false;
        }catch (JwtException e){
            e.printStackTrace();
            return false;
        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 토큰을 복호화 하는 메서드
     * @param token
     * @return Claims
     * */
    public static Claims getClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(rocketSecretKey))
                .parseClaimsJws(token).getBody();
    }

    /**
     * token을 생성하는 메서드
     * @param user 사용자객체
     * @return String - token
     * */
    public static String generateJwtToken(User user) {
        // 토큰 만료시간 설정 (현재 시간 + 만료시간 )
        Date expireTime = new Date(System.currentTimeMillis() + tokenValidateTime);

        JwtBuilder builder = Jwts.builder()
                // 토큰 헤더 설정
                .setHeader(createHeader())

                // 토큰에 담길 payload설정
                .setClaims(createClaims(user))
                .setSubject(user.getUserId())
                .signWith(SignatureAlgorithm.HS256, createSignature())

                // 토큰 시그니쳐 설정 (secretKey)
                .setExpiration(expireTime);

        return builder.compact();
    }

    /**
     * token의 header를 설정하는 부분이다.
     * @return Map<String, Object> - header의 설정 정보
     * */
    private static Map<String, Object> createHeader(){
        Map<String, Object> header = new HashMap<>();

        // 토큰 타입
        header.put("type", "jwt");
        // 토큰에 상용된 알고리즘
        header.put("alg", "HS256");
        //토큰 생성일
        header.put("date", System.currentTimeMillis());

        return header;
    }

    /**
     * 사용자 정보를 기반으로 클레임을 생성해주는 메서드
     *
     * @param user - 사용자 정보
     * @return Map<String, Object> - cliams 정보
     * */
    private static Map<String, Object> createClaims(User user){
        Map<String, Object> claims = new HashMap<>();

        claims.put("userName", user.getUserName());
        claims.put("userRole", user.getUserRole());
        claims.put("Email", user.getEmail());

        return claims;
    }


    /**
     * JWT 서명을 발급해주는 메서드이다.
     *
     * @return key
     * */
    private static Key createSignature(){

        // HS256 알고리즘을 사용해서 Base64로 인코딩된 비밀키를 바이트 배열로 변환
        byte[] secretBytes = DatatypeConverter.parseBase64Binary(rocketSecretKey);

        // 서명에 사용할 수 있는 key 객체러 변환하는 과정
        return new SecretKeySpec(secretBytes, SignatureAlgorithm.HS256.getJcaName());
    }

}