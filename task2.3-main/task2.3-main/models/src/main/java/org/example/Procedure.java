package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Procedure {

    public final String id;
    public final String procedureName;
    public final String price;
    public final String duration;

    @JsonCreator
    public Procedure(@JsonProperty("id") String id,
                     @JsonProperty("procedureName") String procedureName,
                     @JsonProperty("price") String price,
                     @JsonProperty("duration") String duration) {
        this.id = id;
        this.procedureName = procedureName;
        this.price = price;
        this.duration = duration;
    }

    public Procedure withId(String newId) {
        return new Procedure(newId, procedureName, price, duration);
    }

    public Procedure withProcedureName(String procedureName) {
        return new Procedure(id, procedureName, price, duration);
    }

    public Procedure withPrice(String price) {
        return new Procedure(id, procedureName, price, duration);
    }

    public Procedure withDuration(String duration) {
        return new Procedure(id, procedureName, price, duration);
    }


    @Override
    public String toString() {
        return "Procedure{" +
                "id='" + id + '\'' +
                ", procedureName='" + procedureName + '\'' +
                ", price='" + price + '\'' +
                ", duration=" + duration +
                '}';
    }

}
