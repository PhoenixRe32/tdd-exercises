package com.pittacode.anagrams.group;

import com.pittacode.anagrams.group.key.KeyGenerator;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class AnagramGrouper {

    private final KeyGenerator keyGenerator;

    public AnagramGrouper(KeyGenerator keyGenerator) {
        this.keyGenerator = keyGenerator;
    }


    public Map<String, Collection<String>> group(String string) {
        var key = keyGenerator.generate(string);
        return Map.of(key, Set.of(string));
    }
}
