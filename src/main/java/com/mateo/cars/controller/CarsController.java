package com.mateo.cars.controller;

import com.mateo.cars.domain.Car;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Con nuestro controller definiremos las funcionalidades que actuaran sobre nuestor modelo del dominio
*
*  Dado que nuestro sistema es una API REST, vamos a exponer estas funcionalidades por medio de rutas y
*  metodos HTTP
*
*  Con Springboot, usaremos la depedencia "RestController" para dotar de esas funcionalidades a nuestra clase*/

@RestController
@RequestMapping(value="/cars") //Nos permitira modelar toda la funcionalidad alrededor de una misma ruta
public class CarsController {
    

    @GetMapping
    public List<Car> getCars(){
        //return List.of();
        return null;
    }

    @GetMapping(value = "/{id}")
    //La dependencia PathVariable nos permite manejar los parametros que son enviados junto a nuestra ruta
    public Car getCarById(@PathVariable String id){
        return new Car();
    }

    @PutMapping
    /*La dependencia de RequestBody nos permite recibir un JSON que sera convertido al formato especificado
      en el parametro de entrada*/
    public Car createCar(@RequestBody Car car){
        return car;
    }

    @PostMapping(value="/{id}")
    public Car updateCarById(@PathVariable String id, @RequestBody Car car){
        return car;
    }

    @DeleteMapping(value="/{id}")
    public void deleteCarById(@PathVariable String id){
        
    }

}
