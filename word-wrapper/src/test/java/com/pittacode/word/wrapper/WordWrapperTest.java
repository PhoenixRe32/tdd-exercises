package com.pittacode.word.wrapper;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordWrapperTest {

    private WordWrapper underTest;

    @Test
    void should_split_sentence_in_correct_places() {
        var sentence = "word1 word2, word3,word4. word5.word6; word7;word8: word9:word0 word;,. ";

        underTest = new WordWrapper(sentence);

        var expected17 = "word1 word2, \nword3,word4. \nword5.word6; \nword7;word8: \nword9:word0 \nword;,. ";
        assertThat(underTest.wrap(17)).isEqualTo(expected17);

        var expected5 = "word1 word2, word3,word4. \nword5.word6; word7;word8: \nword9:word0 word;,. ";
        assertThat(underTest.wrap(26)).isEqualTo(expected5);

        var expected7 = "word1 \nword2, \nword3,\nword4. \nword5.\nword6; \nword7;\nword8: \nword9:word0 \nword;,. ";
        assertThat(underTest.wrap(7)).isEqualTo(expected7);
    }

    @Test
    void should_split_into_words() {
        var sentence = "word1 word2, word3,word4. word5.word6; word7;word8: word9:word0 word;,. ";

        underTest = new WordWrapper(sentence);
        assertThat(underTest.splitTokens()).isEqualTo(new String[]{
                "word1 ", "word2, ", "word3,", "word4. ", "word5.", "word6; ", "word7;", "word8: ", "word9:word0 ", "word;,. "
        });
    }


    @Test
    void should_get_next_token() {
        var sentence = "word1 word2, word3,word4. word5.word6; word7;word8: word9:word0 word;,. ";

        underTest = new WordWrapper(sentence);
        assertThat(underTest.nextToken(0)).isEqualTo("word1 ");
        assertThat(underTest.nextToken(6)).isEqualTo("word2, ");
        assertThat(underTest.nextToken(13)).isEqualTo("word3,");
        assertThat(underTest.nextToken(19)).isEqualTo("word4. ");
        assertThat(underTest.nextToken(26)).isEqualTo("word5.");
        assertThat(underTest.nextToken(32)).isEqualTo("word6; ");
        assertThat(underTest.nextToken(39)).isEqualTo("word7;");
        assertThat(underTest.nextToken(45)).isEqualTo("word8: ");
        assertThat(underTest.nextToken(52)).isEqualTo("word9:word0 ");
        assertThat(underTest.nextToken(64)).isEqualTo("word;,. ");
    }
}
