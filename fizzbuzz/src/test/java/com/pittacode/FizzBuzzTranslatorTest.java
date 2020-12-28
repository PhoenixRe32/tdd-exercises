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

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 12, 18, 21, 24, 27})
    void whenTranslatingMultipleOf3_returnFizz(int i) {
        var underTest = new FizzBuzzTranslator();

        var result  = underTest.translate(i);

        assertThat(result).isEqualTo("Fizz");
    }


    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55})
    void whenTranslatingMultipleOf5_returnBuzz(int i) {
        var underTest = new FizzBuzzTranslator();

        var result  = underTest.translate(i);

        assertThat(result).isEqualTo("Buzz");
    }
}
