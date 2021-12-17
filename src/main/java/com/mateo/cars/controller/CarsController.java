package com.mateo.cars.controller;

import com.mateo.cars.domain.*;
import com.mateo.cars.model.CreateCarInput;
import com.mateo.cars.model.CreateCarOutput;
import com.mateo.cars.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/* Con nuestro controller definiremos las funcionalidades que actuaran sobre nuestro modelo del dominio
*
*  Dado que nuestro sistema es una API REST, vamos a exponer estas funcionalidades por medio de rutas y
*  metodos HTTP
*
*  Con Springboot, usaremos la anotaciona "RestController" para dotar de esas funcionalidades a nuestra clase*/
@RestController

/* Esta anotacion nos permitira modelar toda la funcionalidad alrededor de una misma ruta pero bajo distintos
   metodos HTTP */
@RequestMapping(value="/cars")
public class CarsController {

    /*
    * Controller -> Alto nivel -> Abstraccion generalizada alrededor de varias funcionalidades
    *
    * Repository -> Bajo nivel -> Abstraccion mas especifica que define como se hara cada
    *                             funcionalidad necesaria
    *
    * Con el principio de inversion de dependencia buscamos que este primer modulo no dependa del segundo (Reducimos acoplamiento)
    * */

    private CarService carService; //Instanciacion que nos permitira usar los metodos de la interfaz

    public CarsController(CarService carsService) {
        this.carService= carsService;
    }

    @PostMapping
    /*La anotacion RequestBody nos permite recibir un JSON que sera convertido al formato especificado
      en el parametro de entrada*/
    public CreateCarOutput createCar(
            @RequestBody CreateCarInput input){
        /* Posteriormente solo nos queda procesar los datos recibidos en el input hacia
        *  la tipologia de datos que se espera en el modelo del dominio */
        CarId id = CarId.generateCarId();
        CarBrand carBrand = new CarBrand(input.getBrand());
        CarModel carModel = new CarModel(input.getModel());
        LocalDate dateOfProduction = input.getDateOfProduction();
        CarColor carColor = new CarColor(input.getColor());

        /* Creamos una instancia basada en el modelo del dominio para su gestion en las capas subyacentes*/
        Car car = new Car(id, carBrand, carModel, dateOfProduction, carColor);
        Car createdCar = carService.createCar(car);

        return new CreateCarOutput(createdCar);
    }

    @GetMapping
    public List<Car> getCars(){
        return carService.getAllCars();
    }

    @GetMapping(value = "/{id}")
    //La anotacion PathVariable nos permite manejar los parametros que son enviados junto a nuestra ruta
    public Car getCarById(
            @PathVariable String id){

        CarId carId = CarId.getUUID(id);
        return carService.getCarById(carId);
    }

    @PutMapping(value="/{id}")
    /* Podremos combinar el uso de distintas anotaciones en los parametros de nuestros metodos*/
    public void updateCarById(
            @PathVariable String id,
            @RequestBody CreateCarInput car){

        CarId carId = CarId.getUUID(id);
        CarBrand carBrand = new CarBrand(car.getBrand());
        CarModel carModel = new CarModel(car.getModel());
        LocalDate dateOfProduction = car.getDateOfProduction();
        CarColor carColor = new CarColor(car.getColor());
        Car updatedCar = new Car(carId, carBrand, carModel, dateOfProduction, carColor);

        carService.updateCarById(carId, updatedCar);
    }

    @DeleteMapping(value="/{id}")
    public void deleteCarById(
            @PathVariable String id){
        carsRepository.deleteCarById(id);
    }

}