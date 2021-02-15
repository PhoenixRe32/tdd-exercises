package com.pittacode.spinningwords;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SpinningWords {

    private static final String DELIMITER = " ";

    public String spinWords(String sentence) {
        return Arrays.stream(sentence.split(DELIMITER))
                     .map(this::reverseIfLongerThan4Chars)
                     .collect(Collectors.joining(DELIMITER));
    }

    private String reverseIfLongerThan4Chars(String word) {
        return word.length() < 5
                ? word
                : new StringBuilder(word).reverse().toString();
    }
}
