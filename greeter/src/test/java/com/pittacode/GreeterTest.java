package com.pittacode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GreeterTest {

    @Test
    void whenPassesName_greetsUsingThatName() {
        var underTest = new Greeter();

        var result = underTest.greet("Antoni");

        assertThat(result).isEqualTo("Hello, Antoni.");
    }
}
