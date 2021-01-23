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
                arguments("VI", 6),
                arguments("VII", 7),
                arguments("VIII", 8),

                arguments("X", 10),
                arguments("XI", 11),
                arguments("XII", 12),
                arguments("XIII", 13),
                arguments("XV", 15),
                arguments("XVI", 16),
                arguments("XVII", 17),
                arguments("XVIII", 18),

                arguments("XX", 20),
                arguments("XXI", 21),
                arguments("XXII", 22),
                arguments("XXIII", 23),
                arguments("XXV", 25),
                arguments("XXVI", 26),
                arguments("XXVII", 27),
                arguments("XXVIII", 28),

                arguments("XXX", 30),
                arguments("XXXI", 31),
                arguments("XXXII", 32),
                arguments("XXXIII", 33),
                arguments("XXXV", 35),
                arguments("XXXVI", 36),
                arguments("XXXVII", 37),
                arguments("XXXVIII", 38),

                arguments("L", 50),
                arguments("LV", 55),

                arguments("LX", 60),
                arguments("LXV", 65),

                arguments("LXX", 70),
                arguments("LXXV", 75),

                arguments("LXXX", 80),
                arguments("LXXXV", 85),

                arguments("C", 100),
                arguments("CX", 110),
                arguments("CXV", 115),
                arguments("CL", 150),

                arguments("CC", 200),
                arguments("CCC", 300),

                arguments("D", 500),

                arguments("DC", 600),
                arguments("DCC", 700),
                arguments("DCCC", 800),

                arguments("M", 1000),
                arguments("MM", 2000)
        );
    }
}
