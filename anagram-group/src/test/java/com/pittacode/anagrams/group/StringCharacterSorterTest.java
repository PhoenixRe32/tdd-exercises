package com.pittacode.anagrams.group;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER;
import static org.junit.jupiter.params.ParameterizedTest.DISPLAY_NAME_PLACEHOLDER;

public class StringCharacterSorterTest {

    private StringCharacterSorter underTest;

    @BeforeEach
    void setUp() {
        underTest = new StringCharacterSorter();
    }

    @ParameterizedTest(name = ARGUMENTS_WITH_NAMES_PLACEHOLDER + " -> " + DISPLAY_NAME_PLACEHOLDER)
    @ValueSource(strings = {"a", "%", "1", "D"})
    void shouldReturnInputWhenItIsSingleCharacter(String input) {
        var result = underTest.sort(input);
        assertThat(result).isEqualTo(input);
    }

    @ParameterizedTest(name = ARGUMENTS_WITH_NAMES_PLACEHOLDER + " -> " + DISPLAY_NAME_PLACEHOLDER)
    @ValueSource(strings = {"", "    ", " "})
    void shouldReturnEmptyStringWhenItIsBlank(String input) {
        var result = underTest.sort(input);
        assertThat(result).isEqualTo("");
    }

    @Test
    void shouldNotAcceptNullInput() {
        assertThatThrownBy(() -> underTest.sort(null));
    }

    @Test
    void shouldReturnStringWithSameNumberOfNonEmptyCharacters() {
        var result = underTest.sort("aaa aaa");
        assertThat(result.length()).isEqualTo(6);
    }
}
