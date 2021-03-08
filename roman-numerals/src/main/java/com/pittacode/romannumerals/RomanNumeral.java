package com.pittacode.romannumerals;

import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RomanNumeral {

    public static final String MAGNITUDE_WARNING
            = "They must be withing same order of magintude. (e.g. [I,V,X], [X,L,C], [C,D,M])";
    public static final String SUBTRACT_ERROR
            = "Can't subtract %s from %s. " + MAGNITUDE_WARNING;
    private static final String REPEAT_ERROR
            = "Non subtractable symbol (" + RomanSymbol.getNonSubtractableSymbols() + ") repeated [%s at position %d]";
    private static final String ORDER_ERROR
            = "Non subtractable symbol (" + RomanSymbol.getNonSubtractableSymbols() + ") followed by a bigger symbol [%s at position %d]";

    private final List<RomanSymbol> symbols;

    public static String convert(int decimalNumber) {
        var thousands = decimalNumber / 1000;
        if (thousands >= 1) {
            return convertMultiplesOf10(thousands, RomanSymbol.M)
                    + convert(decimalNumber - thousands * 1_000);
        }

        var hundreds = decimalNumber / 100;
        if (hundreds >= 1) {
            return convertMultiplesOf10(hundreds, RomanSymbol.C)
                    + convert(decimalNumber - hundreds * 100);
        }

        var tens = decimalNumber / 10;
        if (tens >= 1) {
            return convertMultiplesOf10(tens, RomanSymbol.X)
                    + convert(decimalNumber - tens * 10);
        }

        return convertMultiplesOf10(decimalNumber, RomanSymbol.I);
    }

    private static String convertMultiplesOf10(int units, RomanSymbol magnituteSymbol) {
        if (units == 9) {
            return magnituteSymbol.name() + magnituteSymbol.getNextMagnitude().name();
        }
        if (units > 5) {
            return magnituteSymbol.getHalfwayMagnitude().name() + magnituteSymbol.name().repeat(units - 5);
        }
        if (units == 5) {
            return magnituteSymbol.getHalfwayMagnitude().name();
        }
        if (units == 4) {
            return magnituteSymbol.name() + magnituteSymbol.getHalfwayMagnitude().name();
        }
        return magnituteSymbol.name().repeat(units);
    }

    public RomanNumeral(int decimalNumber) {
        this(convert(decimalNumber));
    }

    public RomanNumeral(String romanNumber) {
        symbols = romanNumber.chars()
                             .mapToObj(i -> (char) i)
                             .map(RomanSymbol::from)
                             .collect(toList());
        validate();
    }

    private void validate() {
        for (int i = 0; i < symbols.size() - 1; i++) {
            if (isSymbolNonSubtractable(i)) {
                if (isSymbolRepeated(i)) {
                    throw new IllegalArgumentException(format(REPEAT_ERROR, symbols, i));
                }
                if (isSymbolFollowedByBiggerSymbol(i)) {
                    throw new IllegalArgumentException(format(ORDER_ERROR, symbols, i));
                }
            }
            if (isSymbolFollowedByBiggerSymbol(i)) {
                if (!areSymbolsWithinSameOrderOfMagnitude(i)) {
                    throw new IllegalArgumentException(format(SUBTRACT_ERROR, symbols.get(i), symbols.get(i + 1)));
                }
            }
        }
    }

    private boolean isSymbolNonSubtractable(int i) {
        return !symbols.get(i).isSubtractable();
    }

    private boolean isSymbolRepeated(int index) {
        return symbols.get(index) == symbols.get(index + 1);
    }

    private boolean isSymbolFollowedByBiggerSymbol(int index) {
        return isNotLastSymbol(index)
                && symbols.get(index + 1).getValue() > symbols.get(index).getValue();
    }

    private boolean isNotLastSymbol(int index) {
        return (index + 1) < symbols.size();
    }

    // NOTE: this can also be achieve by changing the enum
    // Instead of having a subtractable property
    // we can have the symbol that can be sutracted by the roman numeral.
    private boolean areSymbolsWithinSameOrderOfMagnitude(int i) {
        return symbols.get(i + 1).ordinal() - symbols.get(i).ordinal() <= 2;
    }

    public int decimalValue() {
        var sum = 0;

        for (int i = 0; i < symbols.size(); i++) {
            var currentRomanSymbol = symbols.get(i);
            sum = isSymbolFollowedByBiggerSymbol(i)
                    ? sum - currentRomanSymbol.getValue()
                    : sum + currentRomanSymbol.getValue();
        }

        return sum;
    }

    public String romanValue() {
        return symbols.stream()
                      .map(RomanSymbol::name)
                      .collect(joining());
    }
}