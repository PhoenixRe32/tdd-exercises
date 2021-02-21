package com.pittacode.primefactors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeFactorsTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 0, -20})
    void shouldReturnEmptyList_whenLessThan2(int number) {
        var underTest = new PrimeFactors(number);

        assertThat(underTest.calculate()).isEmpty();
    }
}
