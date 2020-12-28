package com.pittacode;

public class FizzBuzzTranslator {

    public String translate(int input) {

        if (input % 3 == 0) {
            return "Fizz";
        }

        return String.valueOf(input);
    }
}
