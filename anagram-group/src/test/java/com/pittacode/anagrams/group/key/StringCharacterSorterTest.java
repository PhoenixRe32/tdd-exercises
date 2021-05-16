package com.pittacode.anagrams.group.key;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER;
import static org.junit.jupiter.params.ParameterizedTest.DISPLAY_NAME_PLACEHOLDER;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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
    void shouldReturnStringWithSameNumberOfNonWhitespaceCharacters() {
        var result = underTest.sort("aaa aaa");
        assertThat(result).hasSize(6);
    }

    @ParameterizedTest(name = ARGUMENTS_WITH_NAMES_PLACEHOLDER + " -> " + DISPLAY_NAME_PLACEHOLDER)
    @MethodSource("stringsAndTheirSortedCharacters")
    void shouldReturnNonWhitespaceCharactersInAlphabeticalOrder(String input, String expectedOutput) {
        var result = underTest.sort(input);
        assertThat(result).isEqualTo(expectedOutput);
    }

    private static Stream<Arguments> stringsAndTheirSortedCharacters() {
        return Stream.of(
                arguments("cab", "abc"),
                arguments("fedcba321", "123abcdef"),
                arguments("2wsx", "2swx"),
                arguments("0123456789abcdefg", "0123456789abcdefg")
        );
    }
}
