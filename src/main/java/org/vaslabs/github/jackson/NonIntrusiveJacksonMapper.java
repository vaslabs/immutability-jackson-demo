package org.vaslabs.github.jackson;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.vaslabs.github.independent.*;

/**
 * Created by vnicolaou on 01/09/17.
 */
public final class NonIntrusiveJacksonMapper {


    private NonIntrusiveJacksonMapper(){ throw new AssertionError("No instance here");}


    public static ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.registerModule(new ParameterNamesModule());
        objectMapper.addMixIn(PrivateInterface.fooBar(), PrivateInterfaceMixin.class);
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
        objectMapper.addMixIn(DummyObject.class, DummyObjectMixin.class);
        objectMapper.addMixIn(Repo.class, RepoMixin.class);
        objectMapper.addMixIn(Foo.class, FooMixin.class);
        objectMapper.addMixIn(Bar.class, BarMixin.class);
        return objectMapper;
    }


    @JsonAutoDetect
    @JsonDeserialize(as = DummyObject.class)
    @JsonSerialize(as = DummyObject.class)
    public abstract static class DummyObjectMixin {
        @JsonProperty("size") abstract int size();
        @JsonProperty("name") abstract String name();
        @JsonCreator
        public DummyObjectMixin(String name, int size) {}
    }

    @JsonDeserialize(as = Foo.class)
    @JsonSerialize(as = Foo.class)
    public abstract static class FooMixin {
        @JsonProperty("information") public abstract String information();
    }

    @JsonDeserialize(as = Bar.class)
    @JsonSerialize(as = Bar.class)
    public abstract static class BarMixin {
        @JsonProperty("information") public abstract String information();
    }

    @JsonDeserialize(as = Repo.class)
    @JsonSerialize(as = Repo.class)
    public abstract static class RepoMixin {
        @JsonProperty("full_name") public abstract String fullName();
    }


    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Foo.class, name = "Bar"),
            @JsonSubTypes.Type(value = Bar.class, name = "Foo") })
    public static class PrivateInterfaceMixin {
    }
}