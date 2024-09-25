package com.rocket.healingpets.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConvertUtil {

    // 자바 객체를 JSON 문자열로 변환 후, JSON 객체로 변환하는 기능
    public static Object convertObjectToJsonObject(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        JSONParser parser = new JSONParser();
        String convertJsonString;
        Object convertObj;

        try {
            convertJsonString = mapper.writeValueAsString(obj);
            convertObj = parser.parse(convertJsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return convertObj;
    }
}