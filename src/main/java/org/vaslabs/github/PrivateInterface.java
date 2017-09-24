package org.vaslabs.github;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.immutables.value.Value;

public class PrivateInterface {

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Foo.class, name = "Bar"),
            @JsonSubTypes.Type(value = Bar.class, name = "Foo") })
    private interface FooBar {}

    @JsonStyle
    @Value.Immutable
    abstract static class AbstractFoo implements FooBar {
        @Value.Parameter
        public abstract String information();
    }


    @JsonStyle
    @Value.Immutable
    abstract static class AbstractBar implements FooBar {
        @Value.Parameter
        public abstract String information();

    }

    public static Class<FooBar> fooBar() {
        return FooBar.class;
    }

}
