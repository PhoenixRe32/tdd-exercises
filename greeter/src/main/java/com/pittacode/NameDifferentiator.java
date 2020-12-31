package com.pittacode;

import java.util.Arrays;

import static java.util.function.Predicate.not;

public class NameDifferentiator {

    private final String[] names;

    public NameDifferentiator(String[] names) {
        this.names = names;
    }

    public String[] getNormalNames() {
        return Arrays.stream(names)
                     .filter(NameUtils::isShoutedName)
                     .toArray(String[]::new);
    }

    public String[] getShoutedNames() {
        return Arrays.stream(names)
                     .filter(not(NameUtils::isShoutedName))
                     .toArray(String[]::new);
    }
}
