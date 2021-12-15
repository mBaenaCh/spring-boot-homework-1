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
        assertThrows(IllegalArgumentException.class, executable);

    }

    @Test
    public void mustReturnIllegalArgumentExceptionWhenValueCharsAreGreaterThan80(){
        //Arrange
        String value = "Nam quis nulla. Integer malesuada. In in enim a arcu imperdiet malesuada. Sed vel";

        //Act
        Executable executable = () -> new CarModel(value);

        //Assert
        assertThrows(IllegalArgumentException.class, executable);

    }

    @Test
    public void mustReturnIllegalArgumentExceptionWhenValueDoesntComplyTheRegex(){
        //Arrange
        String value = "Nam quis nulla. Integer malesuada. In 4#";

        //Act
        Executable executable = () -> new CarModel(value);

        //Assert
        assertThrows(IllegalArgumentException.class, executable);
    }
}