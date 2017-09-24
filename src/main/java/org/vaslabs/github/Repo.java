package org.vaslabs.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

/**
 * Created by vnicolaou on 01/09/17.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableRepo.class)
@JsonDeserialize(as = ImmutableRepo.class)
public interface Repo {

    @JsonProperty("full_name") String fullName();
    long id();

}
