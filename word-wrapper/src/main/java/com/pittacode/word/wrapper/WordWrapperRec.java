package com.pittacode.word.wrapper;

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;

import static java.lang.System.lineSeparator;
import static java.util.function.Predicate.not;

public class WordWrapperRec {

    private static final char SPACE = ' ';
    private static final char SEMICOLON = ';';
    private static final char COMMA = ',';
    private static final char PERIOD = '.';
    private static final char TAB = '\t';
    private static final Collection<Character> WORD_SEPARATORS = Set.of(SPACE, SEMICOLON, COMMA, PERIOD, TAB);

    private final int columnLimit;

    public WordWrapperRec(int columnLimit) {
        this.columnLimit = columnLimit;
    }

    public String wrap(String sentence) {
        if (sentence.length() <= columnLimit) {
            return sentence;
        } else if (isWordSeparator(sentence.charAt(columnLimit))) {
            return sentence.substring(0, columnLimit)
                    + lineSeparator()
                    + wrap(sentence.substring(columnLimit));
        } else {
            var steps = walkBackwardsWhile(not(matchingWordSeparator(sentence)), columnLimit);
            steps = columnLimit - steps == 0 ? 0 : steps;
            return sentence.substring(0, columnLimit - steps)
                    + lineSeparator()
                    + wrap(sentence.substring(columnLimit - steps));
        }
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

    private Predicate<Integer> matchingWordSeparator(String sentence) {
        return index -> isWordSeparator(sentence.charAt(index - 1));
    }
}
