package com.pittacode.anagrams.group;

import com.pittacode.anagrams.group.helpers.StringCharacterSorter;
import com.pittacode.anagrams.group.helpers.StringSanitizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnagramGrouperTest {

    private AnagramGrouper underTest;
    private StringSanitizer stringSanitizer;
    private StringCharacterSorter stringCharacterSorter;

    @Nested
    @DisplayName("When single string is passed")
    class WhenSingleString {

        @BeforeEach
        void setUp() {
            stringSanitizer = new StringSanitizer();
            stringCharacterSorter = new StringCharacterSorter();
            underTest = new AnagramGrouper(stringSanitizer, stringCharacterSorter);
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
