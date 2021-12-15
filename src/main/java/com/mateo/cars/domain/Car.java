package com.mateo.cars.domain;

import java.util.Objects;

public class Car {
    /* Para validar el uso de mis modelos del dominio debere añadir clases validadoras por cada
    *  parametro sobre el cual desee realizar validaciones
    * */

    private String id;
    private CarBrand brand;
    private CarModel model;
    private int yearOfProduction;
    private String color;

    public Car() {
    }


    public Car(String id, CarBrand brand, CarModel model, int yearOfProduction, String color) {
        Objects.requireNonNull(brand, "Car brand name must not be an empty value");
        Objects.requireNonNull(model, "The car model name must not be an empty value");
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", color='" + color + '\'' +
                '}';
    }
}
