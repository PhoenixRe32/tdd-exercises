package com.pittacode.anagrams.group;

import java.util.Objects;
import java.util.regex.Pattern;

public class StringCharacterSorter {

    private static final Pattern SPACE = Pattern.compile("\\s");
    private static final String EMPTY = "";

    public String sort(String input) {
        Objects.requireNonNull(input, "Can't sort null values");

        if (input.isBlank()) {
            return "";
        }

        return removeEmptySpace(input);
    }

    private String removeEmptySpace(String input) {
        return SPACE.matcher(input).replaceAll(EMPTY);
    }
}
