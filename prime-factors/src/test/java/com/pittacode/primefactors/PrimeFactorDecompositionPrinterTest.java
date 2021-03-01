package com.pittacode.primefactors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PrimeFactorDecompositionPrinterTest {

    @ParameterizedTest
    @MethodSource("decompositions")
    void shouldPrintDecomposition(Integer number, String decomposition) {
        var primeFactorDecompositionPrinter = new PrimeFactorDecompositionPrinter(new PrimeFactors());
        var result = primeFactorDecompositionPrinter.print(number);

        assertThat(result).isEqualTo(decomposition);
    }

    private static Stream<Arguments> decompositions() {
        return Stream.of(
                arguments(6, "(2)(3)"),
                arguments(8, "(2**3)"),
                arguments(13, "(13)"),
                arguments(16, "(2**4)"),
                arguments(100, "(2**2)(5**2)"),
                arguments(7775460, "(2**2)(3**3)(5)(7)(11**2)(17)"),
                arguments(86240, "(2**5)(5)(7**2)(11)")
        );
    }
}
