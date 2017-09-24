package org.vaslabs.github.independent;

import org.immutables.value.Value;

/**
 * Created by vnicolaou on 01/09/17.
 */
@FluentStyle
@Value.Immutable
public abstract class AbstractRepo {

    abstract String fullName();
    abstract long id();

}
