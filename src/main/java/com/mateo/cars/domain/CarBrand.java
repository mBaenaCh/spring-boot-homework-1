package com.mateo.cars.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class CarBrand {

    /* Para esta propiedad se validara:
    *       - Valor ingresado debe ser un String
    *       - No se pueden ingresar un valor vacio
    *       - El valor no puede contener valores numericos
    *       - El valor no puede contener caracteres especiales
    *       - No se deben tener mas de 80 caracteres
    *       - Se recortaran los espacios vacios ingresados
    * */

    private static final Pattern pattern = Pattern.compile("^[a-zA-Z]{0,80}$");

    private final String value;

    public CarBrand(String value) {

        //Validamos el retorno de una excepcion en caso de recibir un valor vacio
        Objects.requireNonNull(value, "The car brand name can not be null");

        //Eliminamos espacios en blanco
        String trimmedValue = value.trim();

        //Validamos que el valor recibido se encuentre dentro de un rango especificado
        if(trimmedValue.length() == 0 || trimmedValue.length() > 80){
            throw new IllegalArgumentException("The given car brand name cannot be empty or have more than 100 characters");
        }
        //Validamos que el valor cumpla las condiciones de la expresion regular
        Boolean isValid = pattern.matcher(trimmedValue).matches();
        if(!isValid){
            throw new IllegalArgumentException("The given car brand name cannot have any special characters or numbers in it");
        }

        this.value = trimmedValue;
    }

    @Override
    public String toString() {
        return value;
    }

}
