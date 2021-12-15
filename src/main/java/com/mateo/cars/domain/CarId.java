package com.mateo.cars.domain;

import java.util.Objects;
import java.util.UUID;

public class CarId {

    /*  Para la gestion de los IDs de nuestra entidad, usaremos un parametro de tipo UUID,
    *   el cual permite generar identificadores unicos de 128 bits (segun documentacion)
    *   para cada entidad Car que creemos.
    *
    *   El realizar este proceso directamente desde la entidad nos permitira tener mas control
    *   sobre el mismo, a diferencia que si delegaramos este proceso a la base de datos. Por ejemplo,
    *   con una columna y "autoincrement"
    *
    * */
    private final UUID value;

    public CarId(UUID value){
        Objects.requireNonNull(value, "The Car Id must not be null");
        this.value = value;
    }

    /* Definiremos un metodo estatico para retornar un UUID aleatorio que es generado con la clase*/
    public static CarId generateCarId(){
        return new CarId(UUID.randomUUID());
    }

    /* Tambien definiremos un metodo para retornar el UUID de un objeto como String*/

    public static CarId getUUID(String value){
        return new CarId(UUID.fromString(value));
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
