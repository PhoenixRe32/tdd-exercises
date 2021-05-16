package com.pittacode.anagrams.group;

import java.util.Objects;

public class StringCharacterSorter {

    public String sort(String input) {
        Objects.requireNonNull(input, "Can't sort null values");

        if (input.isBlank()) {
            return "";
        }

        return removeEmptySpace(input);
    }

    private String removeEmptySpace(String input) {
        return input.replaceAll("\\s", "");
    }
}
