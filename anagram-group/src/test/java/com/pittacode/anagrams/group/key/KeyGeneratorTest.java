package com.pittacode.anagrams.group.key;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KeyGeneratorTest {

    @Test
    void shouldGenerateAKeyInUpperCaseWithOnlyAlphabeticCharacters() {
        var underTest = new KeyGenerator(new StringSanitizer(), new StringCharacterSorter());
        var result = underTest.generate("anagram");
        assertThat(result).isEqualTo("AAAGMNR");
    }
}