package com.pittacode.word.wrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.ParameterizedTest.ARGUMENTS_PLACEHOLDER;
import static org.junit.jupiter.params.ParameterizedTest.DISPLAY_NAME_PLACEHOLDER;

class WordWrapperTest {

    private WordWrapper underTest;

    @BeforeEach
    void setUp() {
        underTest = new WordWrapper();
    }

    @ParameterizedTest(name = ARGUMENTS_PLACEHOLDER + " -> " + DISPLAY_NAME_PLACEHOLDER)
    @ValueSource(strings = {
            "word1 word2",
            "word1, word2",
            "word1. word2",
            "word1; word2",
            "word1: word2",
    })
    void should_split_words(String words) {
        var result = underTest.splitWords(words);

        assertThat(result).hasSize(2);
        assertThat(result[0]).startsWith("word1");
        assertThat(result[1]).startsWith("word2");
    }

    @ParameterizedTest(name = ARGUMENTS_PLACEHOLDER + " -> " + DISPLAY_NAME_PLACEHOLDER)
    @ValueSource(strings = {
            "word1:word2",
            "word1-word2",
            "word1_word2",
    })
    void should_not_split_words(String words) {
        var result = underTest.splitWords(words);

        assertThat(result).hasSize(1);
        assertThat(result[0]).startsWith("word1");
    }
}
