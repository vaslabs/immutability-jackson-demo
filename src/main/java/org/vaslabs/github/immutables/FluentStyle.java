package org.vaslabs.github.immutables;

import org.immutables.value.Value;


@Value.Style(
        typeAbstract = "Abstract*",
        typeImmutable = "*",
        visibility = Value.Style.ImplementationVisibility.PUBLIC)
public @interface FluentStyle{}