package com.pittacode.greeter.greeting.factory;

import java.util.ArrayList;
import java.util.List;

class NameFilter {

    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    Names filterNames(String[] names) {
        List<String> normalNames = new ArrayList<>(names.length);
        List<String> shoutedNames = new ArrayList<>(names.length);
        for (String name : names) {
            if (isShoutedName(name)) {
                shoutedNames.add(name);
            } else {
                normalNames.add(name);
            }
        }
        return new Names(normalNames.toArray(EMPTY_STRING_ARRAY), shoutedNames.toArray(EMPTY_STRING_ARRAY));
    }

    private boolean isShoutedName(String name) {
        return name.codePoints()
                   .mapToObj(i -> (char) i)
                   .allMatch(ch -> !Character.isLetter(ch) || Character.isUpperCase(ch));
    }

    static class Names {

        final String[] normalNames;
        final String[] shoutedNames;

        Names(String[] normalNames, String[] shoutedNames) {
            this.normalNames = normalNames.clone();
            this.shoutedNames = shoutedNames.clone();
        }
    }
}
