package com.mateo.cars.model;

import com.mateo.cars.domain.Car;

public class UpdateCarByIdOutput {

    private Car car;

    public UpdateCarByIdOutput() {
    }

    public UpdateCarByIdOutput(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
