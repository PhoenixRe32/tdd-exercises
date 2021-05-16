package com.pittacode.anagrams.group;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class AnagramGrouperTest {

    private AnagramGrouper underTest;

    @BeforeEach
    void setUp() {
        underTest = new AnagramGrouper();
    }

    @Test
    void shouldReturnMapWithSingleEntryWhenSingleStringIsPassed() {
        var result = underTest.group("First String");
        assertThat(result).hasSize(1);
    }
}
