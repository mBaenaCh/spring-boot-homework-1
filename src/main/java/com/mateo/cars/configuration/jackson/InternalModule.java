package com.mateo.cars.configuration.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mateo.cars.configuration.jackson.codecs.CarBrandParser;
import com.mateo.cars.configuration.jackson.codecs.CarColorParser;
import com.mateo.cars.configuration.jackson.codecs.CarIdParser;
import com.mateo.cars.configuration.jackson.codecs.CarModelParser;
import com.mateo.cars.domain.CarBrand;
import com.mateo.cars.domain.CarColor;
import com.mateo.cars.domain.CarId;
import com.mateo.cars.domain.CarModel;

public class InternalModule extends SimpleModule {
    private static final String NAME = "InternalModule";

    public InternalModule(){
        /* Llamamos el metodo contructor de la clase padre "SimpleModule"*/
        super(NAME, Version.unknownVersion());

        /* Solo nos queda añadir los serializadores y deserializadores que
        *  creamos para cada clase de validacion  de tal modo que puedan ser
        *  activados cuando se encuentre algun tipo de dato, en el JSON,
        *  correspondiete a esas clases*/

        addSerializer(CarId.class, new CarIdParser.Serializer());
        addDeserializer(CarId.class, new CarIdParser.Deserializer());

        addSerializer(CarModel.class, new CarModelParser.Serialize());
        addDeserializer(CarModel.class, new CarModelParser.Deserialize());

        addSerializer(CarBrand.class, new CarBrandParser.Serializer());
        addDeserializer(CarBrand.class, new CarBrandParser.Deserializer());

        addSerializer(CarColor.class, new CarColorParser.Serializer());
        addDeserializer(CarColor.class, new CarColorParser.Deserializer());

    }
}