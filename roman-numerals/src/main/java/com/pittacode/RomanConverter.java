package com.pittacode;

public class RomanConverter {

    private static final String I = "I";
    private static final String V = "V";
    private static final String X = "X";
    private static final String L = "L";
    public static final String C = "C";
    public static final String D = "D";

    public int convert(String romanNumber) {
        if (romanNumber.equals(I)) {
            return 1;
        }

        if (romanNumber.equals(V)) {
            return 5;
        }

        if (romanNumber.equals(X)) {
            return 10;
        }

        if (romanNumber.equals(L)) {
            return 50;
        }

        if (romanNumber.equals(C)) {
            return 100;
        }

        if (romanNumber.equals(D)) {
            return 500;
        }

        return -1;
    }
}
