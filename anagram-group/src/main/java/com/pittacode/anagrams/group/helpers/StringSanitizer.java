package com.pittacode.anagrams.group.helpers;

import java.util.Locale;
import java.util.regex.Pattern;

public class StringSanitizer {

    private static final char SPACE = ' ';
    private static final Pattern NON_ALPHABETIC = Pattern.compile("[^a-zA-Z ]");
    private static final Pattern MULTIPLE_SPACE = Pattern.compile("  +");

    public String sanitize(String input) {
        var sanitizedString = input.codePoints()
                                   .mapToObj(i -> Character.isAlphabetic(i) ? (char) i : SPACE)
                                   .collect(CharacterHelpers.characterCollector());
        var withNormalSpacing = normaliseSpace(sanitizedString);
        return withNormalSpacing.toUpperCase(Locale.ROOT);
    }

    public String sanitizeUsingRegExp(String input) {
        return normaliseSpace(NON_ALPHABETIC.matcher(input).replaceAll(String.valueOf(SPACE)));
    }

    private String normaliseSpace(String input) {
        return MULTIPLE_SPACE.matcher(input).replaceAll(String.valueOf(SPACE));
    }
}
