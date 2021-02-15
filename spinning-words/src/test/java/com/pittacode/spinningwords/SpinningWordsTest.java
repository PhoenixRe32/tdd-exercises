package com.pittacode.spinningwords;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class SpinningWordsTest {

    private SpinningWords underTest;

    @BeforeEach
    void setUp() {
        underTest = new SpinningWords();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hey", "Hey you", "allo Andy how are you"})
    void shouldReturnWordsAsThey_whenTheyAreLessThan5Letters(String sentence) {
        assertThat(underTest.spinWords(sentence)).isEqualTo(sentence);
        assertThat(underTest.spinWords(sentence)).isEqualTo(sentence);
        assertThat(underTest.spinWords(sentence)).isEqualTo(sentence);
    }

    @Test
    void shouldReturnWordsReversed_whenTheyAreMoreThan5Letters1() {
        assertThat(underTest.spinWords("sentence")).isEqualTo("ecnetnes");
    }

    @Test
    void shouldReturnWordsReversed_whenTheyAreMoreThan5Letters2() {
        assertThat(underTest.spinWords("Hi Andrea how were you yesterday morning"))
                .isEqualTo("Hi aerdnA how were you yadretsey gninrom");
    }
}