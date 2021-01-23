package com.pittacode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RomanConverterTest {

    private RomanConverter converter;

    @BeforeEach
    void setUp() {
        converter = new RomanConverter();
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "E", "F", "G", "H", "J", "K", "N", "O", "P", "Q", "R", "S", "T", "U", "W", "Y", "Z"})
    void whenPasssingInvalidCharacter_throwException(String input) {
        assertThatThrownBy(() -> converter.convert(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("romanNumeralsAndTheirValues")
    void romanNumeralInput_convertsToTheExpectedValue(String romanNumeral, int decimalValue) {
        var result = converter.convert(romanNumeral);

        assertThat(result).isEqualTo(decimalValue);
    }

    private static Stream<Arguments> romanNumeralsAndTheirValues() {
        return Stream.of(
                arguments("I", 1),
                arguments("II", 2),
                arguments("III", 3),
                arguments("V", 5),
                arguments("X", 10),
                arguments("L", 50),
                arguments("C", 100),
                arguments("D", 500),
                arguments("M", 1000)
        );
    }
}
