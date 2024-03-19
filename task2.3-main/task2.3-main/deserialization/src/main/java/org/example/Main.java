package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Main deerizalization is started");

        String inputPath = "patients.json";
        //String inputPath = "deserialization/src/main/java/org/example/patients.json";

        JsonDeserializer jsonDeserializer = new JsonDeserializer();
        List<Patient> patients = jsonDeserializer.deserializeFromJson(inputPath);

        for (Patient patient : patients) {
            System.out.println(patient); // выводим информацию о каждом пациенте в консоль
        }

        System.out.println("Main derizalization is finished");

    }
}