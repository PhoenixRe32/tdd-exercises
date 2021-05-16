package com.pittacode.anagrams.group;

import static com.pittacode.anagrams.group.CharacterHelpers.characterCollector;

public class StringSanitizer {

    private static final char SPACE = ' ';

    public String sanitize(String input) {
        return input.codePoints()
                    .mapToObj(i -> Character.isAlphabetic(i) ? (char) i : SPACE)
                    .collect(characterCollector());
    }
}
