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
//@Component
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
            ps.executeQuery().close(); //Tengo pendiente revisar porque esta linea arroja un error, parece estar asociado al uso del Close
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM cars_mateobch";


        try (
                /* Instanciamos una nueva conexion a la base de datos en funcion del datasource
                *
                *  Instanciamos un nuevo objeto Statement en funcion de la conexion realizada
                *  dado que con este ejecutaremos el query que nos retornara una consulta a la bd
                * */
                Connection connection = dataSource.getConnection();
                Statement est = connection.createStatement();
                ResultSet rs = est.executeQuery(query); //Almacena el resultado de la consulta realizada
                ){
            /* Deberemos iterar atraves del resultado de la consulta para retornar y mapear cada elemento
               a un objeto de nuestro modelo.

               Finalmente, solo añadimos el objeto mapeado a la lista que debemos retornar
            * */
            while(rs.next()){
                String id = rs.getString("car_id");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int yearOfProduction = rs.getInt("year_of_production");
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

        /* En este caso solo debemos mapear un objeto basado en lo que nos retorne una consulta
        *
        *  La consulta debera recibir como parametro el "id" del objeto que queremos retornar,
        *  por tanto, vamos a usar un PreparedStatement para evitar la SQL-Injection a la que nos
        *  expone un Statement al concatenarle parametros que queramos usar*/
        String query = "SELECT * FROM cars_mateobch WHERE car_id = ?";
        Car car = new Car();
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
                ){
            // Asignamos al primer parametro de la consulta el valor del parametro recibido en el metodo
            ps.setString(1, id);
            /* En base a la ejecucion del query, guardaremos el resultado de esta consulta para mapear
               un objeto en funcion de nuestro modelo*/
            ResultSet rs = ps.executeQuery();

            // Validamos si se encontro un elemento
            if(!rs.next()){
                throw new SQLException("The element was not found");
            }else{
                //Mapeamos nuestro objeto de retorno en funcion del elemento obtenido
                car.setId(rs.getString("car_id"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setYearOfProduction(rs.getInt("year_of_production"));
                car.setColor(rs.getString("color"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public void updateCarById(String id, Car car) {
        /* Solo debemos actualizar nuestro elemento en funcion de los datos del objeto que son enviados por el body
        *
        *  Dada la logica de nuestro modelo, creo que es necesario enviar en el body todos los parametros, quizas se podria crear un constructor con menos datos?
        *
        *  Hay que tener cuidado con el uso de camel-case en el nombramiento de columnas, se cambia por snake-case
        * */
        String query = "UPDATE cars_mateobch SET car_id = ?, brand = ?, model = ?, year_of_production = ?, color = ? WHERE car_id = ?";
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
                ){
            ps.setString(1, car.getId());
            ps.setString(2, car.getBrand());
            ps.setString(3, car.getModel());
            ps.setInt(4, car.getYearOfProduction());
            ps.setString(5, car.getColor());
            ps.setString(6, id);
            ps.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCarById(String id) {
        /* Realmente solo cambia la query a usar, la implementacion es similar al update y nuevamente se usa un PreparedStatement
        *  para evitar una vulneracion por SQL Injection al concatenar variables al String de Query*/

        String query = "DELETE FROM cars_mateobch WHERE car_id = ?";
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
                ){
            ps.setString(1, id);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
