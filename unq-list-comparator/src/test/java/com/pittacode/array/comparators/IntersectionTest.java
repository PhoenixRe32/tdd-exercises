package com.pittacode.array.comparators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IntersectionTest {

    public static final int[] EMPTY_ARRAY = new int[0];

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @MethodSource("arraysWithNoCommonElement")
    void shouldReturn0_whenArraysHaveNothingInCommon(int[] array1, int[] array2) {
        var intersection = new Intersection();
        var result = intersection.calculate(array1, array2);
        assertThat(result).isEqualTo(0);
    }

    private static Stream<Arguments> arraysWithNoCommonElement() {
        return Stream.of(
                Arguments.of(new int[]{10, 3}, new int[]{4}),
                Arguments.of(new int[]{10, 3}, new int[]{1, 5}),
                Arguments.of(new int[]{10, 3, 5, 12, 54, 34}, new int[]{0, -10, -34, -23, -3})
        );
    }

    @ParameterizedTest
    @MethodSource("arrays")
    void shouldReturn0_whenOneArraysIsEmpty(int[] array) {
        var intersection = new Intersection();
        var result = intersection.calculate(EMPTY_ARRAY, array);
        assertThat(result).isEqualTo(0);
    }


    private static Stream<int[]> arrays() {
        return Stream.of(
                EMPTY_ARRAY,
                new int[]{10, 3},
                new int[]{10, 3, 5, 12, 54, 34},
                new int[]{0, -10, -34, -23, -3}
        );
    }

    @Test
    void shouldReturn1_whenArraysAreEquivalent() {
        var intersection = new Intersection();
        var result = intersection.calculate(new int[]{3}, new int[]{3});
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest
    @MethodSource("arraysWithOneCommonElement")
    void shouldReturn1_whenArraysAreOfDifferentSizeAndHaveOneCommonElement(int[] array1, int[] array2) {
        var intersection = new Intersection();
        var result = intersection.calculate(array1, array2);
        assertThat(result).isEqualTo(1);
    }

    private static Stream<Arguments> arraysWithOneCommonElement() {
        return Stream.of(
                Arguments.of(new int[]{10, 3}, new int[]{3}),
                Arguments.of(new int[]{10, 3}, new int[]{3, 5}),
                Arguments.of(new int[]{10, 3, 5, 12, 54, 34}, new int[]{0, -10, -34, -23, 3})
        );
    }
}