package org.vaslabs.github.lombok;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public final class DummyObject {
    public final String name;
    public final int size;
    public final ImmutableList<String> someStuff;
}
