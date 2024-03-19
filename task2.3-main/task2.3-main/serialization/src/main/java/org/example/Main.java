package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        System.out.println("Main Serizalization is started");

        PatientGenerator generator = new PatientGenerator();
        JsonSerializer jsonSerializer = new JsonSerializer();
        //String outputPath = "deserialization/src/main/java/org/example/patients.json";
        String outputPath = "patients.json";
        int numberOfPatientsToGenerate = 10000; // количество пациентов для генерации

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath), StandardCharsets.UTF_8)) {
            writer.write("[");
            for (int i = 0; i < numberOfPatientsToGenerate; i++) {
                Patient patient = generator.generatePatients(); // создаем и получаем первого пациента
                String json = jsonSerializer.serializeToJson(patient);
                writer.write(json);

                if (i < numberOfPatientsToGenerate - 1) {
                    writer.write(",");
                }
            }

            writer.write("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Main Serizalization is finished");


    }
}