package com.mateo.cars.model;
import java.time.LocalDate;

public class UpdateCarByIdInput {
    private String brand;
    private String model;
    private LocalDate dateOfProduction;
    private String color;

    public UpdateCarByIdInput() {
    }

    public UpdateCarByIdInput(String brand, String model, LocalDate dateOfProduction, String color) {
        this.brand = brand;
        this.model = model;
        this.dateOfProduction = dateOfProduction;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(LocalDate dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
