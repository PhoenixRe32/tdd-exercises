package com.pittacode;

public class Application {

    private final FizzBuzzTranslator fizzBuzzTranslator;

    public Application(FizzBuzzTranslator fizzBuzzTranslator) {
        this.fizzBuzzTranslator = fizzBuzzTranslator;
    }

    public void run() {
        for (int i = 1; i<=100; i++) {
            System.out.println(fizzBuzzTranslator.translate(i));
        }
    }
}
