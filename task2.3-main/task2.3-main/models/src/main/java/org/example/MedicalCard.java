package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MedicalCard {
    public final String id;
    public final String creationDate;
    public final String diagnosis;
    public final String attendingDoctor;

    @JsonCreator
    public MedicalCard(
            @JsonProperty("id") String id,
            @JsonProperty("creationDate") String creationDate,
            @JsonProperty("diagnosis") String diagnosis,
            @JsonProperty("attendingDoctor") String attendingDoctor) {
        this.id = id;
        this.creationDate = creationDate;
        this.diagnosis = diagnosis;
        this.attendingDoctor = attendingDoctor;
    }

    public MedicalCard withId(String newId) {
        return new MedicalCard(newId, creationDate, diagnosis, attendingDoctor);
    }

    public MedicalCard withCreationDate(String creationDate) {
        return new MedicalCard(id, creationDate, diagnosis, attendingDoctor);
    }

    public MedicalCard withDiagnosis(String diagnosis) {
        return new MedicalCard(id, creationDate, diagnosis, attendingDoctor);
    }

    public MedicalCard withAttendingDoctor(String attendingDoctor) {
        return new MedicalCard(id, creationDate, diagnosis, attendingDoctor);
    }

    @Override
    public String toString() {
        return "MedicalCard{" +
                "id='" + id + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", attendingDoctor='" + attendingDoctor + '\'' +
                '}';
    }
}
