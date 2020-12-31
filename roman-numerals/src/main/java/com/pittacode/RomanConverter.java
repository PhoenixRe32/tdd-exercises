package com.pittacode;

public class RomanConverter {

    private static final String I = "I";
    private static final String V = "V";

    public int convert(String romanNumber) {
        if (romanNumber.equals(I)) {
            return 1;
        }

        if (romanNumber.equals(V)) {
            return 5;
        }

        return -1;
    }
}
