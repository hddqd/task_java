import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Create {

    public static void createHospital(Connection connection, Hospital hospital) throws SQLException {
        String hospitalId = hospital.id;
        String hospitalName = hospital.hospitalName;
        String address = hospital.address;
        String telephoneNumber = hospital.telephoneNumber;
        String workingHours = hospital.workingHours;

        String insertHospitalQuery = "INSERT INTO hospital (id, hospital_name, address, telephone_number, working_hours) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertHospitalQuery)) {
            preparedStatement.setString(1, hospitalId);
            preparedStatement.setString(2, hospitalName);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, telephoneNumber);
            preparedStatement.setString(5, workingHours);

            preparedStatement.executeUpdate();
            System.out.println("Hospital record created successfully!");
        }
    }

    public static void createPatient(Connection connection, Patient patient) throws SQLException {
        String patientId = patient.id;
        String firstName = patient.firstName;
        String lastName = patient.lastName;
        String dateOfBirth = patient.dateOfBirth;
        String address = patient.address;
        String phoneNumber = patient.phoneNumber;
        String emailAddress = patient.emailAddress;

        String insertPatientQuery = "INSERT INTO patient (id, first_name, last_name, date_of_birth, address, phone_number, email_address) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertPatientQuery)) {
            preparedStatement.setString(1, patientId);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, dateOfBirth);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, phoneNumber);
            preparedStatement.setString(7, emailAddress);

            preparedStatement.executeUpdate();
            System.out.println("Patient record created successfully!");
        }
    }

    public static void createDoctor(Connection connection, Doctor doctor) throws SQLException {
        String doctorId = doctor.id;
        String firstName = doctor.firstName;
        String lastName = doctor.lastName;
        String specialization = doctor.specialization;

        String insertDoctorQuery = "INSERT INTO doctor (id, first_name, last_name, specialization) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDoctorQuery)) {
            preparedStatement.setString(1, doctorId);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, specialization);

            preparedStatement.executeUpdate();
            System.out.println("Doctor record created successfully!");
        }
    }

    public static void createProcedure(Connection connection, Procedure procedure) throws SQLException {
        String procedureId = procedure.id;
        String procedureName = procedure.procedureName;
        String price = procedure.price;
        String duration = procedure.duration;

        String insertProcedureQuery = "INSERT INTO procedure (id, procedure_name, price, duration) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertProcedureQuery)) {
            preparedStatement.setString(1, procedureId);
            preparedStatement.setString(2, procedureName);
            preparedStatement.setString(3, price);
            preparedStatement.setString(4, duration);

            preparedStatement.executeUpdate();
            System.out.println("Procedure record created successfully!");
        }
    }

    public static void createAppointment(Connection connection, Appointment appointment) throws SQLException {
        String appointmentId = appointment.id;
        String medicineName = appointment.medicineName;
        String description = appointment.description;

        String insertAppointmentQuery = "INSERT INTO appointment (id, medicine_name, description) " +
                "VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertAppointmentQuery)) {
            preparedStatement.setString(1, appointmentId);
            preparedStatement.setString(2, medicineName);
            preparedStatement.setString(3, description);

            preparedStatement.executeUpdate();
            System.out.println("Appointment record created successfully!");
        }
    }

    public static void createMedicalCard(Connection connection, MedicalCard medicalCard) throws SQLException {
        String cardId = medicalCard.id;
        String creationDate = medicalCard.creationDate;
        String diagnosis = medicalCard.diagnosis;
        String attendingDoctor = medicalCard.attendingDoctor;

        String insertMedicalCardQuery = "INSERT INTO medicalcard (id, creation_date, diagnosis, attending_doctor) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertMedicalCardQuery)) {
            preparedStatement.setString(1, cardId);
            preparedStatement.setString(2, creationDate);
            preparedStatement.setString(3, diagnosis);
            preparedStatement.setString(4, attendingDoctor);

            preparedStatement.executeUpdate();
            System.out.println("Medical Card record created successfully!");
        }
    }
}
