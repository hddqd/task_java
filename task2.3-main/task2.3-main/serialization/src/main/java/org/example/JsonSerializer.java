package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonSerializer {

    public String serializeToJson(Patient patient) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(patient);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
