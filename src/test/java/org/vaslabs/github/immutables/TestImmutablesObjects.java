package org.vaslabs.github.immutables;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.vaslabs.github.GithubService;
import org.vaslabs.github.jackson.NonIntrusiveJacksonMapper;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by vnicolaou on 01/09/17.
 */
public class TestImmutablesObjects {

    ObjectMapper objectMapper = NonIntrusiveJacksonMapper.objectMapper();

    @Test
    public void testDummy() throws IOException {
        DummyObject dummyObject = DummyObject.of("dummy", 10);
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
        PrivateInterface.PolymorphicContainer polymorphicContainer
                = new PrivateInterface.PolymorphicContainer(Foo.of("my foo"));
        assertEquals(polymorphicContainer,
                objectMapper.readValue(objectMapper.writeValueAsString(
                polymorphicContainer), PrivateInterface.PolymorphicContainer.class));

        polymorphicContainer
                = new PrivateInterface.PolymorphicContainer(Bar.of("my bar"));
        assertEquals(
                polymorphicContainer,
                objectMapper.readValue(
                        objectMapper.writeValueAsString(polymorphicContainer),
                        PrivateInterface.PolymorphicContainer.class
                )
        );

    }

}
