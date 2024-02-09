package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laptop {

    @Id
    private String lId;

    private String model;

    public Laptop() {
    }

    public Laptop(String lId, String model) {
        this.lId = lId;
        this.model = model;
    }

    public String getlId() {
        return lId;
    }

    public void setlId(String lId) {
        this.lId = lId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lId='" + lId + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
