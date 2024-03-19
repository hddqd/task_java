package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Hospital {
    public final String id;
    public final String hospitalName;
    public final String address;
    public final String telephoneNumber;
    public final String workingHours;

    @JsonCreator
    public Hospital(
            @JsonProperty("id") String id,
            @JsonProperty("hospitalName") String hospitalName,
            @JsonProperty("address") String address,
            @JsonProperty("telephoneNumber") String telephoneNumber,
            @JsonProperty("workingHours") String workingHours) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.workingHours = workingHours;
    }

    public Hospital withId(String newId) {
        return new Hospital(newId, hospitalName, address, telephoneNumber, workingHours);
    }

    public Hospital withHospitalName(String HospitalName) {
        return new Hospital(id, HospitalName, address, telephoneNumber, workingHours);
    }

    public Hospital withAddress(String address) {
        return new Hospital(id, hospitalName, address, telephoneNumber, workingHours);
    }

    public Hospital withTelephoneNumber(String telephoneNumber) {
        return new Hospital(id, hospitalName, address, telephoneNumber, workingHours);
    }

    public Hospital withWorkingHours(String workingHours) {
        return new Hospital(id, hospitalName, address, telephoneNumber, workingHours);
    }


    @Override
    public String toString() {
        return "Hospital{" +
                "id='" + id + '\'' +
                ", hospitalName=" + hospitalName +
                ", address=" + address +
                ", telephoneNumber=" + telephoneNumber +
                ", workingHours=" + workingHours +
                '}';
    }
}
