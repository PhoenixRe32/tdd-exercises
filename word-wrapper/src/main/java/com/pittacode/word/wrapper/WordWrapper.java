package com.pittacode.word.wrapper;

import java.util.regex.Pattern;

public class WordWrapper {
    private static final Pattern WORD_SEPARATORS = Pattern.compile("\\s|[;.,]\\s?");

    public String[] splitWords(String words) {
        return WORD_SEPARATORS.split(words);
    }
}
