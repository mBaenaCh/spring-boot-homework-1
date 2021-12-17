package com.mateo.cars.configuration.jackson.codecs;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mateo.cars.domain.CarColor;

import java.io.IOException;

public class CarColorParser {
    public static class Serializer extends JsonSerializer<CarColor>{

        @Override
        public void serialize(CarColor value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    public static class Deserializer extends JsonDeserializer<CarColor>{

        @Override
        public CarColor deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return new CarColor(p.getValueAsString());
        }
    }
}
