package org.vaslabs.github;

import org.immutables.value.Value;


@Value.Style(
        typeAbstract = "Abstract*",
        typeImmutable = "*",
        visibility = Value.Style.ImplementationVisibility.PUBLIC)
@interface FluentStyle{}