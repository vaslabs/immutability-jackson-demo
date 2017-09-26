package org.vaslabs.github.immutables;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.EqualsAndHashCode;
import org.immutables.value.Value;

public class PrivateInterface {


    private interface FooBar {}

    @FluentStyle
    @Value.Immutable
    abstract static class AbstractFoo implements FooBar {
        @Value.Parameter
        public abstract String information();
    }


    @FluentStyle
    @Value.Immutable
    abstract static class AbstractBar implements FooBar {
        @Value.Parameter
        public abstract String information();

    }


    @EqualsAndHashCode
    static class PolymorphicContainer {
        public final FooBar fooOrBar;
        @JsonCreator
        PolymorphicContainer(FooBar fooOrBar) {
            this.fooOrBar = fooOrBar;
        }
    }


    public static Class<?> fooBar() {
        return FooBar.class;
    }
}
