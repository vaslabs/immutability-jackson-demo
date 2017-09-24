package org.vaslabs.github;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.io.Serializable;

/**
 * Created by vnicolaou on 01/09/17.
 */
@JsonStyle
@Value.Immutable
public abstract class AbstractDummyObject implements Serializable {

    @Value.Parameter
    public abstract String name();
    @Value.Parameter
    public abstract int size();

}
