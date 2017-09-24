package org.vaslabs.github.json;

import com.google.common.collect.ImmutableList;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class DummyObject {
    public final String name;
    public final int size;
    public final ImmutableList<String> someStuff;

    public DummyObject(String name, int size, ImmutableList<String> someStuff) {
        this.name = name;
        this.size = size;
        this.someStuff = someStuff;
    }

}
