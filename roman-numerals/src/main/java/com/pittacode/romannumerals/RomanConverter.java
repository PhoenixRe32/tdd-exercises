package com.pittacode.romannumerals;

public class RomanConverter {

    public int convert(String romanNumber) {
        var romanNumeral = new RomanNumeral(romanNumber);
        return romanNumeral.calculate();
    }
}
