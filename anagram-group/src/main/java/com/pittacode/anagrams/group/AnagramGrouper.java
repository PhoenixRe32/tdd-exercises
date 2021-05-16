package com.pittacode.anagrams.group;

import com.pittacode.anagrams.group.helpers.StringCharacterSorter;
import com.pittacode.anagrams.group.helpers.StringSanitizer;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class AnagramGrouper {

    private final StringSanitizer stringSanitizer;
    private final StringCharacterSorter stringCharacterSorter;

    public AnagramGrouper(StringSanitizer stringSanitizer, StringCharacterSorter stringCharacterSorter) {
        this.stringSanitizer = stringSanitizer;
        this.stringCharacterSorter = stringCharacterSorter;
    }

    public Map<String, Collection<String>> group(String string) {
        var key = stringCharacterSorter.sort(stringSanitizer.sanitize(string));
        return Map.of(key, Set.of(string));
    }
}
