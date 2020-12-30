package com.pittacode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GreeterTest {

    private Greeter underTest;

    @BeforeEach
    void setUp() {
        underTest = new Greeter();
    }

    @Test
    void whenPassesName_greetsUsingThatName() {
        var result = underTest.greet("Antoni");

        assertThat(result).isEqualTo("Hello, Antoni.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void whenNoNameIsPassed_greetUsingDefault(String noName) {
        var result = underTest.greet(noName);

        assertThat(result).isEqualTo("Hello, my friend.");
    }
}
