package com.pittacode.word.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;

import static java.lang.System.lineSeparator;
import static java.util.function.Predicate.not;

public class WordWrapper {

    private static final char SPACE = ' ';
    private static final char SEMICOLON = ';';
    private static final char COMMA = ',';
    private static final char PERIOD = '.';
    private static final char TAB = '\t';
    private static final Collection<Character> WORD_SEPARATORS = Set.of(SPACE, SEMICOLON, COMMA, PERIOD, TAB);

    private final String sentence;

    public WordWrapper(String sentence) {
        this.sentence = sentence;
    }

    public String wrap(int columnLimit) {
        var wrappedSentence = new StringBuilder();
        var currentLineLength = 0;
        for (var token : splitTokens()) {
            if (currentLineLength + token.length() <= columnLimit) {
                wrappedSentence.append(token);
                currentLineLength += token.length();
            } else {
                wrappedSentence.append(lineSeparator()).append(token);
                currentLineLength = token.length();
            }
        }
        return wrappedSentence.toString();
    }

    private String[] splitTokens() {
        var index = 0;
        var tokens = new ArrayList<String>();
        while (index < sentence.length()) {
            var token = nextToken(index);
            tokens.add(token);
            index += token.length();
        }
        return tokens.toArray(new String[0]);
    }

    private String nextToken(int start) {
        var index = start;

        index += countCharacters(not(matchingWordSeparator()), index);

        if (index == sentence.length()) {
            return sentence.substring(start);
        }

        index += countCharacters(matchingWordSeparator(), index);
        return sentence.substring(start, index);
    }

    private int countCharacters(Predicate<Integer> predicate, int start) {
        var count = 0;
        while (start + count < sentence.length() && predicate.test(start + count)) {
            count += 1;
        }
        return count;
    }

    private boolean isWordSeparator(char currentChar) {
        return WORD_SEPARATORS.contains(currentChar);
    }

    private Predicate<Integer> matchingWordSeparator() {
        return index -> isWordSeparator(sentence.charAt(index));
    }
}
