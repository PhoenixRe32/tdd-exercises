package com.pittacode.greeter;

import java.util.Arrays;

import static java.util.function.Predicate.not;

public class NameDifferentiator {

    private final String[] names;

    public NameDifferentiator(String[] names) {
        this.names = names.clone();
    }

    public String[] getShoutedNames() {
        return Arrays.stream(names)
                     .filter(this::isShoutedName)
                     .toArray(String[]::new);
    }

    public String[] getNormalNames() {
        return Arrays.stream(names)
                     .filter(not(this::isShoutedName))
                     .toArray(String[]::new);
    }

    private boolean isShoutedName(String name) {
        return name.codePoints()
                   .mapToObj(i -> (char) i)
                   .allMatch(ch -> !Character.isLetter(ch) || Character.isUpperCase(ch));
    }
}
