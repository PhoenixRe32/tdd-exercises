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

            if (isNextCharacterEndOfString(nextCharacter)) {
                sum += getValue(currentRomanSymbol);
            } else if (isNextRomanSymbolEqualOrSmaller(currentRomanSymbol, RomanSymbol.from(nextCharacter))) {
                sum += getValue(currentRomanSymbol);
            } else {
                sum -= getValue(currentRomanSymbol, RomanSymbol.from(nextCharacter));

            }
            currentCharacter = nextCharacter;
        }

        return sum;
    }

    private int getValue(RomanSymbol currentRomanSymbol) {
        return currentRomanSymbol.getValue();
    }

    private int getValue(RomanSymbol currentRomanSymbol, RomanSymbol nextRomanSymbol) {
        if (!currentRomanSymbol.isSubtractable()) {
            throw new IllegalArgumentException("Can't use " + currentRomanSymbol + " for subtraction");
        }

        if (!areSymbolsWithinSameOrderOfMagnitude(currentRomanSymbol, nextRomanSymbol)) {
            throw new IllegalArgumentException(
                    "Can't subtract " + currentRomanSymbol + " from " + nextRomanSymbol + ".\n" +
                            "They must be withing same order of magintude. (e.g. [I,V,X], [X,L,C], [C,D,M])");
        }
        return currentRomanSymbol.getValue();
    }

    private boolean areSymbolsWithinSameOrderOfMagnitude(RomanSymbol currentRomanSymbol, RomanSymbol nextRomanSymbol) {
        return nextRomanSymbol.ordinal() - currentRomanSymbol.ordinal() <= 2;
    }

    private boolean isNextCharacterEndOfString(char nextCharacter) {
        return nextCharacter == DONE;
    }

    private boolean isNextRomanSymbolEqualOrSmaller(RomanSymbol currentRomanSymbol, RomanSymbol nextRomanSymbol) {
        return !isNextRomanSymbolBigger(currentRomanSymbol, nextRomanSymbol);
    }

    private boolean isNextRomanSymbolBigger(RomanSymbol currentRomanSymbol, RomanSymbol nextRomanSymbol) {
        return nextRomanSymbol.getValue() > currentRomanSymbol.getValue();
    }
}
