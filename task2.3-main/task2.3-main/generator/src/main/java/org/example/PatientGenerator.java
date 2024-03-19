package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class PatientGenerator {

    private static int lastGeneratedIndex = 1; //  переменная для отслеживания последнего использованного индекса
    private static final Random random = new Random();
    public Patient generatePatients() {

        String id = generateUniqueId();
        String firstName = generateFirstName(lastGeneratedIndex);
        String lastName = generateLastName(lastGeneratedIndex);
        String dateOfBirth = generateDateOfBirth(lastGeneratedIndex);
        String address = generateAddress(lastGeneratedIndex);
        String phoneNumber = generatePhoneNumber(lastGeneratedIndex);
        String emailAddress = generateEmailAddress(lastGeneratedIndex);
        List<MedicalCard> medicalCards = generateMedCards(lastGeneratedIndex);
        List<Appointment> appointments = generateAppointments(lastGeneratedIndex);
        List<Doctor> doctors = generateDoctors(lastGeneratedIndex);
        List<Procedure> procedures = generateProcedures(lastGeneratedIndex);
        Hospital hospital = generateHospital(lastGeneratedIndex);

        Patient patient = new Patient(id, firstName, lastName, dateOfBirth, address, phoneNumber, emailAddress,
                medicalCards, appointments, doctors, procedures, hospital);

        lastGeneratedIndex += 1; // обновляем последний использованный индекс

        return patient;
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    private String generateFirstName(int iteration) {
        return "UserName" + iteration;
    }

    private String generateLastName(int iteration) {
        return "UserLastName" + iteration;
    }

    private String generateDateOfBirth(int iteration) {
        return "UserBirthDate" + iteration;
    }

    private String generateAddress(int iteration) {
        return "UserAddress" + iteration;
    }

    private String generatePhoneNumber(int iteration) {
        return "UserPhone" + iteration;
    }

    private String generateEmailAddress(int iteration) {
        return "UserMail" + iteration;
    }




    private String generateAttributeValue(String attributeName, int iteration, int count) {
        return "User" + iteration + attributeName + count;
    }

    public List<MedicalCard> generateMedCards(int index) {

        int numberOfCardsOrAccounts = generateMedCardsOrAppsOrProcedures();

        List<MedicalCard> medicalCards = new ArrayList<>();


        for (int i = 1; i <= numberOfCardsOrAccounts; i++) {
            String id = generateUniqueId();
            String creationDate = generateAttributeValue("creationDate", index, i);
            String diagnosis = generateAttributeValue("diagnose", index, i);
            String attendingDoctor = generateAttributeValue("attendingDoctor", index, i);
            medicalCards.add(new MedicalCard(id, creationDate, diagnosis, attendingDoctor));
        }

        return medicalCards;

    }

    private List<Appointment> generateAppointments(int iteration) {

        int numberOfAppointments = generateMedCardsOrAppsOrProcedures();

        List<Appointment> appointments = new ArrayList<>();

        for (int i = 1; i <= numberOfAppointments; i++) {
            String id = generateUniqueId();
            String medicineName = generateAttributeValue("medicineName", iteration, i);
            String description = generateAttributeValue("description", iteration, i);
            appointments.add(new Appointment(id, medicineName, description));
        }

        return appointments;
    }

    private List<Doctor> generateDoctors(int iteration) {

        int numberOfDoctors = generateDoctorsCount();
        List<Doctor> doctors = new ArrayList<>();

        for (int i = 0; i < numberOfDoctors; i++) {
            String id = generateUniqueId();
            String firstName = generateAttributeValue("firstName", iteration, i);
            String lastName = generateAttributeValue("lastName", iteration, i);
            String specialization = generateAttributeValue("specialization", iteration, i);
            doctors.add(new Doctor(id, firstName, lastName, specialization));
        }

        return doctors;
    }

    private List<Procedure> generateProcedures(int iteration) {

        int numberOfProcedures = generateMedCardsOrAppsOrProcedures();
        List<Procedure> procedures = new ArrayList<>();

        for (int i = 0; i < numberOfProcedures; i++) {
            String id = generateUniqueId();
            String procedureName = generateAttributeValue("procedureName", iteration, i);
            String price = generateAttributeValue("price", iteration, i);
            String duration = generateAttributeValue("duration", iteration, i);
            procedures.add(new Procedure(id, procedureName, price, duration));
        }

        return procedures;
    }

    private Hospital generateHospital(int iteration) {
        String id = generateUniqueId();
        String hospitalName = generateAttributeValue("hospitalName", iteration, 0);
        String address = generateAttributeValue("address", iteration, 0);
        String telephoneNumber = generateAttributeValue("telephoneNumber", iteration, 0);
        String workingHours = generateAttributeValue("workingHours", iteration, 0);

        return new Hospital(id, hospitalName, address, telephoneNumber, workingHours);
    }

    public static int generateMedCardsOrAppsOrProcedures() {
        int randomNumber = generateRandomNumber();
        if (randomNumber <= 6) {
            return 1; // ≈60% шанс
        } else if (randomNumber <= 9) {
            return 2; // ≈30% шанс
        } else {
            return 3; // ≈10% шанс
        }
    }

    private static int generateRandomNumber() {
        return random.nextInt(10 - 1 + 1) + 1;
    }

    public static int generateDoctorsCount() {
        int randomNumber = generateRandomNumber();
        if (randomNumber <= 5) {
            return 1; // ≈50% шанс
        } else if (randomNumber <= 7) {
            return 2; // ≈30% шанс
        } else {
            return 3; // ≈20% шанс
        }
    }


}

