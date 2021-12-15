package com.mateo.cars.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class CarColor {

    /* Para esta propiedad validaremos:
    *   - Que la propiedad no sea vacia
    *   - Que esta no tenga masd e 50 caracteres
    *   - Que no use caracteres especiales
    *   - No puede contener caracteres numericos
    *   - Recortaremos el espacio en blanco sobrante
    * */
    private static final Pattern pattern = Pattern.compile("^[a-zA-Z]{0,100}$");

    private final String value;

    public CarColor(String value){
        Objects.requireNonNull(value, "The car model must not be null");

        String trimmedValue = value.trim();

        if(trimmedValue.length() == 0 || trimmedValue.length() > 50){
            throw new IllegalArgumentException("The car color name must have at least one character or less than 50");
        }

        Boolean isValid = pattern.matcher(trimmedValue).matches();

        if(!isValid){
            throw new IllegalArgumentException("The car color name must not have any especial character or number");
        }

        this.value = trimmedValue;
    }

    @Override
    public String toString() {
        return value;
    }
}
