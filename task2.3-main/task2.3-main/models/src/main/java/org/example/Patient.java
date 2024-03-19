package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Patient {
    public final String id;
    public final String firstName;
    public final String lastName;
    public final String dateOfBirth;
    public final String address;
    public final String phoneNumber;
    public final String emailAddress;
    public final List<MedicalCard> medicalCards;
    public final List<Appointment> appointments;
    public final List<Doctor> doctors;
    public final List<Procedure> procedures;
    public final Hospital hospital;


    @JsonCreator
    public Patient(@JsonProperty("id") String id,
                   @JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("dateOfBirth") String dateOfBirth,
                   @JsonProperty("address") String address,
                   @JsonProperty("phoneNumber") String phoneNumber,
                   @JsonProperty("emailAddress") String emailAddress,
                   @JsonProperty("medicalCards") List<MedicalCard> medicalCards,
                   @JsonProperty("appointments") List<Appointment> appointments,
                   @JsonProperty("doctors") List<Doctor> doctors,
                   @JsonProperty("procedures") List<Procedure> procedures,
                   @JsonProperty("hospital") Hospital hospital) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.medicalCards = medicalCards;
        this.appointments = appointments;
        this.doctors = doctors;
        this.procedures = procedures;
        this.hospital = hospital;
    }


    // методы для обновления атрибутов

    public Patient withId(String newId) {
        return new Patient(newId, this.firstName, this.lastName, this.dateOfBirth, this.address, this.phoneNumber, this.emailAddress,
                this.medicalCards, this.appointments, this.doctors, this.procedures, this.hospital);
    }

    public Patient withFirstName(String newFirstName) {
        return new Patient(id, newFirstName, lastName, dateOfBirth, address,
                phoneNumber, emailAddress, medicalCards, appointments, doctors,
                procedures, hospital);
    }

    public Patient withLastName(String newLastName) {
        return new Patient(id, firstName, newLastName, dateOfBirth, address,
                phoneNumber, emailAddress, medicalCards, appointments, doctors,
                procedures, hospital);
    }

    public Patient withDateOfBirth(String newDateOfBirth) {
        return new Patient(id, firstName, lastName, newDateOfBirth, address,
                phoneNumber, emailAddress, medicalCards, appointments, doctors,
                procedures, hospital);
    }

    public Patient withAddress(String newAddress) {
        return new Patient(id, firstName, lastName, dateOfBirth, newAddress,
                phoneNumber, emailAddress, medicalCards, appointments, doctors,
                procedures, hospital);
    }

    public Patient withPhoneNumber(String newPhoneNumber) {
        return new Patient(id, firstName, lastName, dateOfBirth, address,
                newPhoneNumber, emailAddress, medicalCards, appointments, doctors,
                procedures, hospital);
    }

    public Patient withEmailAddress(String newEmailAddress) {
        return new Patient(id, firstName, lastName, dateOfBirth, address,
                phoneNumber, newEmailAddress, medicalCards, appointments, doctors,
                procedures, hospital);
    }

    public Patient withNewMedicalCards(List<MedicalCard> newMedicalCards) {
        return new Patient(id, firstName, lastName, dateOfBirth, address, phoneNumber, emailAddress,
                newMedicalCards, appointments, doctors, procedures, hospital);
    }

    public Patient withNewAppointment(List<Appointment> newAppointment) {
        return new Patient(id, firstName, lastName, dateOfBirth, address, phoneNumber, emailAddress,
                medicalCards, newAppointment, doctors, procedures, hospital);
    }

    public Patient withNewDoctor(List<Doctor> newDoctor) {
        return new Patient(id, firstName, lastName, dateOfBirth, address, phoneNumber, emailAddress,
                medicalCards, appointments, newDoctor, procedures, hospital);
    }

    public Patient withNewProcedure(List<Procedure> newProcedure) {
        return new Patient(id, firstName, lastName, dateOfBirth, address, phoneNumber, emailAddress,
                medicalCards, appointments, doctors, newProcedure, hospital);
    }

    public Patient withNewHospital(Hospital newHospital) {
        return new Patient(id, firstName, lastName, dateOfBirth, address, phoneNumber, emailAddress,
                medicalCards, appointments, doctors, procedures, newHospital);
    }


    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", medicalCards=" + medicalCards +
                ", appointments=" + appointments +
                ", doctors=" + doctors +
                ", procedures=" + procedures +
                ", hospital=" + hospital +
                '}';
    }
}






