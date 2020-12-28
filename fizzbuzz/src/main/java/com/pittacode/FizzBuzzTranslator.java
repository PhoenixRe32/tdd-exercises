package com.pittacode;

public class FizzBuzzTranslator {

    private static final String BUZZ = "Buzz";
    private static final String FIZZ = "Fizz";

    public String translate(int input) {

        if (input < 1) {
            throw new IllegalArgumentException("Doesn't accept zero or negative values");
        }

        if (isDivisibleBy3(input) && isDivisibleBy5(input)) {
            return FIZZ + BUZZ;
        }

        if (isDivisibleBy5(input)) {
            return BUZZ;
        }

        if (isDivisibleBy3(input)) {
            return FIZZ;
        }

        return String.valueOf(input);
    }

    private boolean isDivisibleBy3(int input) {
        return input % 3 == 0;
    }

    private boolean isDivisibleBy5(int input) {
        return input % 5 == 0;
    }
}
