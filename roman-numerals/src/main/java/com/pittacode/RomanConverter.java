package com.pittacode;

public class RomanConverter {

    private static final Character I = 'I';
    private static final Character V = 'V';
    private static final Character X = 'X';
    private static final Character L = 'L';
    private static final Character C = 'C';
    private static final Character D = 'D';
    private static final Character M = 'M';

    public int convert(String romanNumber) {
        var romanNumberSymbols = romanNumber.toCharArray();

        var sum = 0;
        for (Character romanSymbol : romanNumberSymbols) {
            sum += getRomanSymbolValue(romanSymbol);
        }

        return sum;
    }

    private int getRomanSymbolValue(Character romanSymbol) {
        if (romanSymbol.equals(I)) {
            return 1;
        }

        if (romanSymbol.equals(V)) {
            return 5;
        }

        if (romanSymbol.equals(X)) {
            return 10;
        }

        if (romanSymbol.equals(L)) {
            return 50;
        }

        if (romanSymbol.equals(C)) {
            return 100;
        }

        if (romanSymbol.equals(D)) {
            return 500;
        }

        if (romanSymbol.equals(M)) {
            return 1000;
        }

        throw new IllegalArgumentException(romanSymbol + " is not a roman numeral symbol.");
    }
}
