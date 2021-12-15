package com.mateo.cars.repository;

import com.mateo.cars.domain.Car;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcCarsRepository implements CarsRepository{

    /*  Instanciamos un objeto del tipo JdbcTemplate que sera usado para la gestion
        de la conexion a la base de datos.

        La implementacion de cada metodo sera de mayor nivel, por lo que reduciremos
        complejidad y no tendremos que pensar en aspectos como la conexion o cierre de
        una interaccion con la base de datos (bd).
    */
    private final JdbcTemplate jdbcTemplate;

    public JdbcCarsRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Definicion del RowMapper basado en el objeto de mi modelo del dominio
    *
    *  Buscara mapear lo encontrado en una consulta a un objeto de mi modelo
    *
    *  Basa su funcionalidad en la aplicacion de una funcion lambda que nos ahorra
    *  el tener que recorrer una lista de resultados bajo un ciclo con una condicion
    *
    *  PENDIENTE: Crear un CarMapper que implemente de RowMapper<Car>
    * */
    private final RowMapper<Car> rowMapper = (resultSet, rowNum) -> {
        String id = resultSet.getString("car_id");
        String brand = resultSet.getString("brand");
        String model = resultSet.getString("model");
        int yearOfProduction = resultSet.getInt("year_of_production");
        String color = resultSet.getString("color");
        return new Car(
                id,
                brand,
                model,
                yearOfProduction,
                color
        );
    };


    //De igual modo sera necesario instanciar los queries para cada consulta que deseemos hacer
    @Override
    public void createCar(Car car) {
        String query="INSERT INTO cars_mateobch VALUES(?, ?, ?, ?, ?)";
        /*Puedo crear un elemento en la tabla al mapear, como parametros de la consulta, las propiedades que puede retornar mi objeto
        *
        * PENDIENTE: update vs query (uso de rowmapper)*/
        jdbcTemplate.update(query, car.getId(), car.getBrand(), car.getModel(), car.getYearOfProduction(), car.getColor());
    }

    @Override
    public List<Car> getAllCars() {
        String query = "SELECT * FROM cars_mateobch";
        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public Car getCarById(String id) {
        String query = "SELECT * FROM cars_mateobch WHERE car_id = ?";
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }

    @Override
    public void updateCarById(String id, Car car) {
        String query = "UPDATE cars_mateobch SET car_id = ?, brand = ?, model = ?, year_of_production = ?, color = ? WHERE car_id = ?";
        jdbcTemplate.update(query, id, car.getBrand(), car.getModel(), car.getYearOfProduction(), car.getColor(), id);
    }

    @Override
    public void deleteCarById(String id) {
        String query = "DELETE FROM cars_mateobch WHERE car_id = ?";
        jdbcTemplate.update(query, id);
    }
}
