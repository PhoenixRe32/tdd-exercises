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
        var result = underTest.calculate();
        assertThat(result).containsExactlyElementsOf(primeFactors);
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
                Arguments.of(8, List.of(2, 2, 2)),
                Arguments.of(9, List.of(3, 3)),
                Arguments.of(10, List.of(2, 5)),
                Arguments.of(12, List.of(2, 2, 3)),
                Arguments.of(13, List.of(13)),
                Arguments.of(14, List.of(2, 7)),
                Arguments.of(15, List.of(3, 5)),
                Arguments.of(16, List.of(2, 2, 2, 2)),
                Arguments.of(17, List.of(17)),
                Arguments.of(18, List.of(2, 3, 3)),
                Arguments.of(19, List.of(19)),
                Arguments.of(20, List.of(2, 2, 5)),
                Arguments.of(24, List.of(2, 2, 2, 3)),
                Arguments.of(30, List.of(2, 3, 5)),
                Arguments.of(35, List.of(5, 7)),
                Arguments.of(74, List.of(2, 37)),
                Arguments.of(148, List.of(2, 2, 37)),
                Arguments.of(100, List.of(2, 2, 5, 5))
        );
    }
}
