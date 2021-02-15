package com.pittacode.greeter;

import java.util.Arrays;

import static java.util.function.Predicate.not;

class NameFilter {

    private final String[] names;

    NameFilter(String[] names) {
        this.names = names.clone();
    }

    String[] filterShoutedNames() {
        return Arrays.stream(names)
                     .filter(this::isShoutedName)
                     .toArray(String[]::new);
    }

    String[] filterNormalNames() {
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
