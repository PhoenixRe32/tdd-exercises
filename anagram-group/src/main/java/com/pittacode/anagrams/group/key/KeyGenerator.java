package com.pittacode.anagrams.group.key;

public class KeyGenerator {

    private final StringSanitizer stringSanitizer;
    private final StringCharacterSorter stringCharacterSorter;

    public static KeyGenerator keyGenerator() {
        return new KeyGenerator(new StringSanitizer(), new StringCharacterSorter());
    }

    public KeyGenerator(StringSanitizer stringSanitizer, StringCharacterSorter stringCharacterSorter) {
        this.stringSanitizer = stringSanitizer;
        this.stringCharacterSorter = stringCharacterSorter;
    }

    public String generate(String input) {
        return stringCharacterSorter.sort(stringSanitizer.sanitize(input));
    }
}
