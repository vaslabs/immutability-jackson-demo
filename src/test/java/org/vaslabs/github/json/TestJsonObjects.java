package org.vaslabs.github.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.vaslabs.github.jackson.JacksonMapper;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestJsonObjects {

    ObjectMapper objectMapper = JacksonMapper.objectMapper();

    @Test
    public void testDummy() throws IOException {
        DummyObject dummyObject = new DummyObject("dummy", 10, ImmutableList.of());
        String json = objectMapper.writeValueAsString(dummyObject);
        DummyObject recoveredDummyObject = objectMapper.readValue(json, DummyObject.class);
        assertEquals(dummyObject, recoveredDummyObject);
    }
}
