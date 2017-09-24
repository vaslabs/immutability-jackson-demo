package org.vaslabs.github;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.vaslabs.github.json.JacksonMapper;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by vnicolaou on 01/09/17.
 */
public class TestDummyObject {

    ObjectMapper objectMapper = JacksonMapper.objectMapper();

    @Test
    public void testDummy() throws IOException {
        DummyObject dummyObject = ImmutableDummyObject.of("dummy", 10);
        String json = objectMapper.writeValueAsString(dummyObject);
        DummyObject recoveredDummyObject = objectMapper.readValue(json, DummyObject.class);
        assertEquals(dummyObject, recoveredDummyObject);

    }

    @Test
    public void callGithubService() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();

        GithubService service = retrofit.create(GithubService.class);
        System.out.println(service.listRepos("vaslabs").execute().body());
    }

    @Test
    public void testPrivateInterfacePattern() throws IOException {
        System.out.println(objectMapper.writeValueAsString(
                ImmutableFoo.of("my foo")));
        assertEquals(ImmutableFoo.of("my foo"),
                objectMapper.readValue(objectMapper.writeValueAsString(
                ImmutableFoo.of("my foo")), PrivateInterface.fooBar()));
    }

}
