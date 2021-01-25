package com.pittacode.fizzbuzz;

public class FizzBuzzTranslator {

    private static final String BUZZ = "Buzz";
    private static final String FIZZ = "Fizz";

    public String translate(int input) {
        if (input < 1) {
            throw new IllegalArgumentException("Doesn't accept zero or negative values");
        }

        var result = "";

        if (isDivisibleBy3(input)) {
            result += FIZZ;
        }

        if (isDivisibleBy5(input)) {
            result += BUZZ;
        }

        return result.isBlank()
                ? String.valueOf(input)
                : result;
    }

    private boolean isDivisibleBy3(int input) {
        return input % 3 == 0;
    }

    private boolean isDivisibleBy5(int input) {
        return input % 5 == 0;
    }
}
