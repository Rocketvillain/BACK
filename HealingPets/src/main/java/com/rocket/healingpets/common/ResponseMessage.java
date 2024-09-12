package com.rocket.healingpets.users.common;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseMessage {

    private int httpStatusCode;
    private String message;
    private Map<String, Object> results;

    public ResponseMessage(HttpStatus httpStatus, String message, Map<String, Object> results){
        this.httpStatusCode = httpStatus.value();
        this.message = message;
        this.results = new HashMap<>();
    }

}
