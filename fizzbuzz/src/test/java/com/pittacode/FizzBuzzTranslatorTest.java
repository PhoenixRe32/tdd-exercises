package com.pittacode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTranslatorTest {

    @Test
    void whenTranslatingNumber_returnNumber() {
        var underTest = new FizzBuzzTranslator();

        var result = underTest.translate(1);

        assertThat(result).isEqualTo("1");
    }
}
