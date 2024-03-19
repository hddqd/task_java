package CRUD;

import org.example.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Read {

        public static Appointment readAppointmentById(Connection connection, String id) throws SQLException {
            String tableName = "appointment";

            String selectQuery = "SELECT * FROM " + tableName + " WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Appointment appointment = new Appointment(
                                resultSet.getString("id"),
                                resultSet.getString("medicineName"),
                                resultSet.getString("description")
                        );
                        return appointment;
                    } else {
                        return null; // Если запись с указанным id не найдена
                    }
                }
            }
        }

        public static Doctor readDoctorById(Connection connection, String id) throws SQLException {
            String tableName = "doctor";

            String selectQuery = "SELECT * FROM " + tableName + " WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Doctor doctor = new Doctor(
                                resultSet.getString("id"),
                                resultSet.getString("firstName"),
                                resultSet.getString("lastName"),
                                resultSet.getString("specialization")
                        );
                        return doctor;
                    } else {
                        return null; // Если запись с указанным id не найдена
                    }
                }
            }
        }

        public static MedicalCard readMedicalCardById(Connection connection, String id) throws SQLException {
            String tableName = "medicalcard";

            String selectQuery = "SELECT * FROM " + tableName + " WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        MedicalCard medicalCard = new MedicalCard(
                                resultSet.getString("id"),
                                resultSet.getString("creationDate"),
                                resultSet.getString("diagnosis"),
                                resultSet.getString("attendingDoctor")
                        );
                        return medicalCard;
                    } else {
                        return null; // Если запись с указанным id не найдена
                    }
                }
            }
        }

        public static Patient readPatientById(Connection connection, String id) throws SQLException {
            String tableName = "patient";

            String selectQuery = "SELECT * FROM " + tableName + " WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {

                        Patient patient = new Patient(
                                resultSet.getString("id"),
                                resultSet.getString("firstName"),
                                resultSet.getString("lastName"),
                                resultSet.getString("dateOfBirth"),
                                resultSet.getString("address"),
                                resultSet.getString("phoneNumber"),
                                resultSet.getString("emailAddress"),
                                null
                        );
                        return patient;
                    } else {
                        return null; // Если запись с указанным id не найдена
                    }
                }
            }
        }


    public class ProcedureRead {

        public static Procedure readProcedureById(Connection connection, String id) throws SQLException {
            String tableName = "procedure";

            String selectQuery = "SELECT * FROM " + tableName + " WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Procedure procedure = new Procedure(
                                resultSet.getString("id"),
                                resultSet.getString("procedureName"),
                                resultSet.getString("price"),
                                resultSet.getString("duration")
                        );
                        return procedure;
                    } else {
                        return null; // Если запись с указанным id не найдена
                    }
                }
            }
        }

    }

    public static List<Map<String, String>> readTable(Connection connection, String tableName, int limit) throws SQLException {
        String[] attributes = getTableAttributes(tableName);

        String selectQuery = "SELECT * FROM " + tableName;

        if (limit > 0) {
            selectQuery += " LIMIT " + limit;
        }

        List<Map<String, String>> tableData = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Map<String, String> row = new LinkedHashMap<>(); // Используем LinkedHashMap для сохранения порядка атрибутов

                for (String attribute : attributes) {
                    row.put(attribute, resultSet.getString(attribute));
                }
                tableData.add(row);
            }
        }

        return tableData;
    }

    private static String[] getTableAttributes(String tableName) {
        switch (tableName) {
            case "patient":
                return new String[]{"id", "first_name", "last_name", "date_of_birth", "address", "phone_number", "email_address"};
            case "doctor":
                return new String[]{"id", "first_name", "last_name", "specialization"};
            case "hospital":
                return new String[]{"id", "hospital_name", "address", "telephone_number", "working_hours"};
            case "medicalcard":
                return new String[]{"id", "creation_date", "diagnosis", "attending_doctor"};
            case "appointment":
                return new String[]{"id", "medicine_name", "description"};
            case "procedure":
                return new String[]{"id", "procedure_name", "price", "duration"};
            default:
                throw new IllegalArgumentException("Invalid table name.");
        }
    }


}
