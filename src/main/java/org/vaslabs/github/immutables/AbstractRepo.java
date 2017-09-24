package org.vaslabs.github.immutables;

import org.immutables.value.Value;
import org.vaslabs.github.immutables.FluentStyle;

/**
 * Created by vnicolaou on 01/09/17.
 */
@FluentStyle
@Value.Immutable
abstract class AbstractRepo {

    abstract String fullName();
    abstract long id();

}
