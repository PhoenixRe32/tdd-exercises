package com.pittacode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RomanConverterTest {
    private RomanConverter converter;

//    @ParameterizedTest
//    @ValueSource(strings = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"})
//    void whenPasssingInvalidCharacter_throwException() {
//
//    }

    @BeforeEach
    void setUp() {
        converter = new RomanConverter();
    }

    @Test
    void Iequals1() {
        var result = converter.convert("I");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void Vequals5() {
        var result = converter.convert("V");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void Xequals10() {
        var result = converter.convert("X");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void Lequals50() {
        var result = converter.convert("L");
        assertThat(result).isEqualTo(50);
    }

    @Test
    void Cequals100() {
        var result = converter.convert("C");
        assertThat(result).isEqualTo(100);
    }

    @Test
    void Dequals500() {
        var result = converter.convert("D");
        assertThat(result).isEqualTo(500);
    }
}
