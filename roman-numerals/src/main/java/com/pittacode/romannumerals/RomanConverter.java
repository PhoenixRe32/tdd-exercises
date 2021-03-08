package com.pittacode.romannumerals;

public class RomanConverter {

    public int convert(String romanNumber) {
        var romanNumeral = new RomanNumeral(romanNumber);
        return romanNumeral.decimalValue();
    }

    public String convert(int decimalNumber) {
        var romanNumeral = new RomanNumeral(decimalNumber);
        return romanNumeral.romanValue();
    }
}
