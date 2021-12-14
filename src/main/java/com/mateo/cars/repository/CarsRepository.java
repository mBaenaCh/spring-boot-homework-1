package com.mateo.cars.repository;

/* Con el uso de la interfaz buscamos definir la "forma" que tendran algunas de nuestras funcionalidades asociadas
   a nuestro repository.

   El repository se encargara de gestionar la interaccion con los datos que se van a persistir en alguna base de datos,
   esa interaccion se puede dar cuando creemos, editemos, eliminemos o cuando consultemos a esta misma.

    Definir una interfaz nos ayudara a no tener que limitar la funcionalidad de esa interaccion con una sola base de datos,
    sino generalizar las funcionalidades en distintos contextos

    TL;DR -> Interfaces establecen la plantilla para que una funcionalidad pueda ser desarrollado de muchas maneras para distintos contextos
*
* */

import com.mateo.cars.domain.Car;

import java.util.List;

public interface CarsRepository {

    /* Nos interesan las funcionalidades definidas en el controlador*/

    void createCar(Car car);

    List<Car> getAllCars();

    Car getCarById(String id);

    void updateCarById(String id, Car car);

    void deleteCarById(String id);

}
