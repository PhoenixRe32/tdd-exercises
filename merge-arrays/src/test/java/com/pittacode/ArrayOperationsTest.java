package com.pittacode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayOperationsTest {

    @Test
    void test1() {
        int[] a1 = {};
        int[] a2 = {};
        var result = ArrayOperations.merge(a1, a2);
        assertThat(result).containsExactly();
    }

    @Test
    void test2() {
        int[] a1 = {1, 2, 3};
        int[] a2 = {};
        var result = ArrayOperations.merge(a1, a2);
        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    void test3() {
        int[] a1 = {};
        int[] a2 = {1, 2, 3};
        var result = ArrayOperations.merge(a1, a2);
        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    void test4() {
        int[] a1 = {1};
        int[] a2 = {1, 2, 3};
        var result = ArrayOperations.merge(a1, a2);
        assertThat(result).containsExactly(1, 1, 2, 3);
    }

    @Test
    void test5() {
        int[] a1 = {1, 5, 6, 8, 10};
        int[] a2 = {1, 2, 3};
        var result = ArrayOperations.merge(a1, a2);
        assertThat(result).containsExactly(1, 1, 2, 3, 5, 6, 8, 10);
    }

    @Test
    void test6() {
        int[] a1 = {1, 5, 6, 8, 10};
        int[] a2 = {1, 5, 6, 8, 10};
        var result = ArrayOperations.merge(a1, a2);
        assertThat(result).containsExactly(1, 1, 5, 5, 6, 6, 8, 8, 10, 10);
    }

    @Test
    void test7() {
        int[] a1 = {1, 2, 6, 8, 10};
        int[] a2 = {1, 3, 6, 7, 10};
        var result = ArrayOperations.merge(a1, a2);
        assertThat(result).containsExactly(1, 1, 2, 3, 6, 6, 7, 8, 10, 10);
    }
}