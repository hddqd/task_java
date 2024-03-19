package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Doctor {
    public final String id;
    public final String firstName;
    public final String lastName;
    public final String specialization;

    @JsonCreator
    public Doctor(@JsonProperty("id") String id,
                  @JsonProperty("firstName") String firstName,
                  @JsonProperty("lastName") String lastName,
                  @JsonProperty("specialization") String specialization) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
    }

    public Doctor withId(String newId) {
        return new Doctor(newId, firstName, lastName, specialization);
    }

    public Doctor withFirstName(String firstName) {
        return new Doctor(id, firstName, lastName, specialization);
    }

    public Doctor withLastName(String lastName) {
        return new Doctor(id, firstName, lastName, specialization);
    }

    public Doctor withSpecialization(String specialization) {
        return new Doctor(id, firstName, lastName, specialization);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialization=" + specialization +
                '}';
    }
}
