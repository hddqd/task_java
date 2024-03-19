package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DatabasePopulator {

    public static void fillTables() {
        System.out.println("Main deserialization is started");

        String inputPath = "deserialization/src/main/java/org/example/clients.json";

        JsonDeserializer jsonDeserializer = new JsonDeserializer();
        List<Client> clients = jsonDeserializer.deserializeFromJson(inputPath);

        try (Connection connection = getConnection()) {
            for (Client client : clients) {
                insertClient(connection, client);
                insertAccounts(connection, client);
                insertBankCards(connection, client);
                insertCredits(connection, client);
                insertDeposits(connection, client);
                insertTransactionHistories(connection, client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertPatient(Connection connection, Patient patient) throws SQLException {
        String insertPatientQuery = "INSERT INTO patient (id, first_name, last_name, date_of_birth, address, phone_number, email_address) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertPatientQuery)) {
            preparedStatement.setString(1, patient.id);
            preparedStatement.setString(2, patient.firstName);
            preparedStatement.setString(3, patient.lastName);
            preparedStatement.setString(4, patient.dateOfBirth);
            preparedStatement.setString(5, patient.address);
            preparedStatement.setString(6, patient.phoneNumber);
            preparedStatement.setString(7, patient.emailAddress);

            preparedStatement.executeUpdate();
        }
    }

    private static void insertDoctors(Connection connection, Patient patient) throws SQLException {
        String insertDoctorQuery = "INSERT INTO doctor (id, first_name, last_name, specialization) " +
                "VALUES (?, ?, ?, ?)";

        List<Doctor> doctors = patient.doctors;

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDoctorQuery)) {
            for (Doctor doctor : doctors) {
                preparedStatement.setString(1, doctor.id);
                preparedStatement.setString(2, doctor.firstName);
                preparedStatement.setString(3, doctor.lastName);
                preparedStatement.setString(4, doctor.specialization);

                preparedStatement.executeUpdate();
            }
        }
    }

    private static void insertAppointments(Connection connection, Patient patient) throws SQLException {
        String insertAppointmentQuery = "INSERT INTO appointment (id, medicine_name, description) " +
                "VALUES (?, ?, ?)";

        List<Appointment> appointments = patient.appointments;

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertAppointmentQuery)) {
            for (Appointment appointment : appointments) {
                preparedStatement.setString(1, appointment.id);
                preparedStatement.setString(2, appointment.medicineName);
                preparedStatement.setString(3, appointment.description);

                preparedStatement.executeUpdate();
            }
        }
    }


    private static void insertMedicalCards(Connection connection, Patient patient) throws SQLException {
        String insertMedicalCardQuery = "INSERT INTO medical_card (id, creation_date, diagnosis, attending_doctor_id) " +
                "VALUES (?, ?, ?, ?)";

        List<MedicalCard> medicalCards = patient.medicalCards;

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertMedicalCardQuery)) {
            for (MedicalCard medicalCard : medicalCards) {
                preparedStatement.setString(1, medicalCard.id);
                preparedStatement.setString(2, medicalCard.creationDate);
                preparedStatement.setString(3, medicalCard.diagnosis);
                preparedStatement.setString(4, medicalCard.attendingDoctor);

                preparedStatement.executeUpdate();
            }
        }
    }

    private static void insertProcedures(Connection connection, Patient patient) throws SQLException {
        String insertProcedureQuery = "INSERT INTO procedure (id, procedure_name, price, duration) " +
                "VALUES (?, ?, ?, ?)";

        List<Procedure> procedures = patient.procedures;

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertProcedureQuery)) {
            for (Procedure procedure : procedures) {
                preparedStatement.setString(1, procedure.id);
                preparedStatement.setString(2, procedure.procedureName);
                preparedStatement.setString(3, procedure.price);
                preparedStatement.setString(4, procedure.duration);

                preparedStatement.executeUpdate();
            }
        }
    }

    private static void insertHospital(Connection connection, Patient patient) throws SQLException {
        String insertHospitalQuery = "INSERT INTO hospital (id, hospital_name, address, telephone_number, working_hours) " +
                "VALUES (?, ?, ?, ?, ?)";

        Hospital hospital = patient.hospital;

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertHospitalQuery)) {
            preparedStatement.setString(1, hospital.id);
            preparedStatement.setString(2, hospital.hospitalName);
            preparedStatement.setString(3, hospital.address);
            preparedStatement.setString(4, hospital.telephoneNumber);
            preparedStatement.setString(5, hospital.workingHours);

            preparedStatement.executeUpdate();
        }
    }
}
