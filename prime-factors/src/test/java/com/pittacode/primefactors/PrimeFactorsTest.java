package com.pittacode.primefactors;

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

    @Test
    void shouldReturn2_whenNumberIs2() {
        var underTest = new PrimeFactors(2);
        assertThat(underTest.calculate()).containsExactly(2);
    }

    @Test
    void shouldReturn3_whenNumberIs3() {
        var underTest = new PrimeFactors(3);
        assertThat(underTest.calculate()).containsExactly(3);
    }

    @Test
    void shouldReturn2_2_whenNumberIs4() {
        var underTest = new PrimeFactors(4);
        assertThat(underTest.calculate()).containsExactly(2, 2);
    }
}
