package org.vaslabs.github.immutables;

import org.immutables.value.Value;
import org.vaslabs.github.immutables.FluentStyle;

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

    public static Class<FooBar> fooBar() {
        return FooBar.class;
    }

}