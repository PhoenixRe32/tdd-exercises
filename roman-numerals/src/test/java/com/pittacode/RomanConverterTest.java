package com.pittacode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RomanConverterTest {

//    @ParameterizedTest
//    @ValueSource(strings = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"})
//    void whenPasssingInvalidCharacter_throwException() {
//
//    }

    @Test
    void Iequals1() {
        var converter = new RomanConverter();

        var result = converter.convert("I");

        assertThat(result).isEqualTo(1);
    }

    @Test
    void Vequals5() {
        var converter = new RomanConverter();

        var result = converter.convert("V");

        assertThat(result).isEqualTo(5);
    }
}
