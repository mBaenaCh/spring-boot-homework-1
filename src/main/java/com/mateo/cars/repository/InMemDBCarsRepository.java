package com.mateo.cars.repository;

/* Para poder usar una interface en alguna de nuestras clases, esta ultima debe "implementarla"
*  y al hacer esto, todos los metodos de la interface deben ser definidos para su uso
* */

import com.mateo.cars.domain.Car;
import org.springframework.stereotype.Component;

import java.util.*;

//@Component
public class InMemDBCarsRepository {//implements CarsRepository{
    /*Definimos el uso de una estructura de datos "Map" que es similar a un Dict de Python (par clave-valor)
      solo que este cuenta con un campo de "id" y el "objeto" o "elemento" que corresponde a esa "id"
    * -> {"123" , new Car("123", "Alpina", "B3", 1994, "Alpina green metallic")}
    * -> {"456" , new Car("456", "Alpina", "B3", 1994, "Alpina green metallic")}
    * */
    //private final Map<String, Car> database = new HashMap<>();
/*
    @Override
    public void createCar(Car car) {
        /* Dado que nuestra base de datos es final, no podremos modificarla y vamos a validar que los datos ingresados no sea repetidos,
         * en funcion del elemento a ingresar
         */
       /* Car foundElement = database.get(car.getId());
        if(foundElement != null){
            throw new IllegalArgumentException("The element was already created");
        } else {
            database.put(car.getId(), car);
        }
    }

    @Override
    public List<Car> getAllCars() {
        Collection<Car> cars = database.values();
        return new ArrayList<>(cars);
    }
*/
  //  @Override
    //public Car getCarById(String id) {
        /* Debemos verificar si el objeto a buscar siquiera se encuentra*/

 /*       Car foundElement = database.get(id);
        if(foundElement == null ){
            throw new IllegalArgumentException("The element with the id: "+ id +"was not found");
        } else {
            return database.get(id);
        }
    }*/

    /* Esta funcionalidad se puede refactorizar, es similar a createCar
       y se podria tener en cuenta que modificar en funcion de lo que se recibe como parametro

       UNA DUDA: Si la keyword "final" no permiten la modificacion, debido a su unica asignacion...
                 el metodo "update" si seria relevante?
     */
    //@Override
    //public void updateCarById(String id, Car car) {

        /* Nuevamente verificamos si el objeto a modificar se encuentra*/
      /*  Car foundElement = database.get(id);
        if(foundElement == null ){
            throw new IllegalArgumentException("The element with the id: "+ id +"was not found");
        } else {
            database.put(id, car);
        }
    }*/

    /*@Override
    public void deleteCarById(String id) {
        Car foundElement = database.get(id);
        if(foundElement == null){
            throw new IllegalArgumentException("The element with the id: "+ id +"was not found");
        } else {
            database.remove(id);
        }
    }*/
}
