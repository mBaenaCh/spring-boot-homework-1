package com.mateo.cars.configuration.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*Nuevamente definimos un Bean de configuracion*/
@Configuration
public class JacksonConfiguration {

/* Luego a cada metodo a definir lo definimos como @Bean*/

    @Bean
    ObjectMapper objectMapper(){
        return JsonMapper.builder()
                .configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .addModule(new InternalModule())
                .build();
    }
}
