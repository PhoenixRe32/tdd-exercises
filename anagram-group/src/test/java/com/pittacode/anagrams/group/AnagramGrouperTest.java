package com.pittacode.anagrams.group;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.pittacode.anagrams.group.key.KeyGenerator.keyGenerator;
import static org.assertj.core.api.Assertions.assertThat;

public class AnagramGrouperTest {

    private AnagramGrouper underTest;

    @Nested
    @DisplayName("When single string is passed")
    class WhenSingleString {

        @BeforeEach
        void setUp() {
            underTest = new AnagramGrouper(keyGenerator());
        }

        @Test
        void shouldReturnMapWithSingleEntry() {
            var result = underTest.group("First String");
            assertThat(result).hasSize(1);
        }

        @Test
        void shouldHaveTheSortedStringCharactersAsKey() {
            var result = underTest.group("First String");
            assertThat(result).containsOnlyKeys("FGIINRRSSTT");
        }
    }

    @Nested
    @DisplayName("When multiple strings are passed that are anagrams.txt of each other")
    class WhenMultipleStringOfSameAnagram {

        @BeforeEach
        void setUp() {
            underTest = new AnagramGrouper(keyGenerator());
        }

        @Test
        void shouldReturnMapWithSingleEntry() {
            var result = underTest.group(Set.of("A Snared",
                                                "Ad Earns",
                                                "Ad Nears",
                                                "Read San",
                                                "Dare San",
                                                "Dear San",
                                                "Reads An",
                                                "Rand Sea",
                                                "Sand Are",
                                                "Sand Ear",
                                                "Sand Era",
                                                "Rad Sane",
                                                "andreas"));
            assertThat(result).hasSize(1);
            assertThat(result).containsOnlyKeys("AADENRS");
        }
    }

    @Nested
    @DisplayName("When multiple anagrams.txt are passed")
    class WhenMultipleAnagrams {

        @BeforeEach
        void setUp() {
            underTest = new AnagramGrouper(keyGenerator());
        }

        @Test
        void shouldReturnMapWithSameNumberOfEntriesAsTheAnagrams() {
            var anagram1 = "andreas";
            var anagram2 = "eleni";
            var anagram3 = "alexis";
            var result = underTest.group(Set.of(anagram1, anagram2, anagram3));
            assertThat(result).hasSize(3);
            assertThat(result).containsOnlyKeys("AADENRS", "EEILN", "AEILSX");
            assertThat(result.get("AADENRS")).containsExactly(anagram1);
            assertThat(result.get("EEILN")).containsExactly(anagram2);
            assertThat(result.get("AEILSX")).containsExactly(anagram3);
        }


        @Test
        void shouldReturnMapWithSameNumberOfEntriesAsTheAnagramsAndTheCorrectEntriesUnderEachKey() {
            var anagram1a = "andreas";
            var anagram1b = "Sand Era";
            var anagram2a = "eleni";
            var anagram2b = "Eel In";
            var anagram2c = "Lee In";
            var result = underTest.group(Set.of(anagram1a, anagram1b, anagram2a, anagram2b, anagram2c));
            assertThat(result).hasSize(2);
            assertThat(result).containsOnlyKeys("AADENRS", "EEILN");
            assertThat(result.get("AADENRS")).containsExactlyInAnyOrder(anagram1a, anagram1b);
            assertThat(result.get("EEILN")).containsExactlyInAnyOrder(anagram2a, anagram2b, anagram2c);
        }
    }
}
