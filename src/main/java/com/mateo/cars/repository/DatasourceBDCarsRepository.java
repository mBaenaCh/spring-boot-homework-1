package com.mateo.cars.repository;

import com.mateo.cars.domain.Car;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
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
                PreparedStatement ps = connection.prepareStatement(query);
            ){
            /*  En esta seccion nos queda insertar el objeto a la base de datos con el retorno del valor
            *   de sus propiedades y asignacion a cada parametro esperado en la consulta (?)
            */
            ps.setString(1, car.getId());
            ps.setString(2, car.getBrand());
            ps.setString(3, car.getModel());
            ps.setInt(4, car.getYearOfProduction());
            ps.setString(5, car.getColor());

            /* Finalmente solo queda ejectura el query deseado, posteriormente cerramos la conexion
            *  dado que es lo que recomienda la documentacion del "PreparedStatement de JDBC de PostgreSQL*/
            ps.executeQuery().close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM cars_mateobch";

        try (
                Connection connection = dataSource.getConnection();
                Statement est = connection.createStatement();
                ResultSet rs = est.executeQuery(query);
                ){
            while(rs.next()){
                String id = rs.getString("car_id");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int yearOfProduction = rs.getInt("yearOfProduction");
                String color = rs.getString("color");
                Car car = new Car(id, brand, model, yearOfProduction, color);
                cars.add(car);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cars;
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
