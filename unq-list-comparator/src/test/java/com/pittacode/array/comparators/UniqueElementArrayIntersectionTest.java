package com.pittacode.array.comparators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.ParameterizedTest.ARGUMENTS_PLACEHOLDER;
import static org.junit.jupiter.params.ParameterizedTest.DISPLAY_NAME_PLACEHOLDER;

class UniqueElementArrayIntersectionTest {

    public static final Integer[] EMPTY_ARRAY = new Integer[0];

    private UniqueElementArrayIntersection<Integer> underTest;

    @BeforeEach
    void setUp() {
        underTest = new UniqueElementArrayIntersection<>(Integer.class);
    }

    @ParameterizedTest
    @MethodSource("arraysWithNoCommonElement")
    void shouldReturn0_whenArraysHaveNothingInCommon(Integer[] array1, Integer[] array2) {
        var result = underTest.calculate(array1, array2);
        assertThat(result).isEqualTo(0);
    }

    private static Stream<Arguments> arraysWithNoCommonElement() {
        return Stream.of(
                Arguments.of(new Integer[]{10, 3}, new Integer[]{4}),
                Arguments.of(new Integer[]{10, 3}, new Integer[]{1, 5}),
                Arguments.of(new Integer[]{10, 3, 5, 12, 54, 34}, new Integer[]{0, -10, -34, -23, -3})
        );
    }

    @ParameterizedTest
    @MethodSource("arrays")
    void shouldReturn0_whenOneArraysIsEmpty(Integer[] arr1, Integer[] arr2) {
        var result = underTest.calculate(arr1, arr2);
        assertThat(result).isEqualTo(0);
    }


    private static Stream<Arguments> arrays() {
        return Stream.of(
                Arguments.of(EMPTY_ARRAY, EMPTY_ARRAY),
                Arguments.of(new Integer[]{10, 3}, EMPTY_ARRAY),
                Arguments.of(new Integer[]{10, 3, 5, 12, 54, 34}, EMPTY_ARRAY),
                Arguments.of(new Integer[]{0, -10, -34, -23, -3}, EMPTY_ARRAY)
        );
    }

    @Test
    void shouldReturn1_whenArraysAreEquivalent() {
        var result = underTest.calculate(new Integer[]{3}, new Integer[]{3});
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest(name = ARGUMENTS_PLACEHOLDER + " -> " + DISPLAY_NAME_PLACEHOLDER)
    @MethodSource("arraysWithOneCommonElement")
    void shouldReturn1_whenArraysAreOfDifferentSizeAndHaveOneCommonElement(Integer[] array1, Integer[] array2) {
        var result = underTest.calculate(array1, array2);
        assertThat(result).isEqualTo(1);
    }

    private static Stream<Arguments> arraysWithOneCommonElement() {
        return Stream.of(
                Arguments.of(new Integer[]{10, 3}, new Integer[]{3}),
                Arguments.of(new Integer[]{10, 3}, new Integer[]{3, 5}),
                Arguments.of(new Integer[]{10, 3, 5, 12, 54, 34}, new Integer[]{0, -10, -34, -23, 3})
        );
    }
}