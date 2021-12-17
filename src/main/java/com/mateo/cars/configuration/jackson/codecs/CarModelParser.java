package com.mateo.cars.configuration.jackson.codecs;

/* El objetivo de los codecs es el de generar metodos que puedan serializar
   o deserializar aquello que sera enviado o recibido a traves de JSON

   Manipulando y usando Jackson logramos nuestro cometido, debido a que gracias a esto
   generaremos un JSON mas limpio

   De esto:
   {
        car_id: {
            value: "some id"
        }

   }

   Pasamos a esto:
   {
        car_id: "some id"
   }
*
* }*/

public class CarModelParser {
}
