package com.mateo.cars.model;

import com.mateo.cars.domain.Car;

public class CreateCarOutput {

    private Car car;

    public CreateCarOutput(){

    }

    public CreateCarOutput(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
