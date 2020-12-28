package com.pittacode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTranslatorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 7, 8, 11, 13, 14})
    void whenTranslatingNumber_returnNumber(int i) {
        var underTest = new FizzBuzzTranslator();

        var result = underTest.translate(i);

        assertThat(result).isEqualTo(String.valueOf(i));
    }
}
