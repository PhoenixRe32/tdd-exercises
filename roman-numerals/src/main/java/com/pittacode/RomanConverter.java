package com.pittacode;

import java.text.StringCharacterIterator;

import static java.text.CharacterIterator.DONE;

public class RomanConverter {

    public int convert(String romanNumber) {
        var romanNumberCharIterator = new StringCharacterIterator(romanNumber);

        var sum = 0;
        var currentCharacter = romanNumberCharIterator.first();
        while (currentCharacter != DONE) {
            var currentRomanSymbol = RomanSymbol.from(currentCharacter);

            var nextCharacter = romanNumberCharIterator.next();

            if (isIteratorAtEndOfString(nextCharacter)
                    || isNextRomanSymbolEqualOrSmaller(currentRomanSymbol,
                                                       RomanSymbol.from(nextCharacter))) {
                sum += getValueOfSymbol(currentRomanSymbol);
                currentCharacter = nextCharacter;
            } else {

                sum += getDifferenceOfCurrentSymbolAndTheNext(currentRomanSymbol,
                                                              RomanSymbol.from(nextCharacter));
                currentCharacter = romanNumberCharIterator.next();
            }
        }

        return sum;
    }

    private boolean isIteratorAtEndOfString(char nextCharacter) {
        return nextCharacter == DONE;
    }

    private boolean isNextRomanSymbolEqualOrSmaller(RomanSymbol currentRomanSymbol, RomanSymbol nextRomanSymbol) {
        return !isNextRomanSymbolBigger(currentRomanSymbol, nextRomanSymbol);
    }

    private boolean isNextRomanSymbolBigger(RomanSymbol currentRomanSymbol, RomanSymbol nextRomanSymbol) {
        return nextRomanSymbol.getValue() > currentRomanSymbol.getValue();
    }

    private int getValueOfSymbol(RomanSymbol currentRomanSymbol) {
        return currentRomanSymbol.getValue();
    }

    private int getDifferenceOfCurrentSymbolAndTheNext(RomanSymbol currentRomanSymbol, RomanSymbol nextRomanSymbol) {
        if (!currentRomanSymbol.isSubtractable()) {
            throw new IllegalArgumentException("Can't use " + currentRomanSymbol + " for subtraction");
        }

        if (!areSymbolsWithinSameOrderOfMagnitude(currentRomanSymbol, nextRomanSymbol)) {
            throw new IllegalArgumentException(
                    "Can't subtract " + currentRomanSymbol + " from " + nextRomanSymbol + ".\n" +
                            "They must be withing same order of magintude. (e.g. [I,V,X], [X,L,C], [C,D,M])");
        }

        return nextRomanSymbol.getValue() - currentRomanSymbol.getValue();
    }

    private boolean areSymbolsWithinSameOrderOfMagnitude(RomanSymbol currentRomanSymbol, RomanSymbol nextRomanSymbol) {
        return nextRomanSymbol.ordinal() - currentRomanSymbol.ordinal() <= 2;
    }
}
