package com.pittacode.greeter;

import java.util.Arrays;

import static java.util.function.Predicate.not;

class NameDifferentiator {

    private final String[] names;

    NameDifferentiator(String[] names) {
        this.names = names.clone();
    }

    String[] getShoutedNames() {
        return Arrays.stream(names)
                     .filter(this::isShoutedName)
                     .toArray(String[]::new);
    }

    String[] getNormalNames() {
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
