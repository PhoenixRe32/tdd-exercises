package com.pittacode;

public class RomanConverter {

    public int convert(String romanNumber) {
        var romanSymbols = romanNumber.toCharArray();

        var sum = 0;
        for (Character romanSymbol : romanSymbols) {
            sum += getRomanSymbolValue(romanSymbol);
        }

        return sum;
    }

    private int getRomanSymbolValue(Character romanSymbol) {
        return RomanSymbol.from(romanSymbol)
                          .getValue();
    }
}
