package com.mateo.cars.configuration.jackson.codecs;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mateo.cars.domain.CarId;

import java.io.IOException;

public class CarIdParser {


    /*Serializar implica tomar lo generado en Java y llevarlo a formato JSON*/
    public static class Serializer extends JsonSerializer<CarId>{
        @Override
        public void serialize(CarId value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    /*Deserializar es el proceso contrario, a partir de un JSON queremos
    * mapear valores en tipos de Java*/
    public static class Deserializer extends JsonDeserializer<CarId>{

        @Override
        public CarId deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return CarId.getUUID(p.getValueAsString());
        }
    }

}
