package com.mateo.cars.service;

import com.mateo.cars.domain.Car;
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

    public void createCar(Car car){
        this.repository.createCar(car);
    }

    public List<Car> carList(){
        return repository.getAllCars();
    }

    public Car getCarById(String id){
        return repository.getCarById(id);
    }

    public void updateCarById(String id, Car car){
        repository.updateCarById(id, car);
    }

    public void deleteCarById(String id){
        repository.deleteCarById(id);
    }

}
