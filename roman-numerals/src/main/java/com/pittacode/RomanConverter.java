package com.pittacode;

public class RomanConverter {

    public int convert(String romanNumber) {
        var romanNumberSymbols = romanNumber.toCharArray();

        var sum = 0;
        for (Character romanSymbol : romanNumberSymbols) {
            sum += getRomanSymbolValue(romanSymbol);
        }

        return sum;
    }

    private int getRomanSymbolValue(Character romanSymbol) {
        return RomanSymbol.from(romanSymbol)
                          .getValue();
    }
}
