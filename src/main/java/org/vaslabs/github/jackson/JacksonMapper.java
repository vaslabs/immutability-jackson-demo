package org.vaslabs.github.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

public final class JacksonMapper {

    private JacksonMapper() { throw new AssertionError("No instances here");}

    public static ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new GuavaModule());
        objectMapper.registerModule(new ParameterNamesModule());
        return objectMapper;
    }
}
