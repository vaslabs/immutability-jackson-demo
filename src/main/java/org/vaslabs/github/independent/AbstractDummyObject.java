package org.vaslabs.github.independent;

import org.immutables.value.Value;

import java.io.Serializable;

/**
 * Created by vnicolaou on 01/09/17.
 */
@FluentStyle
@Value.Immutable
public abstract class AbstractDummyObject {

    @Value.Parameter
    public abstract String name();
    @Value.Parameter
    public abstract int size();

}