package org.example;

import CRUD.Create;
import CRUD.Delete;
import CRUD.Read;
import CRUD.Update;
import console_utils.General;

import java.sql.*;
import java.util.*;

import static console_utils.CreateUtils.*;
import static console_utils.General.*;
import static console_utils.UpdateUtils.collectUpdateData;
import static CRUD.Create.*;
import static CRUD.Read.*;
import static org.example.Operation.*;

public class AppCRUD {

    public void start() {

        try {
            // Подключение к базе данных
            Connection connection = DatabaseInitializer.getConnection();

            // Бесконечный цикл для обработки операций
            while (true) {
                // Вывод меню
                General.displayMenu();
                // Запрос у пользователя выбора операции
                int operationChoice = General.getUserInputAsInt("Enter operation number:");
                // Выбор операции и передача управления соответствующему классу
                Operation operation = Operation.values()[operationChoice];
                switch (operation) {
                    case CREATE:

                        int tableChoice = General.getTableNum(scanner);
                        Table table = Table.values()[tableChoice - 1];
                        switch (table) {
                            case APPOINTMENT:
                                Map<String, Object> appointmentAttributes = collectAppointmentData(scanner);
                                createAppointment(connection, appointmentAttributes);
                                break;
                            case DOCTOR:
                                Map<String, Object> doctorAttributes = collectDoctorData(scanner);
                                createDoctor(connection, doctorAttributes);
                                break;
                            case HOSPITAL:
                                Map<String, Object> hospitalAttributes = collectHospitalData(scanner);
                                createHospital(connection, hospitalAttributes);
                                break;
                            case MEDICALCARD:
                                Map<String, Object> MedicalCardAttributes = collectMedicalCardData(scanner);
                                createMedicalCard(connection, MedicalCardAttributes);
                                break;
                            case PATIENT:
                                Map<String, Object> patientAttributes = collectPatientData(scanner);
                                createPatient(connection, patientAttributes);
                                break;
                            case PROCEDURE:
                                Map<String, Object> procedureAttributes = collectProcedureData(scanner);
                                createProcedure(connection, procedureAttributes);
                                break;
                            default:
                                System.out.println("Invalid table number.");
                        }
                        break;

                    case READ:

                        int choice = getUserInputAsInt("Enter 1 to read a specific tuple, 2 to read the entire table:");
                        int tableChoice2 = General.getTableNum(scanner);
                        String tableName2 = getTableNameByChoice(tableChoice2);
                        switch (choice) {
                            case 1:


                                Table table2 = Table.values()[tableChoice2 - 1];

                                switch (table2) {
                                    case APPOINTMENT:
                                        String appoinmentId = getUserInput("Enter the ID of the appointment:");
                                        Appointment appointment = Read.readAppointmentById(connection, appoinmentId);
                                        System.out.println(appointment);
                                        break;

                                    case DOCTOR:
                                        String doctorId = getUserInput("Enter the ID of the doctor:");
                                        Doctor doctor = Read.readDoctorById(connection, doctorId);
                                        System.out.println(doctor);
                                        break;

                                    case HOSPITAL:
                                        String hospitalId = getUserInput("Enter the ID of the hospital:");
                                        Hospital hospital = Read.readHospitalById(connection, hospitalId);
                                        System.out.println(hospital);
                                        break;

                                    case MEDICALCARD:
                                        String medicalcardId = getUserInput("Enter the ID of the MedicalCard:");
                                        Medicalcard medicalcard = Read.readMedicalCardById(connection, medicalcardId);
                                        System.out.println(medicalcard);
                                        break;

                                    case PATIENT:
                                        String patientId = getUserInput("Enter the ID of the patient:");
                                        Patient patient = Read.readPatientById(connection, patientId);
                                        System.out.println(patient);
                                        break;

                                    case PROCEDURE:
                                        String procedureId = getUserInput("Enter the ID of the procedure:");
                                        Procedure procedure = Read.readProcderuById(connection, procedureId);
                                        System.out.println(procedure);
                                        break;

                                    default:
                                        System.out.println("Invalid table selection.");
                                        break;
                                }

                                break;
                            case 2:
                                // Read the entire table
                                int limit = getUserInputAsInt("Enter the number of tuples to read (enter 0 to read all):");
                                readTable(connection, tableName2, limit);
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                        break;


                    case UPDATE:
                        int tableChoice3 = getTableNum(scanner);
                        String tableName3 = getTableNameByChoice(tableChoice3);
                        Map<String, Object> updateData = collectUpdateData(connection, scanner, tableName3);
                        if (updateData == null) {
                            break;
                        }
                        String UpdateTableName = (String) updateData.get("tableName");
                        String recordId = (String) updateData.get("recordId");
                        String attributeName = (String) updateData.get("attributeName");
                        String newValue = (String) updateData.get("newValue");

                        Update.updateRecordAttribute(connection, UpdateTableName, recordId, attributeName, newValue);
                        break;

                    case DELETE:

                        tablesMenu();
                        int choiceForDelete = getUserInputAsInt("Enter the number of the table to delete the row (enter 0 to exit):");
                        String tableNameForDeleteRow = getTableNameByChoice(choiceForDelete);
                        String idOfRecord = getUserInput("Enter the ID of the record to delete");
                        Delete.deleteRow(connection, tableNameForDeleteRow, idOfRecord);
                        break;
                    case STOP:
                        System.out.println("Exiting the application. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid operation number. Please try again.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }




    public static void main(String[] args) {
        new AppCRUD().start();
    }
}

