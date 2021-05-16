package com.pittacode.anagrams.group.helpers;

import java.util.regex.Pattern;

import static com.pittacode.anagrams.group.helpers.CharacterHelpers.characterCollector;
import static java.util.Objects.requireNonNull;

public class StringCharacterSorter {

    private static final Pattern SPACE = Pattern.compile("\\s");
    private static final String EMPTY = "";

    public String sort(String input) {
        requireNonNull(input, "Can't sort null values");

        if (input.isBlank()) return "";

        var inputWithoutSpaces = removeEmptySpace(input);

        if (isSingleCharacter(inputWithoutSpaces)) return inputWithoutSpaces;

        return sortCharacters(inputWithoutSpaces);
    }

    private boolean isSingleCharacter(String inputWithoutSpaces) {
        return inputWithoutSpaces.length() == 1;
    }

    private String removeEmptySpace(String input) {
        return SPACE.matcher(input).replaceAll(EMPTY);
    }

    private String sortCharacters(String inputWithoutSpaces) {
        return inputWithoutSpaces.codePoints()
                                 .mapToObj(i -> (char) i)
                                 .sorted()
                                 .collect(characterCollector());
    }
}
