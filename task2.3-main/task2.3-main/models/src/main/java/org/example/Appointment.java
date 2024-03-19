package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Appointment {

    public final String id;
    public final String medicineName;
    public final String description;

    @JsonCreator
    public Appointment(
            @JsonProperty("id") String id,
            @JsonProperty("medicineName") String medicineName,
            @JsonProperty("description") String description) {
        this.id = id;
        this.medicineName = medicineName;
        this.description = description;
    }

    public Appointment withId(String newId) {
        return new Appointment(newId, medicineName, description);
    }

    public Appointment withMedicineName(String medicineName) {
        return new Appointment(id, medicineName, description);
    }

    public Appointment withDescription(String description) {
        return new Appointment(id, medicineName, description);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + id + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
