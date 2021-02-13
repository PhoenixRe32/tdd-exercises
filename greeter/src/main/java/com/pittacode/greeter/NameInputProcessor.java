package com.pittacode.greeter;

import java.util.Arrays;

public class NameInputProcessor {

    public String[] splitAnyCommaSeparatedEntriesToSingleNames(String[] names) {
        return Arrays.stream(names)
                     .map(this::splitNames)
                     .map(this::trimNames)
                     .flatMap(arr -> Arrays.stream(arr.clone()))
                     .toArray(String[]::new);
    }

    private String[] trimNames(String[] names) {
        return Arrays.stream(names)
                     .map(String::trim)
                     .toArray(String[]::new);
    }

    private String[] splitNames(String name) {
        return isNameSurrounedWithQuotes(name)
                ? new String[]{removeQuotes(name)}
                : name.split(",");
    }

    private boolean isNameSurrounedWithQuotes(String name) {
        return name.startsWith("\"") && name.endsWith("\"");
    }

    private String removeQuotes(String name) {
        return name.substring(1, name.length() - 1);
    }
}
