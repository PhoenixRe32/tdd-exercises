package com.pittacode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void Mequals1000() {
        var result = converter.convert("M");
        assertThat(result).isEqualTo(1000);
    }
}
