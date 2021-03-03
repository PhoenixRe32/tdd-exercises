package com.pittacode.magnet.particulars;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.text.DecimalFormat;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MagentsTest {

    @ParameterizedTest
    @MethodSource("examples")
    public void shouldCalulateResultInAcceptedRange(int maxRows, int maxColumns, double expected) {
        var underTest = new Magents();

        assertFuzzyEquals(underTest.doubles(maxRows, maxColumns), expected);
    }

    private static Stream<Arguments> examples() {
        return Stream.of(
                arguments(1, 10, 0.5580321939764581),
                arguments(10, 1000, 0.6921486500921933),
                arguments(10, 10000, 0.6930471674194457),
                arguments(20, 10000, 0.6930471955575918)
        );
    }

    private static void assertFuzzyEquals(double act, double exp) {
        boolean inrange = Math.abs(act - exp) <= 1.0e-6;
        if (!inrange) {
            DecimalFormat df = new DecimalFormat("#0.000000");
            System.out.println("At 1e-6: Expected must be " + df.format(exp) + ", but got " + df.format(act));
        }
        assertThat(inrange).isTrue();
    }
}
