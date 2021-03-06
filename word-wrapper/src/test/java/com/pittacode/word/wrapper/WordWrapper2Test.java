package com.pittacode.word.wrapper;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordWrapper2Test {

    // Slight difference on how to handle the word delimiter characters
    @Test
    void should_split_sentence_in_correct_places() {
        var sentence = "word1 word2, word3,word4. word5.word6; word7;word8: word9:word0 word";

        var underTest = new WordWrapper2(sentence);

        var expected17 = "word1 word2, \nword3,word4. \nword5.word6; \nword7;word8: \nword9:word0 word";
        assertThat(underTest.wrap(17)).isEqualTo(expected17);

        var expected5 = "word1 word2, word3,word4. \nword5.word6; word7;word8: \nword9:word0 word";
        assertThat(underTest.wrap(26)).isEqualTo(expected5);

        var expected7 = "word1 \nword2, \nword3,\nword4. \nword5.\nword6; \nword7;\nword8: \nword9:w\nord0 \nword";
        assertThat(underTest.wrap(7)).isEqualTo(expected7);
    }

    @Test
    void lorem_ipsum_test() {
        var sentence = "Lorem Ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        var underTest = new WordWrapper2(sentence);
        System.out.println(underTest.wrap(65));
        assertThat(true).isTrue();
    }
}
