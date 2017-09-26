package org.vaslabs.github.immutables;

import com.google.common.base.Preconditions;
import org.immutables.value.Value;
/**
 * Created by vnicolaou on 01/09/17.
 */
@FluentStyle
@Value.Immutable
abstract class AbstractDummyObject {

    @Value.Parameter
    public abstract String name();
    @Value.Parameter
    public abstract int size();

    @Value.Check
    protected void check() {
        Preconditions.checkArgument(
                name() != null && !name().isEmpty(),
                "Name must not be null or empty"
        );
    }
}
