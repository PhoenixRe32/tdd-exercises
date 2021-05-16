package com.pittacode.anagrams.group.key;

import java.util.stream.Collector;

final class CharacterHelpers {

    static Collector<Character, StringBuilder, String> characterCollector() {
        return Collector.of(
                StringBuilder::new, // supply object that will collect characters
                StringBuilder::append, // accumulate each character to supplier above
                StringBuilder::append, // if running in parallel, this is how you combine the parallel accumulators
                StringBuilder::toString); // once done, finish it with this action
    }

    private CharacterHelpers() {
        // never initialise
    }
}
