package com.app.util;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonUtil {

    private ObjectMapper mapper = new ObjectMapper();

    public String praseObjToJson(Object obj) {
        String json = "";

        try {
            json = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            System.out.println("JSON PRASE ERROE");
            e.printStackTrace();
        }

        return json;
    }

}
