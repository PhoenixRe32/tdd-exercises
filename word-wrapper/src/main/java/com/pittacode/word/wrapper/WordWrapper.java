package com.pittacode.word.wrapper;

import java.util.regex.Pattern;

import static java.lang.System.lineSeparator;

public class WordWrapper {

    private static final char SPACE = ' ';
    private static final Pattern WORD_SEPARATORS = Pattern.compile("\\s+");

    public String wrap(String sentence, int column) {
        var words = splitWords(sentence);
        var wrappedSentence = new StringBuilder(sentence.length());
        var currentLineLength = 0;
        for (var word : words) {
            if (column - (currentLineLength + word.length()) == 0) {
                wrappedSentence.append(word).append(lineSeparator());
                currentLineLength = 0;
            } else if (column - (currentLineLength + word.length()) > 0) {
                wrappedSentence.append(word).append(SPACE);
                currentLineLength += word.length() + 1;
            } else {
                deleteLastCharacter(wrappedSentence);
                wrappedSentence.append(lineSeparator()).append(word).append(SPACE);
                currentLineLength = word.length() + 1;
            }
        }
        deleteLastCharacter(wrappedSentence);
        return wrappedSentence.toString();
    }

    private void deleteLastCharacter(StringBuilder wrappedSentence) {
        wrappedSentence.deleteCharAt(wrappedSentence.length() - 1);
    }

    public String[] splitWords(String words) {
        return WORD_SEPARATORS.split(words);
    }
}
