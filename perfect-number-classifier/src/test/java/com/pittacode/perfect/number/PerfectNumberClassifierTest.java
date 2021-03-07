package com.pittacode.perfect.number;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER;
import static org.junit.jupiter.params.ParameterizedTest.DISPLAY_NAME_PLACEHOLDER;

class PerfectNumberClassifierTest {

    @ParameterizedTest(name = ARGUMENTS_WITH_NAMES_PLACEHOLDER + " -> " + DISPLAY_NAME_PLACEHOLDER)
    @ValueSource(longs = {6L, 28L, 496L, 8_128L, 33_550_336L, 8_589_869_056L, 137_438_691_328L})
    void should_classify_number_as_perfect(long number) {
        var underTest = new PerfectNumberClassifier();

        assertThat(underTest.isPerfect(number)).isTrue();
    }
}
