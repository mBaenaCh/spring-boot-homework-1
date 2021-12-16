package com.mateo.cars.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CarColorTest {

    @Test
    public void shouldReturnNullPointerExceptionWhenTheValueIsNull(){
        //Arrange
        String value = null;
        //Act
        Executable executable = () -> new CarColor(value);

        //Assert
        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenTheValueIsEmpty(){
        //Arrange
        String value = "";

        //Act
        Executable executable = () -> new CarColor(value);

        //Assert
        assertThrows(IllegalArgumentException.class, executable);

    }

    




}