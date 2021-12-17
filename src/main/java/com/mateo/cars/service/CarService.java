package com.mateo.cars.service;

import com.mateo.cars.domain.Car;
import com.mateo.cars.domain.CarId;
import com.mateo.cars.repository.CarsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/* La capa de servicio es aquella dedicada a manejar la logica del negocio
*  de tal modo que podamos gestionar las transacciones necesarias para el
*  repository*/

@Service
public class CarService {

    private CarsRepository repository;

    public CarService(CarsRepository repository){
        this.repository = repository;
    }

    public Car createCar(Car car){

        this.repository.createCar(car);

    return car;
    }

    public List<Car> getAllCars(){
        return repository.getAllCars();
    }

    public Car getCarById(CarId id){
        return repository.getCarById(id);
    }

    public void updateCarById(CarId id, Car car){
        repository.updateCarById(id, car);
    }

    public void deleteCarById(CarId id){
        repository.deleteCarById(id);
    }

}
