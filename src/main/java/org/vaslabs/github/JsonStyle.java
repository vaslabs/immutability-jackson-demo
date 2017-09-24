package org.vaslabs.github;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@JsonDeserialize
@JsonSerialize
@Value.Style(
        typeAbstract = "Abstract*",
        typeImmutable = "*",
        visibility = Value.Style.ImplementationVisibility.PUBLIC)
@interface JsonStyle {}
