package com.pittacode.word.wrapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordWrapperTest {

    private WordWrapper underTest;

    @BeforeEach
    void setUp() {
        underTest = new WordWrapper();
    }

    @Test
    void should_split_sentence_in_correct_places1() {
        var sentence = "word1 word2 word3 word4 word5 word6 word7 word8 word9 word0";
        var expected = "word1 word2 word3 word4\nword5 word6 word7 word8\nword9 word0";
        var result = underTest.wrap(sentence, 25);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void should_split_sentence_in_correct_places2() {
        var sentence = "word1 word2 word3 word4 word5 word66 word7:word8 word9 word0";
        var expected = "word1 word2 word3\nword4 word5\nword66\nword7:word8 word9\nword0";
        var result = underTest.wrap(sentence, 17);

        assertThat(result).isEqualTo(expected);
    }
}
