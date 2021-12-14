package com.mateo.cars.controller;

import com.mateo.cars.domain.Car;
import com.mateo.cars.repository.CarsRepository;
import org.springframework.web.bind.annotation.*;

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

    private CarsRepository carsRepository; //Instanciacion que nos permitira usar los metodos de la interfaz

    public CarsController(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @PutMapping
    /*La anotacion RequestBody nos permite recibir un JSON que sera convertido al formato especificado
      en el parametro de entrada*/
    public void createCar(
            @RequestBody Car car){
        carsRepository.createCar(car);
    }

    @GetMapping
    public List<Car> getCars(){
        return carsRepository.getAllCars();
    }

    @GetMapping(value = "/{id}")
    //La anotacion PathVariable nos permite manejar los parametros que son enviados junto a nuestra ruta
    public Car getCarById(
            @PathVariable String id){
        return carsRepository.getCarById(id);
    }

    @PostMapping(value="/{id}")
    /* Podremos combinar el uso de distintas anotaciones en los parametros de nuestros metodos*/
    public void updateCarById(
            @PathVariable String id,
            @RequestBody Car car){
        carsRepository.updateCarById(id, car);
    }

    @DeleteMapping(value="/{id}")
    public void deleteCarById(
            @PathVariable String id){
        carsRepository.deleteCarById(id);
    }

}