package com.pittacode.perfect.number;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FactorisationSupportTest {

    @Test
    void should_return_factors_of_6() {
        assertThat(FactorisationSupport.calculateFactors(6)).containsOnly(1L, 2L, 3L, 6L);
    }

    @Test
    void should_return_factors_of_36_without_containing_6_twice() {
        assertThat(FactorisationSupport.calculateFactors(36)).containsOnly(1L, 2L, 3L, 4L, 6L, 9L, 12L, 18L, 36L);
    }
}