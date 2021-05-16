package com.pittacode.anagrams.group;

import com.pittacode.anagrams.group.key.KeyGenerator;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toMap;

public class AnagramGrouper {

    private final KeyGenerator keyGenerator;

    public AnagramGrouper(KeyGenerator keyGenerator) {
        this.keyGenerator = keyGenerator;
    }

    public Map<String, Collection<String>> group(String... anagram) {
        return group(Set.of(anagram));
    }

    public Map<String, Collection<String>> group(Collection<String> anagrams) {
        return anagrams.stream()
                       .map(this::convertToKeyValuePair)
                       .collect(toMap(
                               Map.Entry::getKey,
                               this::getValueAsCollection,
                               this::mergeValueCollectionsOfSameKeys,
                               (Supplier<HashMap<String, Collection<String>>>) HashMap::new
                       ));
    }

    private Map.Entry<String, String> convertToKeyValuePair(String anagram) {
        return Map.entry(keyGenerator.generate(anagram), anagram);
    }

    private HashSet<String> getValueAsCollection(Map.Entry<String, String> entry) {
        return new HashSet<>(Set.of(entry.getValue()));
    }

    private Collection<String> mergeValueCollectionsOfSameKeys(Collection<String> v1, Collection<String> v2) {
        v1.addAll(v2);
        return v1;
    }
}
