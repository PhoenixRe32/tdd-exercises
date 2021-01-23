package com.pittacode;

import java.text.StringCharacterIterator;

import static java.text.CharacterIterator.DONE;

public class RomanConverter {

    public int convert(String romanNumber) {
        var romanNumberCharIterator = new StringCharacterIterator(romanNumber);

        var sum = 0;
        var currentCharacter = romanNumberCharIterator.current();
        while (currentCharacter != DONE) {
            var currentRomanSymbol = RomanSymbol.from(currentCharacter);

            var nextCharacter = romanNumberCharIterator.next();

            if (nextCharacter == DONE) {
                sum += currentRomanSymbol.getValue();
                currentCharacter = nextCharacter;
            } else {
                var nextRomanSymbol = RomanSymbol.from(nextCharacter);
                if (isNextRomanSymbolBigger(currentRomanSymbol, nextRomanSymbol)){
                    sum += (nextRomanSymbol.getValue() - currentRomanSymbol.getValue());
                    currentCharacter = romanNumberCharIterator.next();
                } else {
                    sum += currentRomanSymbol.getValue();
                    currentCharacter = nextCharacter;
                }
            }
        }

        return sum;
    }

    private boolean isNextRomanSymbolBigger(RomanSymbol currentRomanSymbol, RomanSymbol nextRomanSymbol) {
        return nextRomanSymbol.getValue() > currentRomanSymbol.getValue();
    }
}
