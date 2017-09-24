package org.vaslabs.github;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

public class PrivateInterface {

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = ImmutableFoo.class, name = "Bar"),
            @JsonSubTypes.Type(value = ImmutableBar.class, name = "Foo") })
    private interface FooBar {}

    @JsonSerialize(as = ImmutableFoo.class)
    @JsonDeserialize(as = ImmutableFoo.class)
    @Value.Immutable
    abstract static class Foo implements FooBar {
        @Value.Parameter
        public abstract String information();
    }


    @JsonSerialize(as = ImmutableFoo.class)
    @JsonDeserialize(as = ImmutableFoo.class)
    abstract static class Bar implements FooBar {
        @Value.Parameter
        public abstract String information();

    }

    public static Class<FooBar> fooBar() {
        return FooBar.class;
    }

}
