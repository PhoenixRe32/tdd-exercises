package com.pittacode.anagrams.group;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class AnagramGrouper {

    public Map<String, Collection<String>> group(String string) {
        return Map.of(string, Set.of(string));
    }
}
