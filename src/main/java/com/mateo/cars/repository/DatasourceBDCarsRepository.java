package com.mateo.cars.repository;

import com.mateo.cars.domain.Car;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


/*  Nuevamente definimos el repositorio con la anotacion de Componente
    dado que es Bean de la interface que implementa
* */
@Component
public class DatasourceBDCarsRepository implements CarsRepository{

    /*  Instanciamos un objeto del tipo datasource que sera usado para la gestion
        de la conexion a la base de datos

        Este DataSource hace referencia al Bean que tambien fue creado en nuestro Bean
        de la configuracion de la base de datos
    */
    private final DataSource dataSource;

    public DatasourceBDCarsRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void createCar(Car car) {
        /*Definimos el query que deseamos realizar sobre la base de datos (bd)
        *
        * En este caso sera insertar un registro a la bd
        *
        * Para realizar esto, el datasource debe realizar una conexion a la base de dator
        * */
        String query="INSERT INTO cars_mateobch VALUES(?, ?, ?, ?, ?)";
        try(
                //Para realizar la consulta, el datasource debe realizar una conexion a la base de datos
                Connection connection = dataSource.getConnection();

                //Y con la conexion realizada se ejecuta el query que deseamos
                PreparedStatement preparedStatement = connection.prepareStatement(query);
            ){
            /*  En esta seccion nos queda insertar el objeto a la base de datos con el retorno del valor
            *   de sus propiedades y asignacion a cada parametro esperado en la consulta (?)
            */
            preparedStatement.setString(1, car.getId());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.setInt(4, car.getYearOfProduction());
            preparedStatement.setString(5, car.getColor());

            /* Finalmente solo queda ejectura el query deseado, posteriormente cerramos la conexion
            *  dado que es lo que recomienda la documentacion del "PreparedStatement de JDBC de PostgreSQL*/
            preparedStatement.executeQuery().close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> getAllCars() {
        return null;
    }

    @Override
    public Car getCarById(String id) {
        return null;
    }

    @Override
    public void updateCarById(String id, Car car) {

    }

    @Override
    public void deleteCarById(String id) {

    }
}
