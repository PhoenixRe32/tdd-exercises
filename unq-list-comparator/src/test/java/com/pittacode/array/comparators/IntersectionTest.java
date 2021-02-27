package com.pittacode.array.comparators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntersectionTest {

    public static final int[] EMPTY_ARRAY = new int[0];

    @BeforeEach
    void setUp() {
    }

    @Test
    void shouldReturn0_whenArraysHaveNothingInCommon() {
        var intersection = new Intersection();
        var result = intersection.calculate(new int[]{1}, new int[]{2});
        assertThat(result).isEqualTo(0);
    }

    @Test
    void shouldReturn0_whenBothArraysAreEmpty() {
        var intersection = new Intersection();
        var result = intersection.calculate(EMPTY_ARRAY, EMPTY_ARRAY);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void shouldReturn1_whenArraysAreEquivalent() {
        var intersection = new Intersection();
        var result = intersection.calculate(new int[]{3}, new int[]{3});
        assertThat(result).isEqualTo(1);
    }
}