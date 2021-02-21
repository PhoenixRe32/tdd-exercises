package com.pittacode.primefactors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeFactorsTest {

    @ParameterizedTest
    @MethodSource(value = "scenarios")
    public void shouldReturnPrimeFactors(int number, List<Integer> primeFactors) {
        var underTest = new PrimeFactors(number);
        assertThat(underTest.calculate()).containsExactlyElementsOf(primeFactors);
    }

    private static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(-100, List.of()),
                Arguments.of(0, List.of()),
                Arguments.of(1, List.of()),
                Arguments.of(2, List.of(2)),
                Arguments.of(3, List.of(3)),
                Arguments.of(4, List.of(2, 2)),
                Arguments.of(5, List.of(5)),
                Arguments.of(6, List.of(2, 3)),
                Arguments.of(7, List.of(7)),
                Arguments.of(100, List.of(2, 2, 5, 5))
        );
    }
}
