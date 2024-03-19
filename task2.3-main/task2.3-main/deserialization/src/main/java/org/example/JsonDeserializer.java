package org.example;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonDeserializer {
    public List<Patient> deserializeFromJson(String inputPath) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Patient> patients = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath), StandardCharsets.UTF_8)) {
            JsonParser parser = objectMapper.getFactory().createParser(reader);

            if (parser.nextToken() == JsonToken.START_ARRAY) {
                while (parser.nextToken() != JsonToken.END_ARRAY) { // десериализуем каждый объект пациента
                    Patient patient = objectMapper.readValue(parser, Patient.class);
                    patients.add(patient);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return patients;
    }
}
