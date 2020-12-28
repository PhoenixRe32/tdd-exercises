package com.pittacode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTranslatorTest {

    private FizzBuzzTranslator underTest;

    @BeforeEach
    void setUp() {
        underTest = new FizzBuzzTranslator();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 7, 8, 11, 13, 14})
    void whenTranslatingNumber_returnNumber(int i) {
        var result = underTest.translate(i);

        assertThat(result).isEqualTo(String.valueOf(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 12, 18, 21, 24, 27})
    void whenTranslatingMultipleOf3_returnFizz(int i) {
        var result  = underTest.translate(i);

        assertThat(result).isEqualTo("Fizz");
    }


    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 25, 35, 40, 50, 55})
    void whenTranslatingMultipleOf5_returnBuzz(int i) {
        var result  = underTest.translate(i);

        assertThat(result).isEqualTo("Buzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45, 60, 75, 90})
    void whenTranslatingMultipleOf15_returnFizzBuzz(int i) {
        var result  = underTest.translate(i);

        assertThat(result).isEqualTo("FizzBuzz");
    }
}
