package com.mateo.cars.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CarModelTest {

    @Test
    public void mustReturnNullPointerExceptionWhenTheValueIsNull(){

        //Arrange
        String value=null;

        //Act
        Executable executable = () -> new CarModel(value);

        //Assert
        assertThrows(NullPointerException.class, executable);
    }

    @Test
    public void mustReturnIllegalArgumentExceptionWhenValueIsEmpty(){
        //Arrange
        String value="";

        //Act
        Executable executable = () -> new CarModel(value);

        //Assert
        assertThrows(NullPointerException.class, executable);

    }
}