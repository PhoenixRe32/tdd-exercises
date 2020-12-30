package com.pittacode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Collectors;

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

    @Test
    void whenNameInCaps_greetShouting() {
        var result = underTest.greet("ANTONI");

        assertThat(result).isEqualTo("HELLO, ANTONI.");
    }


    @Test
    void whenNameWithNonLettersInCaps_greetShouting() {
        var result = underTest.greet("ANNA-MARIA");

        assertThat(result).isEqualTo("HELLO, ANNA-MARIA.");
    }

    @Test
    void whenTwoNamesArePassed_greetBothNames() {
        var result = underTest.greet(new String[]{"Antoni", "Anna-Maria"});

        assertThat(result).isEqualTo("Hello, Antoni and Anna-Maria.");
    }

    @Test
    void whenMultipleNamesArePassed_greetWithAllNamesSeperatedByComma() {
        var result = underTest.greet(new String[]{"Antoni", "Anna-Maria", "Chloi"});

        assertThat(result).isEqualTo("Hello, Antoni, Anna-Maria, and Chloi.");
    }

    @Test
    void whenMixedCaseNamesArePassed_greetNormallyAndWithShoutsSeperately() {
        var result = underTest.greet(new String[]{"Antoni", "Anna-Maria", "CHLOI"});

        assertThat(result).isEqualTo("Hello, Antoni and Anna-Maria. AND HELLO CHLOI.");
    }
}
