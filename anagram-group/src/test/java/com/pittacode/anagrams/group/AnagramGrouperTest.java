package com.pittacode.anagrams.group;

import com.pittacode.anagrams.group.key.KeyGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
}
