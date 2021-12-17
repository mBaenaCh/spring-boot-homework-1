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

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mateo.cars.domain.CarModel;

import java.io.IOException;

public class CarModelParser {

    public static class Serialize extends JsonSerializer<CarModel>{

        @Override
        public void serialize(CarModel value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    public static class Deserialize extends JsonDeserializer<CarModel>{

        @Override
        public CarModel deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return new CarModel(p.getValueAsString());
        }
    }

}
