package com.pittacode.anagrams.group;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSanitizerTest {

    private static final String NON_ALPHABETIC_CHARS = "±!@£$%^&*()_+=-§:\"|';?><,./~`'";

    private StringSanitizer underTest;

    @BeforeEach
    void setUp() {
        underTest = new StringSanitizer();
    }

    @Test
    void shouldRemoveNonAlphanumericCharactersFromString() {
        var result  = underTest.sanitize(NON_ALPHABETIC_CHARS);
        assertThat(result.isBlank()).isTrue();
    }
}
