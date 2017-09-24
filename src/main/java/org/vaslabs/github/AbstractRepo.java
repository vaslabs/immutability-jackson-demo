package org.vaslabs.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

/**
 * Created by vnicolaou on 01/09/17.
 */
@JsonStyle
@Value.Immutable
public abstract class AbstractRepo {

    @JsonProperty("full_name") abstract String fullName();
    abstract long id();

}
