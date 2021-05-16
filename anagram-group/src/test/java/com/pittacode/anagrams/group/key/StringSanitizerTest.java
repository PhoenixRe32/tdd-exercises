package com.pittacode.anagrams.group.key;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSanitizerTest {

    private static final String NON_ALPHABETIC_CHARS = "±!@£$%^&*()_+=-§:\"|';?><,./~`' ";

    private StringSanitizer underTest;

    @BeforeEach
    void setUp() {
        underTest = new StringSanitizer();
    }

    @Test
    void shouldRemoveNonAlphanumericCharactersFromString() {
        var result  = underTest.sanitize(NON_ALPHABETIC_CHARS);
        assertThat(result).isBlank();
    }

    @Test
    void shouldRemoveNonAlphanumericCharactersFromStringUsingRegExp() {
        var result  = underTest.sanitizeUsingRegExp(NON_ALPHABETIC_CHARS);
        assertThat(result).isBlank();
    }

    @Test
    void shouldReduceMultipleEmptySpacesToSingleSpace() {
        var result = underTest.sanitize(NON_ALPHABETIC_CHARS);
        assertThat(result).hasSize(1);
    }

    @Test
    void shouldReduceInbetweenEmptySpaceToSingleSpace() {
        var result  = underTest.sanitize("A    A !@££ 2!@£A");
        assertThat(result).isEqualTo("A A A");
    }

    @Test
    void shouldConvertAllToUpperCase() {
        var result  = underTest.sanitize("abcDEFgHZ");
        assertThat(result).isEqualTo("ABCDEFGHZ");
    }
}
