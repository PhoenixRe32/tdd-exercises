package com.pittacode.word.wrapper;

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;

import static java.lang.System.lineSeparator;
import static java.util.function.Predicate.not;

public class WordWrapper2 {

    private static final char SPACE = ' ';
    private static final char SEMICOLON = ';';
    private static final char COMMA = ',';
    private static final char PERIOD = '.';
    private static final char TAB = '\t';
    private static final Collection<Character> WORD_SEPARATORS = Set.of(SPACE, SEMICOLON, COMMA, PERIOD, TAB);

    private final String sentence;

    public WordWrapper2(String sentence) {
        this.sentence = sentence;
    }

    public String wrap(int columnLimit) {
        var startIndex = 0;
        var wrappedSentence = new StringBuilder(Double.valueOf(sentence.length() * 1.5).intValue());
        while (startIndex < sentence.length()) {

            var endOfLineIndex = startIndex + columnLimit;

            if (isRestOfSentenceSmallerThanMaxLineLength(endOfLineIndex)) {
                wrappedSentence.append(sentence.substring(startIndex));
                startIndex = sentence.length();
            } else if (isEndOfCurrentLineAWordSeparator(endOfLineIndex)) {
                wrappedSentence.append(sentence.substring(startIndex, endOfLineIndex)).append(lineSeparator());
                startIndex = endOfLineIndex;
            } else {
                var steps = walkBackwardsWhile(not(matchingWordSeparator()), endOfLineIndex);
                if (endOfLineIndex - steps == startIndex) {
                    steps =0;
                }
                wrappedSentence.append(sentence.substring(startIndex, endOfLineIndex - steps)).append(lineSeparator());
                startIndex = startIndex + columnLimit - steps;
            }
        }

        return wrappedSentence.toString();
    }

    private boolean isRestOfSentenceSmallerThanMaxLineLength(int endOfLineIndex) {
        return endOfLineIndex > sentence.length();
    }

    private boolean isEndOfCurrentLineAWordSeparator(int endOfLineIndex) {
        return isWordSeparator(sentence.charAt(endOfLineIndex - 1));
    }

    private int walkBackwardsWhile(Predicate<Integer> predicate, int start) {
        var count = 0;
        while (start - count > 0 && predicate.test(start - count)) {
            count += 1;
        }
        return count;
    }

    private boolean isWordSeparator(char currentChar) {
        return WORD_SEPARATORS.contains(currentChar);
    }

    private Predicate<Integer> matchingWordSeparator() {
        return index -> isWordSeparator(sentence.charAt(index - 1));
    }
}
