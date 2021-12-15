package com.mateo.cars.configuration;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/* Definimos esta clase como un Bean de configuracion de la conexion a la base de datos
*
* */
@Configuration
public class DatabaseConnectionConfiguration {
    /* Cada funcionalidad definida dentro de la configuracion debera ser otro Bean,
       de tal manera que respetemos nuestro arbol de

       En Java, es necesario el uso de DatSource's para la comunicacion con una base de datos

       Este datasource permitira establecer y administrar los pools de conexiones que hagamos
       a la base de datos, de tal manera de que esta sea lo mas eficiente posible, debido a que
       esta tarea genera un alto consumo de recursos compútacionales.

       Para este caso, usaremos un datasource basado en HikariCP (El cual cargamos como dependencia
       en nuestro build.gradle)
    * */
    @Bean
    public DataSource dataSource (){
        /* Posteriormente solo nos queda configurar el datasource en base al de Hikari*/
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("postgres");

        return new HikariDataSource(config);
    }

    /* Este bean de configuracion nos permitira usar el datasource para simplificar la definicion
     *  de las funcionalidades que hara nuestro repository.

       Con el uso del JDBC Template de spring no nos tendremos que preocupar por las operaciones de
       bajo nivel que resultan de la interaccion (conexion) con la base de datos
     */

    @Bean
    public JdbcTemplate jdbcTemplate( DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
