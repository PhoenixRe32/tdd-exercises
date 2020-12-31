package com.pittacode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class GreeterProxyTest {

    private GreeterProxy underTest;

    @BeforeEach
    void setUp() {
        underTest = new GreeterProxy();
    }

    @Test
    void whenPassesName_greetsUsingThatName() {
        var result = underTest.buildGreeting("Antoni");

        assertThat(result).isEqualTo("Hello, Antoni.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void whenNoNameIsPassed_greetUsingDefault(String noName) {
        var result = underTest.buildGreeting(noName);

        assertThat(result).isEqualTo("Hello, my friend.");
    }

    @Test
    void whenNameInCaps_greetShouting() {
        var result = underTest.buildGreeting("ANTONI");

        assertThat(result).isEqualTo("HELLO ANTONI!");
    }


    @Test
    void whenNameWithNonLettersInCaps_greetShouting() {
        var result = underTest.buildGreeting("ANNA-MARIA");

        assertThat(result).isEqualTo("HELLO ANNA-MARIA!");
    }

    @Test
    void whenTwoNamesArePassed_greetBothNames() {
        var result = underTest.buildGreeting(new String[]{"Antoni", "Anna-Maria"});

        assertThat(result).isEqualTo("Hello, Antoni and Anna-Maria.");
    }

    @Test
    void whenMultipleNamesArePassed_greetWithAllNamesSeperatedByComma() {
        var result = underTest.buildGreeting(new String[]{"Antoni", "Anna-Maria", "Chloi"});

        assertThat(result).isEqualTo("Hello, Antoni, Anna-Maria, and Chloi.");
    }

    @Test
    void whenMixedCaseNamesArePassed_greetNormallyAndWithShoutsSeperately() {
        var result = underTest.buildGreeting(new String[]{"Antoni", "Anna-Maria", "CHLOI"});

        assertThat(result).isEqualTo("Hello, Antoni and Anna-Maria. AND HELLO CHLOI!");
    }

    @Test
    void whenNameIsCommaSeperated_greetAsDifferentNames() {
        var result = underTest.buildGreeting(new String[]{"Antoni", "Anna-Maria, Chloi"});

        assertThat(result).isEqualTo("Hello, Antoni, Anna-Maria, and Chloi.");
    }

    @Test
    void whenNameIsCommaSeperatedButInQuotes_treatAsOneName() {
        var result = underTest.buildGreeting(new String[]{"Antoni", "\"Anna-Maria, Chloi\""});

        assertThat(result).isEqualTo("Hello, Antoni and Anna-Maria, Chloi.");
    }
}
