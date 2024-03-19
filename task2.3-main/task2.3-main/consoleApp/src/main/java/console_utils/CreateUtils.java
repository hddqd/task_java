package console_utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class CreateUtils {

    public static Map<String, Object> collectAppointmentData(Scanner scanner) {
        System.out.println("Creating a new appointment record:");

        Map<String, Object> appointmentData = new HashMap<>();

        String appointmentId = UUID.randomUUID().toString();

        String medicineName = General.getUserInput2(scanner, "Enter medicine name", ".+");
        String description = General.getUserInput2(scanner, "Enter description", ".+");

        appointmentData.put("appointmentId", appointmentId);
        appointmentData.put("medicineName", medicineName);
        appointmentData.put("description", description);

        return appointmentData;
    }

    public static Map<String, Object> collectDoctorData(Scanner scanner) {
        System.out.println("Creating a new doctor record:");

        Map<String, Object> doctorData = new HashMap<>();

        String doctorId = UUID.randomUUID().toString();

        String firstName = General.getUserInput2(scanner, "Enter doctor's first name", "[A-Za-z]+");
        String lastName = General.getUserInput2(scanner, "Enter doctor's last name", "[A-Za-z]+");
        String specialization = General.getUserInput2(scanner, "Enter doctor's specialization", ".+");

        doctorData.put("doctorId", doctorId);
        doctorData.put("firstName", firstName);
        doctorData.put("lastName", lastName);
        doctorData.put("specialization", specialization);

        return doctorData;
    }

    public static Map<String, Object> collectHospitalData(Scanner scanner) {
        System.out.println("Creating a new hospital record:");

        Map<String, Object> hospitalData = new HashMap<>();

        String hospitalId = UUID.randomUUID().toString();

        String hospitalName = General.getUserInput2(scanner, "Enter hospital name", ".+");
        String address = General.getUserInput2(scanner, "Enter hospital address", ".+");
        String telephoneNumber = General.getUserInput2(scanner, "Enter telephone number", "\\d{10,15}");
        String workingHours = General.getUserInput2(scanner, "Enter working hours", ".+");

        hospitalData.put("hospitalId", hospitalId);
        hospitalData.put("hospitalName", hospitalName);
        hospitalData.put("address", address);
        hospitalData.put("telephoneNumber", telephoneNumber);
        hospitalData.put("workingHours", workingHours);

        return hospitalData;
    }

    public static Map<String, Object> collectMedicalCardData(Scanner scanner) {
        System.out.println("Creating a new medical card record:");

        Map<String, Object> medicalCardData = new HashMap<>();

        String medicalCardId = UUID.randomUUID().toString();

        String creationDate = General.getUserInput2(scanner, "Enter creation date (yyyy-MM-dd)", "\\d{4}-\\d{2}-\\d{2}");
        String diagnosis = General.getUserInput2(scanner, "Enter diagnosis", ".+");
        String attendingDoctor = General.getUserInput2(scanner, "Enter attending doctor ID", ".+");

        medicalCardData.put("medicalCardId", medicalCardId);
        medicalCardData.put("creationDate", creationDate);
        medicalCardData.put("diagnosis", diagnosis);
        medicalCardData.put("attendingDoctor", attendingDoctor);

        return medicalCardData;
    }

    public static Map<String, Object> collectPatientData(Scanner scanner) {
        System.out.println("Creating a new patient record:");

        Map<String, Object> patientData = new HashMap<>();

        String patientId = UUID.randomUUID().toString();

        String firstName = General.getUserInput2(scanner, "Enter patient's first name", "[A-Za-z]+");
        String lastName = General.getUserInput2(scanner, "Enter patient's last name", "[A-Za-z]+");
        String dateOfBirth = General.getUserInput2(scanner, "Enter patient's date of birth (yyyy-MM-dd)", "\\d{4}-\\d{2}-\\d{2}");
        String address = General.getUserInput2(scanner, "Enter patient's address", ".+");
        String phoneNumber = General.getUserInput2(scanner, "Enter patient's phone number", "\\d{10,15}");
        String emailAddress = General.getUserInput2(scanner, "Enter patient's email address", "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}");

        patientData.put("patientId", patientId);
        patientData.put("firstName", firstName);
        patientData.put("lastName", lastName);
        patientData.put("dateOfBirth", dateOfBirth);
        patientData.put("address", address);
        patientData.put("phoneNumber", phoneNumber);
        patientData.put("emailAddress", emailAddress);

        return patientData;
    }

    public static Map<String, Object> collectProcedureData(Scanner scanner) {
        System.out.println("Creating a new procedure record:");

        Map<String, Object> procedureData = new HashMap<>();

        String procedureId = UUID.randomUUID().toString();

        String procedureName = General.getUserInput2(scanner, "Enter procedure name", ".+");
        String price = General.getUserInput2(scanner, "Enter procedure price", "\\d+");
        String duration = General.getUserInput2(scanner, "Enter procedure duration", ".+");

        procedureData.put("procedureId", procedureId);
        procedureData.put("procedureName", procedureName);
        procedureData.put("price", price);
        procedureData.put("duration", duration);

        return procedureData;
    }
}
