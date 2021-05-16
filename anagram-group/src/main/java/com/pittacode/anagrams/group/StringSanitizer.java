package com.pittacode.anagrams.group;

import java.util.regex.Pattern;

import static com.pittacode.anagrams.group.CharacterHelpers.characterCollector;

public class StringSanitizer {

    private static final char SPACE = ' ';
    private static final Pattern NON_ALPHABETIC = Pattern.compile("[^a-zA-Z ]");
    private static final Pattern MULTIPLE_SPACE = Pattern.compile("  +");

    public String sanitize(String input) {
        var sanitizedString = input.codePoints()
                                   .mapToObj(i -> Character.isAlphabetic(i) ? (char) i : SPACE)
                                   .collect(characterCollector());
        return normaliseSpace(sanitizedString);
    }

    public String sanitizeUsingRegExp(String input) {
        return normaliseSpace(NON_ALPHABETIC.matcher(input).replaceAll(String.valueOf(SPACE)));
    }

    private String normaliseSpace(String input) {
        return MULTIPLE_SPACE.matcher(input).replaceAll(String.valueOf(SPACE));
    }
}
