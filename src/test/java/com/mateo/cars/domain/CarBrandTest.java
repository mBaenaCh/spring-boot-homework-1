package com.mateo.cars.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CarBrandTest {


    /* Como casos de prueba tenemos el probar las validaciones que retorna
    *  el constructor de nuestra clase de validacion para el parametro Brand
    *
    *  El primer caso es que se retorne un NullPointerException debido a que
    *  el valor de "value" enviado es nulo*/
    @Test
    public void shouldReturnNullPointerException(){
        /*Arrange: Donde inicializamos lo necesario para correr la prueba*/
            String value = null;

        /*Act: Donde definimos la funcionalidad que sera probada.
        *
        *      En este caso, solo instanciaremos el objeto de una clase
        *      esto lo haremos por medio de la clase Execute y la ejecucion
        *      de una funcion lambda que instancia un nuevo objeto que recibe
        *      la variable definida en nuestra seccion "Arrange"*/
            Executable executable = () -> new CarBrand(value);

        //Assert
            assertThrows(NullPointerException.class, executable);
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenTheValueIsEmpty(){
        //Arrange
            String value = "";
        //Act
            Executable executable = () -> new CarBrand(value);

        //Assert
            assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenTheValueIsGreaterThan100(){
        //Arrange
            String value="Nam quis nulla. Integer malesuada. In in enim a arcu imperdiet malesuada. Sed vel lectus. Donec odio ";

        //Act
            Executable executable = () -> new CarBrand(value);

        //Assert
            assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenTheValueDoesntComplyTheRegexBecauseOfSpecialChars(){
        //Arrange
        String value="Nam quis nulla. Integer malesuada. $";

        //Act
        Executable executable = () -> new CarBrand(value);

        //Assert
        assertThrows(IllegalArgumentException.class, executable);

    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenTheValueDoesntComplyTheRegexBecauseOfNumberChars(){
        //Arrange
        String value="Nam quis nulla.1 Integer malesuada. 1";

        //Act
        Executable executable = () -> new CarBrand(value);

        //Assert
        assertThrows(IllegalArgumentException.class, executable);

    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenTheValueDoesntComplyTheRegexBecauseOfExtraChars(){
        //Arrange
        String value="Nam quis nulla. Integer malesuada. In in enim a arcu imperdiet malesuada. Sed vel lectus. Donec odio ";

        //Act
        Executable executable = () -> new CarBrand(value);

        //Assert
        assertThrows(IllegalArgumentException.class, executable);

    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenTheValueDoesntComplyTheRegexByAnyMeans(){
        //Arrange
        String value="Nam quis nulla. Integer malesuada. In  $ @ 1231";

        //Act
        Executable executable = () -> new CarBrand(value);

        //Assert
        assertThrows(IllegalArgumentException.class, executable);
    }


}