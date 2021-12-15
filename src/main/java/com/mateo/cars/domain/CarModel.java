package com.mateo.cars.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class CarModel {

    /* Para esta propiedad validaremos:
    *   - No puede ser vacio
    *   - No puede tener mas de 100 caracteres
    *   - No puede tener caracteres especiales
    *   - Se recortaran los espacios en blanco ingresados en el valor
    * */

    private static final Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{0,100}$");

    private final String value;

    public CarModel(String value){
        Objects.requireNonNull(value, "The car model name must not be null");

        String trimmedValue = value.trim();

        if(trimmedValue.length() == 0 || trimmedValue.length() > 80){
            throw new IllegalArgumentException("The car model name must not be empty or have more than 80 characters");
        }

        Boolean isValid = pattern.matcher(trimmedValue).matches();

        if(!isValid){
            throw new IllegalArgumentException("The car model name must not have any especial characters");
        }

        this.value = trimmedValue;
    }
    //Notese la forma anidada en como se retorna el valor debido a que este parametro es validado por medio de un objeto
    @Override
    public String toString() {
        return value;
    }
}
