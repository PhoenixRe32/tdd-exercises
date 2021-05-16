package com.pittacode.anagrams.group;

import com.pittacode.anagrams.group.key.KeyGenerator;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnagramGrouper {

    private final KeyGenerator keyGenerator;

    public AnagramGrouper(KeyGenerator keyGenerator) {
        this.keyGenerator = keyGenerator;
    }

    public Map<String, Collection<String>> group(String anagram) {
        return group(Set.of(anagram));
    }

    public Map<String, Collection<String>> group(Collection<String> anagrams) {
        Map<String, Collection<String>> groups = new HashMap<>();
        for (var anagram : anagrams) {
            var key = keyGenerator.generate(anagram);
            if (groups.containsKey(key)) {
                groups.get(key).add(anagram);
            } else {
                groups.put(key, initialiseAnagramGroup(anagram));
            }
        }
        return groups;
    }

    private Set<String> initialiseAnagramGroup(String anagram) {
        var collectedAnagrams = new HashSet<String>();
        collectedAnagrams.add(anagram);
        return collectedAnagrams;
    }
}
